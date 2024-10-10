package br.com.krejci.autorizador.controller.cartao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartaoDTO {

    private String numeroDoCartao;
    private String  senha;

}
