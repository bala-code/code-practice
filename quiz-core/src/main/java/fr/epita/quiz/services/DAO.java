package fr.epita.quiz.services;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Question;

@Repository
public abstract class DAO<T> {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void create(T t) {
		
		em.persist(t);

	}
	
	public T createReturn(T t) {
		T tt = em.merge(t);
		return tt;
	}
	
	public T getById(Serializable id, Class<T> clazz) {

		return em.find(clazz, id);
	}

	@Transactional
	public void update(T t) {

		em.merge(t);

	}
	

	@Transactional
	public void delete(T t) {
		
		em.remove(t);
	}
	
	@Transactional
	public void delete(Serializable id, Class<T> clazz) {
		T t = em.find(clazz, id);
		em.remove(t);
		//em.getTransaction().commit();
	}
	
	public List<T> search(T criteria){ 
		
		Query searchQuery = em.createQuery(getQueryString());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		fillParametersMap(parameters,criteria);
		
		parameters.forEach((k,v) -> searchQuery.setParameter(k,v));
		
		return (List<T>) searchQuery.getResultList(); 
		
	}

	protected abstract String getQueryString();
	protected abstract void fillParametersMap(Map<String,Object> map, T t);



	protected void fillParametersMap1(Map<String, Object> map, Question question) {
		// TODO Auto-generated method stub
		
	}
	
	
}
