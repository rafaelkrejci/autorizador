package br.com.krejci.autorizador.controller.transacao;

import lombok.Data;

@Data
public class TransacaoDTO {

    private String numeroCartao;
    private String senhaCartao;
    private Double valor;

}
