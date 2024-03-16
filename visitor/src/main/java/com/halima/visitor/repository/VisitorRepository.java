package com.halima.visitor.repository;

import com.halima.visitor.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    Optional<Visitor> findByEmail(String email);
    Optional<Visitor> findByUsername(String username);
}
