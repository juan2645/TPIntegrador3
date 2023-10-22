package com.example.tpintegrador3.Interfaces;

import com.example.tpintegrador3.Service.DTO.EstudianteDTO;
import com.example.tpintegrador3.Entidades.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    void altaEstudiante(String nombre, String apellido, int edad, String genero, int nroDocumento,
                        String ciudadResidencia, int nroLibreta);
    List<EstudianteDTO> recuperarEstudiantesOrdenados(String criterioOrdenamiento);
    List<EstudianteDTO> recuperarEstudiantesPorGenero(String genero);
    List<EstudianteDTO> getEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudadResidencia);
    void matricularEstudianteEnCarrera(int idEstudiante, int idCarrera);
    EstudianteDTO recuperarEstudiantePorLibreta(int nroLibreta);
    Estudiante getEstudianteById(int idEstudiante);


}
