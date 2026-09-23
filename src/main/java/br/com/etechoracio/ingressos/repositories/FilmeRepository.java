package br.com.etechoracio.ingressos.repositories;

import br.com.etechoracio.ingressos.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository <Filme, Long> {

}
