package com.example.tpintegrador3.Repository;

import com.example.tpintegrador3.Service.DTO.EstudianteDTO;
import com.example.tpintegrador3.Entidades.Carrera;
import com.example.tpintegrador3.Entidades.Estudiante;
import com.example.tpintegrador3.Entidades.Estudiante_Carrera;
import com.example.tpintegrador3.Factory.EntityFactory;
import com.example.tpintegrador3.Interfaces.ER;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryImpl implements ER {
	
	@Override
	public void altaEstudiante(String nombre, String apellido, int edad, String genero, int nroDocumento, String ciudadResidencia, int nroLibreta) {
	    try (EntityManager em = EntityFactory.getInstance().createEntityManager()) {
	        em.getTransaction().begin();
	        Estudiante estudiante = new Estudiante(nombre, apellido, edad, genero, nroDocumento, ciudadResidencia, nroLibreta);
	        em.persist(estudiante);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Estudiante getEstudianteById(int idEstudiante) {
		EntityManager em = EntityFactory.getInstance().createEntityManager();		 
		try {
			   String jpql = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante";
			   TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);

			   query.setParameter("idEstudiante", idEstudiante);
			   Estudiante estudiante = query.getSingleResult(); // Esta línea ejecuta la consulta y obtiene el estudiante
			   
			   return estudiante;
		   } catch (Exception e) {
			   return null;
		   } finally {
			   em.close();
		   }
	}

	@Override
	public EstudianteDTO recuperarEstudiantePorLibreta(int nroLibreta) {
		EntityManager em = EntityFactory.getInstance().createEntityManager();		 
		 try {
		        String jpql = "SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta";
		        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);

		        query.setParameter("nroLibreta", nroLibreta);
		        Estudiante estudiante = query.getSingleResult(); // Esta línea ejecuta la consulta y obtiene el estudiante
		         
		        EstudianteDTO estudianteDTO = convertEstudianteDTO(estudiante);
		        
		        return estudianteDTO;
		    } catch (Exception e) {
		        return null;
		    } finally {
		        em.close();
		    }
	}

	private EstudianteDTO convertEstudianteDTO(Estudiante estudiante) {
		 EstudianteDTO estudianteDTO = new EstudianteDTO(
			        estudiante.getNombre() + " " + estudiante.getApellido(), // fullName
			        estudiante.getGenero(),
			        estudiante.getCiudadResidencia(),
			        estudiante.getEdad(),
			        estudiante.getNroDocumento(),
			        estudiante.getNroLibreta()
		        );
			    return estudianteDTO;
	}
	
	private List<EstudianteDTO> convertEstudianteDTO(List<Estudiante> estudiantes) {
		List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
	    
	    for (Estudiante estudiante : estudiantes) {
	    	estudiantesDTO.add(convertEstudianteDTO(estudiante));
	    }
	    
	    return estudiantesDTO;
	}
  //  @Override
	public List<EstudianteDTO> recuperarEstudiantesOrdenados(String criterioOrdenamiento) {
		 EntityManager em = EntityFactory.getInstance().createEntityManager();
		    
		    String jpql = "SELECT e FROM Estudiante e ORDER BY ";

		    switch (criterioOrdenamiento) {
		        case "nombre":
		            jpql += "e.nombre ASC";
		            break;
		        case "edad":
		            jpql += "e.edad ASC";
		            break;
		        default:
		            jpql += "e.nombre ASC"; 
		            break;
		    }

		    try {
		        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
		        List<Estudiante> estudiantes = query.getResultList();

		        return convertEstudianteDTO(estudiantes);
		    } finally {
		        em.close();
		    }
	}

	@Override
	public List<EstudianteDTO> recuperarEstudiantesPorGenero(String genero) {
		EntityManager em = EntityFactory.getInstance().createEntityManager();

		String jpql = "SELECT e FROM Estudiante e WHERE e.genero = :genero"; // Utiliza :genero como parámetro

		try {
			TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
			query.setParameter("genero", genero);
			List<Estudiante> estudiantes = query.getResultList();

			return convertEstudianteDTO(estudiantes);
		} finally {
			em.close();
		}
	}

    @Override
    public void matricularEstudianteEnCarrera(int idEstudiante, int idCarrera) {

    	EntityManager em = EntityFactory.getInstance().createEntityManager();
   	 	EntityTransaction tx = em.getTransaction();
   	    
   	    try {
   	        tx.begin();
   	        
   	        Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
   	        Carrera carrera = em.find(Carrera.class, idCarrera);
   	        
   	        if (estudiante != null && carrera != null) {
   	        	 
        		 Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera();
   	             estudianteCarrera.setEstudiante(estudiante);
   	             estudianteCarrera.setCarrera(carrera);

   	             carrera.agregarEstudianteCarrera(estudianteCarrera); // Agregar a la lista y sincronizar

   	             em.persist(estudianteCarrera);
   	             tx.commit();

   	        } else {
   	        
   	        }
   	    } catch (Exception e) {
   	        if (tx != null && tx.isActive()) {
   	            tx.rollback();
   	        }
   	    } finally {
   	        em.close();
   	    }
	}
    
    public List<EstudianteDTO> getEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudadResidencia){
    	EntityManager em = EntityFactory.getInstance().createEntityManager();
		List<EstudianteDTO> lista = new ArrayList<>();

    	try {
		 TypedQuery<EstudianteDTO> query = em.createQuery(
			 "SELECT NEW com.example.tpintegrador3.Service.DTO.EstudianteDTO(e.nombre, e.genero, e.ciudadResidencia, e.edad, e.nroDocumento,e.nroLibreta) " +
			 "FROM Estudiante_Carrera ec " +
			 "JOIN ec.estudiante e " +
			 "JOIN ec.carrera c " +
			 "WHERE c.nombreCarrera = :nombreCarrera " +
			 "AND e.ciudadResidencia = :ciudadResidencia", EstudianteDTO.class);
							
    		query.setParameter("nombreCarrera", nombreCarrera);
    		query.setParameter("ciudadResidencia", ciudadResidencia);

			lista.addAll(query.getResultList());
    	 }catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en getEstudiantesPorCarreraYCiudad" + e);
		 }
    	return lista;
    }
}