package br.com.dcc193.dcc193201901welton.dao;

import br.com.dcc193.dcc193201901welton.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long> {
}
