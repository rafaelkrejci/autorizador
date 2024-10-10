package br.com.krejci.autorizador.service;

import br.com.krejci.autorizador.controller.transacao.TransacaoDTO;
import br.com.krejci.autorizador.domain.Cartao;
import br.com.krejci.autorizador.helper.TransacaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private CartaoService cartaoService;
    public Cartao execute(TransacaoDTO transacao){
        Cartao cartao = cartaoService.findByNumeroCartao(transacao.getNumeroCartao());
        TransacaoHelper.validate(transacao,cartao);
        Double deltaSaldo = Double.sum(cartao.getSaldo(), transacao.getValor() * -1);
        cartao.setSaldo(deltaSaldo);
        return cartaoService.update(cartao);
    }
}
