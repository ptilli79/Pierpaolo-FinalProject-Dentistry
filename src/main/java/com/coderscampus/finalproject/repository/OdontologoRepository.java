package com.coderscampus.finalproject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.finalproject.domain.Odontologo;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

	Optional<Odontologo> findByMatricula(String matricula);
}
