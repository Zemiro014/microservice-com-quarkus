package com.github.jeronimo.ifood.mp.activeMQ;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.github.jeronimo.ifood.mp.entities.Restaurante;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.common.annotation.Blocking;
import io.vertx.mutiny.pgclient.PgPool;

// Class que recebe os eventos dos Restaurantes para MarktePlace a partir do ActiveMQ
@ApplicationScoped
public class RestauranteCadastrado {    

	@Inject
	PgPool pgPool;
    
    @Incoming("restaurantes")
	@Blocking
    public void receberRestaurante(String json){
		Jsonb create = JsonbBuilder.create();
        Restaurante restaurante = create.fromJson(json, Restaurante.class);
		System.out.println("-----------------------------");
		System.out.println(json);
		System.out.println("-----------------------------");
		System.out.println(restaurante);

		restaurante.persiste(pgPool);
    }
}
