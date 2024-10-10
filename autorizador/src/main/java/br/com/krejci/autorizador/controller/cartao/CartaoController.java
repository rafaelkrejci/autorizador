package br.com.krejci.autorizador.controller.cartao;

import br.com.krejci.autorizador.domain.Cartao;
import br.com.krejci.autorizador.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {


    @Autowired
    private CartaoService cartaoService;
    /**
     * Method: POST
     * URL: http://localhost:8080/cartoes
     * Body (json):
     * {
     *     "numeroCartao": "6549873025634501",
     *     "senha": "1234"
     * }
     *
     * Criação com sucesso:
     *    Status Code: 201
     *    Body (json):
     *    {
     *       "senha": "1234",
     *       "numeroCartao": "6549873025634501"
     *    }
     * -----------------------------------------
     * Caso o cartão já exista:
     *    Status Code: 422
     *    Body (json):
     *    {
     *       "senha": "1234",
     *       "numeroCartao": "6549873025634501"
     *    }
     */

    @PostMapping()
    public ResponseEntity<CartaoDTO> create(@RequestBody CartaoDTO cartaoDTO){

        Cartao cartaoDomain = cartaoService.create(new Cartao(cartaoDTO.getNumeroDoCartao(), cartaoDTO.getSenha()));

        return new ResponseEntity(new CartaoDTO(cartaoDomain.getNumeroCartao(),cartaoDomain.getSenha()), HttpStatus.CREATED);
    }
    /**Method: GET
    URL: http://localhost:8080/cartoes/{numeroCartao} , onde {numeroCartao} é o número do cartão que se deseja consultar
    Possíveis respostas:
    Obtenção com sucesso:
    Status Code: 200
    Body: 495.15
            -----------------------------------------
    Caso o cartão não exista:
    Status Code: 404
    Sem Body*/

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<?> getSaldo(@PathVariable String numeroCartao){

        return ResponseEntity.ok(cartaoService.findByNumeroCartao(numeroCartao).getSaldo());

    }
}
