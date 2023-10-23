package com.example.tpintegrador3.Service;

import com.example.tpintegrador3.Entidades.Carrera;
import com.example.tpintegrador3.Repository.CarreraRepository;
import com.example.tpintegrador3.Repository.CarreraRepositoryImpl;
import com.example.tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import com.example.tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    //repository
    @Autowired
    private CarreraRepository carreraRepository;

    public List<CarreraResponseDTO> findAll() {

            return  this.carreraRepository.findAll().stream().map(CarreraResponseDTO::new).toList();

    }

    public CarreraResponseDTO findById(Long id) {

            return this.carreraRepository.findById(id).map(CarreraResponseDTO::new).orElse(null);



    }

    public List<CarreraResponseDTO> search(CarreraRequestDTO request) {

            return this.carreraRepository.search(request.getNombre()).stream().map(CarreraResponseDTO::new).toList();

    }

    public CarreraResponseDTO save(CarreraRequestDTO request) {
            final var carrera = new Carrera(request);
            final var result = this.carreraRepository.save(carrera);
            return new CarreraResponseDTO(result);
    }


    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<CarreraResponseDTO> carrerasWithEstudiantes() {

                return this.carreraRepository.carrerasWithEstudiantes().stream().map(CarreraResponseDTO::new).toList();
    }


    public CarreraResponseDTO luckyCarrera() {
        return null;
    }
}
