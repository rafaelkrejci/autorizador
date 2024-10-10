package br.com.krejci.autorizador.service;

import br.com.krejci.autorizador.domain.Cartao;
import br.com.krejci.autorizador.exception.CartaoNaoEncontradoException;
import br.com.krejci.autorizador.exception.CriacaoCartaoJaExistenteException;
import br.com.krejci.autorizador.exception.TransacaoException;
import br.com.krejci.autorizador.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao create(Cartao cartao){
        if(cartaoRepository.findByNumeroCartao(cartao.getNumeroCartao()).isPresent()){
            throw new CriacaoCartaoJaExistenteException();
        }
        return cartaoRepository.save(cartao);
    }
    public Cartao update(Cartao cartao){
        if(cartaoRepository.findByNumeroCartao(cartao.getNumeroCartao()).isPresent()){
            cartao = cartaoRepository.save(cartao);
        }
        return cartao;
    }
    public Cartao findByNumeroCartao(String numeroCartao){

        return cartaoRepository.findByNumeroCartao(numeroCartao).orElseThrow(CartaoNaoEncontradoException::new);
    }
}
