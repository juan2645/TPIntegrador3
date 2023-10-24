package com.example.tpintegrador3.web.rest.Estudiante;

import com.example.tpintegrador3.Service.DTO.Estudiante.Request.EstudianteRequestDTO;
import com.example.tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import com.example.tpintegrador3.Service.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService estudianteService;

    @GetMapping("")
    public List<EstudianteResponseDTO> findAll(){
        return this.estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO findById( @PathVariable Long id ){
        return this.estudianteService.findById( id );
    }




    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body((EstudianteResponseDTO) result);
    }


}
