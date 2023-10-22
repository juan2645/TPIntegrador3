package com.example.tpintegrador3.Service.DTO.Estudiante.Response;


import com.example.tpintegrador3.Entidades.Estudiante;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {
    private final String fullName;
    private final String genero;
    private final String ciudadResidencia;
    private final int edad;
    private final int nroDocumento;
    private final int nroLibreta;


    public EstudianteResponseDTO( Estudiante e ) {
        this.fullName = e.getNombre() + e.getApellido();
        this.genero = e.getGenero();
        this.ciudadResidencia = e.getCiudadResidencia();
        this.edad = e.getEdad();
        this.nroDocumento = e.getNroDocumento();
        this.nroLibreta = e.getNroLibreta();
    }


}
