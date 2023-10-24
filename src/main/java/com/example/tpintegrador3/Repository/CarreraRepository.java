package com.example.tpintegrador3.Repository;

import com.example.tpintegrador3.Entidades.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository  extends JpaRepository<Carrera, Long> {

    @Query( "SELECT c " +
            "FROM Carrera c " +
            "WHERE (:nombreCarrera IS NULL OR c.nombreCarrera LIKE :nombreCarrera) ")
    List<Carrera> search(String nombreCarrera);


    @Query( "SELECT c " +
            "FROM Carrera c " +
            "JOIN Estudiante_Carrera ec ON (c.idCarrera = ec.carrera.idCarrera) "+
            "GROUP BY c.idCarrera " +
            "ORDER BY COUNT(ec) DESC ")
    List<Carrera> carrerasWithEstudiantes();



    //buscar por id
    @Query("SELECT c FROM Carrera c WHERE c.idCarrera = :id")
    Carrera findById(int idCarrera);
}

