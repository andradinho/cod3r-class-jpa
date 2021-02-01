package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> c;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> c) {
		this.c = c;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> closeTransaction() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> include(E entity) {
		em.persist(entity);
		return this;
	}
	
	public DAO<E> atomicInclude(E entity) {
		return this.openTransaction().include(entity).closeTransaction();
	}
	
	public List<E> getAll(){
		return this.getAll(10, 0);
	}
	
	public List<E> getAll(int limit, int offset) {
		if(c == null) {
			throw new UnsupportedOperationException("Null Class");
		}
		
		String jpql = "select e from " + c.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, c);
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		return query.getResultList();
	}
	
	public void close() {
		em.close();
	}
}
