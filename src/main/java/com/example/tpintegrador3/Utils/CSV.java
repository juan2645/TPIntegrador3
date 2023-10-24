package com.example.tpintegrador3.Utils;

import com.example.tpintegrador3.Entidades.Carrera;
import com.example.tpintegrador3.Entidades.Estudiante;
import com.example.tpintegrador3.Entidades.Estudiante_Carrera;

import com.example.tpintegrador3.Repository.CarreraRepository;
import com.example.tpintegrador3.Repository.EstudianteRepository;
//import com.example.tpintegrador3.Repository.Estudiante_CarreraRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class CSV {
    private List<Estudiante> estudiantes;
    private List<Carrera> carreras;
   // private List<Estudiante_Carrera> estudianteCarrera;
    private EstudianteRepository estudRep;
    private CarreraRepository carRep;
   // private Estudiante_CarreraRepository estud_CarRep;

    @Autowired
    public CSV(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository){
        this.estudiantes = new LinkedList<>();
        this.carreras = new LinkedList<>();
        //this.estudianteCarrera = new LinkedList<>();
        this.estudRep = estudianteRepository;
        this.carRep = carreraRepository;
    //    this.estud_CarRep = estudiante_CarreraRepository;
    }


    public void readCSV() throws IOException {
        File csvEstudiante = ResourceUtils.getFile("src/main/java/com/example/tpintegrador3/CSV/estudiantes.csv");
        File csvCarrera = ResourceUtils.getFile("src/main/java/com/example/tpintegrador3/CSV/carreras.csv");
       // File csvEstudianteCarrera = ResourceUtils.getFile("src/main/java/com/example/tpintegrador3/CSV/estudiante_carrera.csv");

        try(FileReader reader = new FileReader(csvEstudiante);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){
            for(CSVRecord csvRecord : csvParser){
                if (csvRecord.size() == 7 ){ // nombre,apellido,edad,genero,nroDocumento,ciudadResidencia,nroLibreta

                    Estudiante estudiante = new Estudiante();
                    estudiante.setNombre(csvRecord.get("nombre"));
                    estudiante.setApellido(csvRecord.get("apellido"));
                    estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                    estudiante.setGenero(csvRecord.get("genero"));
                    estudiante.setNroDocumento(Integer.parseInt(csvRecord.get("nroDocumento")));
                    estudiante.setCiudadResidencia(csvRecord.get("ciudadResidencia"));
                    estudiante.setNroLibreta(Integer.parseInt(csvRecord.get("nroLibreta")));
                    estudRep.save(estudiante);
                }
            }
        }


        try(FileReader reader = new FileReader(csvCarrera);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){
            for(CSVRecord csvRecord : csvParser){
                if (csvRecord.size() == 2 ){ //id,nombreCarrera
                    Carrera carrera = new Carrera();
                    carrera.setNombreCarrera(csvRecord.get("nombreCarrera"));
                    carRep.save(carrera);
                }

            }
        }
        /*
        try(FileReader reader = new FileReader(csvEstudianteCarrera);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){
            for(CSVRecord csvRecord : csvParser){
                if (csvRecord.size() == 4 ){ //idEstudiante,idCarrera,antiguedad,graduado
                 /*   Long idEstudiante = Long.valueOf(csvRecord.get("idEstudiante"));
                    Long idCarrera = Long.valueOf(csvRecord.get("idCarrera"));
                    int antiguedad = Integer.parseInt(csvRecord.get("antiguedad"));
                    boolean graduado = Boolean.parseBoolean(csvRecord.get("graduado"));


                    Estudiante_Carrera estudiante_carrera = new Estudiante_Carrera();
                    estudiante_carrera.setEstudiante((Estudiante) estudRep.findById(Integer.parseInt(csvRecord.get("idEstudiante"))));
                    estudiante_carrera.setCarrera((Carrera) carRep.findById(Integer.parseInt(csvRecord.get("idCarrera"))));
                    estudiante_carrera.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));
                    estudiante_carrera.setGraduado(Boolean.parseBoolean(csvRecord.get("graduado")));
                    estudianteCarrera.add(estudiante_carrera);

                }

            }
        }*/




    }

}




