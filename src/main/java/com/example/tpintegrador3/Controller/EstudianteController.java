package com.example.tpintegrador3.Controller;

import com.example.tpintegrador3.Service.DTO.Estudiante.Request.EstudianteRequestDTO;
import com.example.tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import com.example.tpintegrador3.Service.EstudianteService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/estudiante")
public class EstudianteController {

    private EstudianteService estudianteService;


    @RequestMapping("/findAll")
    public List<EstudianteResponseDTO> findAll() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findAll();
        return estudiantes;
    }

    @RequestMapping("/findById/{id}")
    public EstudianteResponseDTO findById(String id) {
        Long _id = Long.valueOf(id);
        EstudianteResponseDTO estudiante = estudianteService.findById(_id);
        return estudiante;
    }

    @RequestMapping("/save")
    public EstudianteResponseDTO save(EstudianteRequestDTO request) {
        EstudianteResponseDTO estudiante = estudianteService.save(request);
        return estudiante;
    }

    @RequestMapping("/findAllOrderByName")
    public List<EstudianteResponseDTO> findAllOrderByName() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findAllOrderByName();
        return estudiantes;
    }

    @RequestMapping("/findByGenero/{genero}")
    public List<EstudianteResponseDTO> findByGenero(String genero) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findByGenero(genero);
        return estudiantes;
    }

    @RequestMapping("/findByNroLibreta/{nroLibreta}")
    public EstudianteResponseDTO findByNroLibreta(String nroLibreta) {
        int _nroLibreta = Integer.valueOf(nroLibreta);
        EstudianteResponseDTO estudiante = estudianteService.findByNroLibreta(_nroLibreta);
        return estudiante;
    }

    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteResponseDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);
        return estudiantes;
    }

}
