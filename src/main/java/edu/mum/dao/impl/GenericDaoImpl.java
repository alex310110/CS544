package edu.mum.dao.impl;

import edu.mum.dao.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/*@SuppressWarnings("unchecked")
@Repository*/
@Service
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    @Override
    public T save( T entity ){
        entityManager.merge( entity );
        return entity;
     }

    public void delete( T entity ){
        entityManager.remove( entity );
     }

	@Override
	public void delete(Long id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( Long id ){
	    return (T) entityManager.find( daoType, id );
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		      return entityManager.createQuery( "from " + daoType.getName() )
		       .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager.merge( entity );
	   }

 	@Override
	public List<T> findAll(String s,Object  hint ){
 	    return (List<T>)  entityManager.createQuery("SELECT m FROM Member AS m")
 	    		.setHint(s,hint).getResultList();
  	}
	

 }