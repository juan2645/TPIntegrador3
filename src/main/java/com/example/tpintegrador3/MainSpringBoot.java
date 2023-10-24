package com.example.tpintegrador3;

import com.example.tpintegrador3.Utils.CSV;
import com.example.tpintegrador3.Service.DTO.CarreraDTO;
import com.example.tpintegrador3.Service.DTO.EstudianteDTO;
import com.example.tpintegrador3.Service.DTO.Estudiante_CarreraDTO;
import com.example.tpintegrador3.Interfaces.CarreraRepository;
import com.example.tpintegrador3.Interfaces.ER;
import com.example.tpintegrador3.Interfaces.Estudiante_CarreraRepository;
import com.example.tpintegrador3.Repository.CarreraRepositoryImpl;
import com.example.tpintegrador3.Repository.EstudianteRepositoryImpl;
import com.example.tpintegrador3.Repository.Estudiante_CarreraRepositoryImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SpringBootApplication
public class TercerIntegradorApplication {

    @Autowired
    private CSV cargaCSV;

    public static void main(String[] args) throws IOException{
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TercerIntegradorApplication.class, args);

    }

    @PostConstruct
    public void init() throws Exception{
        cargaCSV.InsertarCSV("estudiante.csv", "carrera.csv", "InscripcionCarrera.csv");
    }
}