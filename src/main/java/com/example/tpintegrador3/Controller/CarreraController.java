package com.example.tpintegrador3.Controller;

import com.example.tpintegrador3.Service.CarreraService;
import com.example.tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import com.example.tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/carrera")
public class CarreraController {
    private CarreraService carreraService;

    @RequestMapping("/findAll")
    public List<CarreraResponseDTO> findAll() {

        List<CarreraResponseDTO> carreras = carreraService.findAll();

        return carreras;
    }

    @RequestMapping("/findById/{id}")
    public CarreraResponseDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        CarreraResponseDTO carrera = carreraService.findById(_id);
        return carrera;
    }


    @RequestMapping("/search")
    public List<CarreraResponseDTO> search(CarreraRequestDTO request) {
        List<CarreraResponseDTO> carreras = carreraService.search(request);
        return carreras;
    }

    @RequestMapping("/save")
    public CarreraResponseDTO save(CarreraRequestDTO request) {
        return carreraService.save(request);
    }




    @RequestMapping("/luckyCarrera")
    public CarreraResponseDTO luckyCarrera() {
        return carreraService.luckyCarrera();
    }


/*
    public Usuario getUsuarioById(@PathVariable String id) {
        int _id = Integer.valueOf(id);
        Usuario usuario = usuarioService.findById(_id);
        return usuario; }*/
}
