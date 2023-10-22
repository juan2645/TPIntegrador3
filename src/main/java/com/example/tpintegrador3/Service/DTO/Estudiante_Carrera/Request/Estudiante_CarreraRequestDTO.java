package com.example.tpintegrador3.Service.DTO.Estudiante_Carrera.Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class Estudiante_CarreraRequestDTO {

        private String nombreCarrera;
        private int year;
        private long inscriptos;
        private long egresados;
}
