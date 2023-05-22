package com.coderscampus.finalproject.service;

import java.util.List;
import java.util.Optional;

import com.coderscampus.finalproject.exceptions.ResourceNotFoundException;
import com.example.clinica_dental.dto.TurnoDTO;

public interface ITurnoService {

    TurnoDTO guardar(TurnoDTO turno);
    Optional<TurnoDTO> busquedaXid(Long id) throws ResourceNotFoundException;
    TurnoDTO actualizarTurno(TurnoDTO turnoDTO) throws Exception;
    void borrarTurno(Long id) throws ResourceNotFoundException;
    List<TurnoDTO> buscarTodos();
}