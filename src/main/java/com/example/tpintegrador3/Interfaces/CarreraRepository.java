package com.example.tpintegrador3.Interfaces;

import com.example.tpintegrador3.DTO.CarreraDTO;
import com.example.tpintegrador3.Entidades.Carrera;

import java.util.List;

public interface CarreraRepository {
	void altaCarreras(String nombreCarrera);
	CarreraDTO obtenerCarreraPorId(int idCarrera);
	List<CarreraDTO> obtenerCarrerasInscriptos();
	List<CarreraDTO> obtenerTodasLasCarreras();
	Carrera getCarreraById(int idCarrera);
}
