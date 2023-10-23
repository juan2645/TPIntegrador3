package com.example.tpintegrador3.Service;

import com.example.tpintegrador3.Entidades.Estudiante;
import com.example.tpintegrador3.Repository.EstudianteRepository;
import com.example.tpintegrador3.Service.DTO.Estudiante.Request.EstudianteRequestDTO;
import com.example.tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;
    public List<EstudianteResponseDTO> findAll() {

        return this.estudianteRepository.findAll().stream().map(EstudianteResponseDTO::new).toList();


    }

    public EstudianteResponseDTO findById(Long id) {

        return this.estudianteRepository.findById(id).map(EstudianteResponseDTO::new).orElse(null);


    }

    public List<EstudianteResponseDTO> search(EstudianteRequestDTO request) {

            return this.estudianteRepository.search(request.getGenero(),request.getCiudadResidencia(),request.getFullName()).stream().map(EstudianteResponseDTO::new).toList();

    }

    public EstudianteResponseDTO save(EstudianteRequestDTO request) {
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result);

    }

    public List<EstudianteResponseDTO> findAllOrderByName() {

        return this.estudianteRepository.findAllOrderByName().stream().map(EstudianteResponseDTO::new).toList();

    }
    //findByGenero
    public List<EstudianteResponseDTO> findByGenero(String genero) {

        return this.estudianteRepository.findByGenero(genero).stream().map(EstudianteResponseDTO::new).toList();

    }

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    public EstudianteResponseDTO findByNroLibreta(int nroLibreta) {

        return this.estudianteRepository.findByNroLibreta(nroLibreta).stream().map(EstudianteResponseDTO::new).findFirst().orElse(null) ;

    }
//findEstudiantesByCarreraAndCiudad
    public List<EstudianteResponseDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {

        return this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia).stream().map(EstudianteResponseDTO::new).toList();

    }


    public EstudianteResponseDTO luckyStudent() {
        return null;
    }

    public List<EstudianteResponseDTO> bestStudents() {
        return null;
    }
}
