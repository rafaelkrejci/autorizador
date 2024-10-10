package br.com.krejci.autorizador.configuration;

import br.com.krejci.autorizador.exception.CartaoNaoEncontradoException;
import br.com.krejci.autorizador.exception.CriacaoCartaoJaExistenteException;
import br.com.krejci.autorizador.exception.TransacaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler(CriacaoCartaoJaExistenteException.class)
    public void cartaoJaExistente() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(CartaoNaoEncontradoException.class)
    public void cartaoNaoEncontrado() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler(TransacaoException.class)
    public void transacaoNaoPermetida() {
        // Nothing to do
    }
}
