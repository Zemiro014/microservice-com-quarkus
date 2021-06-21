package com.github.jeronimo.ifood.mp.activeMQ;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jeronimo.ifood.mp.entities.Restaurante;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.pgclient.PgPool;

@ApplicationScoped
@JsonIgnoreProperties
@Blocking
public class RestauranteCadastrado {    

	@Inject
	PgPool pgPool;
    
    @Incoming("restaurantes")
    @io.smallrye.reactive.messaging.annotations.Blocking
    public void receberRestaurante(JsonObject json){
        Restaurante restaurante = json.mapTo(Restaurante.class);
		System.out.println("-----------------------------");
		System.out.println(json);
		System.out.println("-----------------------------");
		System.out.println(restaurante);
    }
}
