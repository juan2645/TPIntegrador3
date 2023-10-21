package com.example.tpintegrador3.Factory;

import com.example.tpintegrador3.Interfaces.CarreraRepository;
import com.example.tpintegrador3.Interfaces.EstudianteRepository;
import com.example.tpintegrador3.Interfaces.Estudiante_CarreraRepository;

public interface FactoryRepository {
    EstudianteRepository getEstudianteRepository();
    CarreraRepository getCarreraRepository();
    Estudiante_CarreraRepository getEstudiante_CarreraRepository();

}
