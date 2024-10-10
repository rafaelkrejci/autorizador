package br.com.krejci.autorizador.helper;

import br.com.krejci.autorizador.controller.transacao.TransacaoDTO;
import br.com.krejci.autorizador.controller.transacao.TransacaoEnum;
import br.com.krejci.autorizador.domain.Cartao;
import br.com.krejci.autorizador.exception.TransacaoException;

public class TransacaoHelper {

    public static void  validate(TransacaoDTO transacao , Cartao cartao){

        if(cartao == null){
            throw new TransacaoException(TransacaoEnum.CARTAO_INEXISTENTE.name());
        }

        if(!transacao.getSenhaCartao().equals(cartao.getSenha())){
            throw new TransacaoException(TransacaoEnum.SENHA_INVALIDA.name());
        }

        Double saldoCartao = cartao.getSaldo();
        Double saldoTransacao = transacao.getValor();
        Double deltaSaldo = Double.sum(saldoCartao, saldoTransacao);
        if(deltaSaldo < 0){
            throw new TransacaoException(TransacaoEnum.SALDO_INSUFICIENTE.name());
        }
    }
}
