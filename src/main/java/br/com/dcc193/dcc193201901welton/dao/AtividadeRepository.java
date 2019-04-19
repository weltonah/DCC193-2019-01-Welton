package br.com.dcc193.dcc193201901welton.dao;

import br.com.dcc193.dcc193201901welton.model.Atividade;
import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findBySede(Sede sede);
}
