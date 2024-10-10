package br.com.krejci.autorizador.repository;

import br.com.krejci.autorizador.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByNumeroCartao(String numerCartao);
}
