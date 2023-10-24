//package com.example.tpintegrador3.Repository;
//
//import com.example.tpintegrador3.Entidades.Estudiante_Carrera;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_CarreraRepository, Long> {
//
//    @Query("SELECT ec FROM Estudiante_Carrera ec WHERE ec.idEstudiante  = :id and ec.idCarrera = :idCarrera")
//    Estudiante_Carrera findById(int idEstudiante, int idCarrera);
//
//}
