package br.com.etechoracio.ingressos.repositories;

import br.com.etechoracio.ingressos.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Override
    Optional<Sala> findById(Long aLong);
}
