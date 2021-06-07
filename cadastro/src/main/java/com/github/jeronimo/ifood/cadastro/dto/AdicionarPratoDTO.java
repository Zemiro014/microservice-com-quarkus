package com.github.jeronimo.ifood.cadastro.dto;

import java.math.BigDecimal;

import com.github.jeronimo.ifood.cadastro.infra.DTO;
import com.github.jeronimo.ifood.cadastro.infra.ValidDTO;

@ValidDTO
public class AdicionarPratoDTO implements DTO{

    public String nome;	
	public String descricao;	
	public BigDecimal preco;
}
