package com.coderscampus.finalproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.finalproject.domain.Paciente;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    @Query("SELECT p FROM Paciente p WHERE p.email = ?1")
    Optional<Paciente> findByEmail(String email);
}