package br.com.krejci.autorizador.controller.transacao;

import br.com.krejci.autorizador.controller.cartao.CartaoDTO;
import br.com.krejci.autorizador.domain.Cartao;
import br.com.krejci.autorizador.service.CartaoService;
import br.com.krejci.autorizador.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
     /**
     * Method: POST
     * URL: http://localhost:8080/transacoes
     * Body (json):
     * {
     *     "numeroCartao": "6549873025634501",
     *     "senhaCartao": "1234",
     *     "valor": 10.00
     * }
     * Possíveis respostas:
     * Transação realizada com sucesso:
     *    Status Code: 201
     *    Body: OK
     * -----------------------------------------
     * Caso alguma regra de autorização tenha barrado a mesma:
     *    Status Code: 422
     *    Body: SALDO_INSUFICIENTE|SENHA_INVALIDA|CARTAO_INEXISTENTE (dependendo da regra que impediu a autorização)
     */

     @Autowired
     private CartaoService cartaoService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TransacaoDTO transacao){

        transacaoService.execute(transacao);
        return new ResponseEntity("OK", HttpStatus.CREATED);
    }
}
