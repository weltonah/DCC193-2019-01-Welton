package br.com.dcc193.dcc193201901welton.dao;

import br.com.dcc193.dcc193201901welton.model.Menbro;
import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenbroRepository extends JpaRepository<Menbro,Long> {

    List<Menbro> findByRefSede(Sede sede);
}
