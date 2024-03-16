package com.halima.villeservice.repository;

import com.halima.villeservice.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Long> {
}
