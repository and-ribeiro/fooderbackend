package com.fooder.fooder.repository;


import com.fooder.fooder.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
