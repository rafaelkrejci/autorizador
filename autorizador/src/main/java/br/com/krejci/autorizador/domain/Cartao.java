package br.com.krejci.autorizador.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity(name = "Cartoes")
public class Cartao implements Domain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroCartao;
    private String senha;
    private Double saldo;

    public Cartao (String numeroCartao, String senha){
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.saldo = 500.00;
    }
    public Cartao(){}
}
