package com.example.tpintegrador3.web.rest.Carrera;

import com.example.tpintegrador3.Service.CarreraService;
import com.example.tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import com.example.tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor
public class CarreraResource {

    private final CarreraService carreraService;

    @GetMapping("")
    public List<CarreraResponseDTO> findAll(){
        return this.carreraService.findAll();
    }

    @GetMapping("/{id}")
    public CarreraResponseDTO findById( @PathVariable Long id ){
        return this.carreraService.findById( id );
    }

    @GetMapping("/search")
    public List<CarreraResponseDTO> findById( CarreraRequestDTO request ){
        return this.carreraService.search( request );
    }



    @PostMapping("")
    public ResponseEntity<CarreraResponseDTO> save(@RequestBody @Valid CarreraRequestDTO request ){
        final var result = this.carreraService.save( request );
        return ResponseEntity.accepted().body((CarreraResponseDTO) result);
    }


}
