package com.halima.guidtourservice.repository;

import com.halima.guidtourservice.model.GuidTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidTourRepository extends JpaRepository<GuidTour, Integer> {
}
