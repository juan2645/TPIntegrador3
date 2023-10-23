package com.example.tpintegrador3.Factory;

import com.example.tpintegrador3.Interfaces.CarreraRepository;
import com.example.tpintegrador3.Interfaces.ER;
import com.example.tpintegrador3.Interfaces.Estudiante_CarreraRepository;

public interface FactoryRepository {
    ER getEstudianteRepository();
    CarreraRepository getCarreraRepository();
    Estudiante_CarreraRepository getEstudiante_CarreraRepository();

}
