package br.com.krejci.autorizador.exception;

public class TransacaoException extends RuntimeException{
    public TransacaoException(String message){
        super(message);
    }
}
