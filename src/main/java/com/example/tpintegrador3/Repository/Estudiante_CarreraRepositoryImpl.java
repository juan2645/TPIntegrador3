package com.example.tpintegrador3.Repository;

import com.example.tpintegrador3.DTO.Estudiante_CarreraDTO;
import com.example.tpintegrador3.Entidades.Carrera;
import com.example.tpintegrador3.Entidades.Estudiante;
import com.example.tpintegrador3.Entidades.Estudiante_Carrera;
import com.example.tpintegrador3.Factory.EntityFactory;
import com.example.tpintegrador3.Interfaces.Estudiante_CarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante_CarreraRepositoryImpl implements Estudiante_CarreraRepository {
	public void altaMatricula(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
		try (EntityManager em = EntityFactory.getInstance().createEntityManager()) {
	        em.getTransaction().begin();
			Estudiante_Carrera matricula = new Estudiante_Carrera(estudiante, carrera, antiguedad, graduado);
	        em.persist(matricula);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Estudiante_CarreraDTO> obtenerReporte() {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
		List<Estudiante_CarreraDTO> lista = new ArrayList<>();
		
		try {

			int currentYear = LocalDate.now().getYear();

			TypedQuery<Estudiante_CarreraDTO> query = em.createQuery(
					"SELECT NEW com.example.tpintegrador3.DTO.Estudiante_CarreraDTO(c.nombreCarrera, ec.antiguedad, " +
							"COUNT(ec), " +
							"SUM(CASE WHEN ec.graduado = true THEN 1 ELSE 0 END)) " +
							"FROM Estudiante_Carrera ec " +
							"JOIN ec.carrera c " +
							"WHERE ec.antiguedad BETWEEN 1990 AND :currentYear " +
							"GROUP BY c.nombreCarrera, ec.antiguedad " +
							"ORDER BY c.nombreCarrera ASC, ec.antiguedad ASC", Estudiante_CarreraDTO.class);

			query.setParameter("currentYear", currentYear);

			List<Estudiante_CarreraDTO> resultados = query.getResultList();

			return resultados;

		} finally {
			em.close();
		}
	}
}