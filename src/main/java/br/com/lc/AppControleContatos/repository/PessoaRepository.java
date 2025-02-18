package br.com.lc.AppControleContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lc.AppControleContatos.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {	

}


