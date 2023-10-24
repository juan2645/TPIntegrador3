package com.example.tpintegrador3.Service.DTO.Carrera.Response;

import com.example.tpintegrador3.Entidades.Carrera;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private String nombre;
    private int cantEstudiante;

    public CarreraResponseDTO(Carrera c){
        this.nombre = c.getNombre();
        this.cantEstudiante = c.getEstudianteCarrera().size();
    }


}
