package com.example.tpintegrador3.Service;

import com.example.tpintegrador3.Entidades.Estudiante;
import com.example.tpintegrador3.Entidades.Estudiante_Carrera;
import com.example.tpintegrador3.Repository.EstudianteRepository;
import com.example.tpintegrador3.Repository.Estudiante_CarreraRepository;
import com.example.tpintegrador3.Repository.Estudiante_CarreraRepositoryImpl;
import com.example.tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import com.example.tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class Estudiante_CarreraService {

    private final Estudiante_CarreraRepositoryImpl estudianteCarreraRepository;
    private final EstudianteService estudianteService;
    private final CarreraService carreraService;



    @Transactional
    public void matricularEstudianteEnCarrera(Long estudianteId, Long carreraId, int antiguedad) {

        EstudianteResponseDTO estudiante = estudianteService.findById(estudianteId);
        CarreraResponseDTO carrera = carreraService.findById(carreraId);


        Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(estudiante.toEntity(), carrera.toEntity(), antiguedad, false);
        estudianteCarreraRepository.save(estudianteCarrera);

    }


}
