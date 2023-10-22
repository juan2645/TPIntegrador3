package com.example.tpintegrador3.Interfaces;

import com.example.tpintegrador3.Service.DTO.Estudiante_CarreraDTO;
import com.example.tpintegrador3.Entidades.Carrera;
import com.example.tpintegrador3.Entidades.Estudiante;

import java.util.List;

public interface Estudiante_CarreraRepository {

	void altaMatricula(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado);

	List<Estudiante_CarreraDTO> obtenerReporte();

}
