package municipiosyprovincias.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import municipiosyprovincias.model.Municipio;


public class MunicipioController {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("municipiosyprovincias");

	/**
	 * Método para obtener varios registros a partir del nombre
	 * 
	 * @return
	 */
	public static List<Municipio> findByLikeName(String name) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM municipio where lower(nombre) like ?", Municipio.class);
		q.setParameter(1, "%" + name.toLowerCase() + "%");
		List<Municipio> l = (List<Municipio>) q.getResultList();
		em.close();
		return l;
	}

	/**
	 * Método para modificar un registro
	 */
	public static void update(Municipio o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}

}
