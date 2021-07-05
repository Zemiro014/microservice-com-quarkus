package com.github.jeronimo.ifood.mp.kafka;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.jeronimo.ifood.mp.dto.PedidoRealizadoDTO;
import com.github.jeronimo.ifood.mp.dto.PratoDTO;
import com.github.jeronimo.ifood.mp.dto.PratoPedidoDTO;
import com.github.jeronimo.ifood.mp.dto.RestauranteDTO;
import com.github.jeronimo.ifood.mp.entities.Prato;
import com.github.jeronimo.ifood.mp.entities.PratoCarrinho;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Uni;

@Path("carrinho")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {

    private static final String CLIENTE = "a";

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @Inject
    @Channel("pedidos")
    Emitter<PedidoRealizadoDTO> emitterPedido;

    @GET
    public Uni<List<PratoCarrinho>> buscarcarrinho() {
        return PratoCarrinho.findCarrinho(client, CLIENTE);
    }

    @POST
    @Path("/prato/{idPrato}")
    public Uni<String> adicionarPrato(@PathParam("idPrato") Long idPrato) {
        //poderia retornar o pedido atual
        PratoCarrinho pc = new PratoCarrinho();
        pc.setCliente(CLIENTE);
        pc.setIdPrato(idPrato);
        return PratoCarrinho.save(client, CLIENTE, idPrato);
    }

    @POST
    @Path("/realizar-pedido")
    public Uni<Boolean> finalizar() {
        PedidoRealizadoDTO pedido = new PedidoRealizadoDTO();
        String cliente = CLIENTE;
        pedido.setCliente(cliente);
        List<PratoCarrinho> pratoCarrinho = PratoCarrinho.findCarrinho(client, cliente).await().indefinitely();
        //Utilizar mapstruts
        List<PratoPedidoDTO> pratos = pratoCarrinho.stream().map(pc -> from(pc)).collect(Collectors.toList());
        pedido.setPratos(pratos);

        RestauranteDTO restaurante = new RestauranteDTO();
        restaurante.setNome("nome restaurante");
        pedido.setRestaurante(restaurante);
        emitterPedido.send(pedido);
        return PratoCarrinho.delete(client, cliente);
    }

    private PratoPedidoDTO from(PratoCarrinho pratoCarrinho) {
        PratoDTO dto = Prato.findById(client, pratoCarrinho.getIdPrato()).await().indefinitely();
        return new PratoPedidoDTO(dto.getNome(), dto.getDescricao(), dto.getPreco());
    }
}