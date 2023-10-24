package com.example.tpintegrador3.Entidades;

import com.example.tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;
    @Column
    private String nombreCarrera;
    
    @OneToMany(mappedBy = "carrera", fetch = FetchType.EAGER)
    private List<Estudiante_Carrera> estudianteCarrera;

    public Carrera() {

        super();
    }

    public Carrera(CarreraRequestDTO request) {
        this.nombreCarrera = request.getNombre();
        this.estudianteCarrera = new LinkedList<>();
    }

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.estudianteCarrera = new LinkedList<>();
    }

    public int getIdCarrera() {
        return idCarrera;
    }
    public void agregarEstudianteCarrera(Estudiante_Carrera estudianteCarrera) {
        if (estudianteCarrera != null) {
            this.estudianteCarrera.add(estudianteCarrera);
            estudianteCarrera.setCarrera(this); // Sincronizar la otra parte de la relación
        }
    }
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }


    public String getNombre() {
        return nombreCarrera;
    }

    public List<Estudiante_Carrera> getEstudianteCarrera() {
        return estudianteCarrera;
    }
    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                '}';
    }
}
