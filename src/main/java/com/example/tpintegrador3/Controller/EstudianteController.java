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

    @RequestMapping("/search")
    public List<EstudianteResponseDTO> search(EstudianteRequestDTO request) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.search(request);
        return estudiantes;
    }

}
