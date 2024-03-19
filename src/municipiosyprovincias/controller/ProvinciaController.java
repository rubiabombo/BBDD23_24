package municipiosyprovincias.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import municipiosyprovincias.model.Provincia;



public class ProvinciaController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("municipiosyprovincias");

	/**
	 * Método para obtener los registros
	 * 
	 * @return
	 */
	public static List<Provincia> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Provincia.findAll");
		List<Provincia> l = (List<Provincia>)q.getResultList();
		em.close();
		return l;
	}

}
