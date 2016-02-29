package com.amazonpremium.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* @author Hu Rui
* @version 1.0
*/
@Repository
public class HibernateUtil {

@Autowired
private SessionFactory factory;

public <T> Serializable create(final T entity) {
return factory.getCurrentSession().save(entity); 
}

public <T> T update(final T entity) {
	factory.getCurrentSession().update(entity); 
return entity;
}

public <T> void delete(final T entity) {
	factory.getCurrentSession().delete(entity);
}

public <T> void delete(Serializable id, Class<T> entityClass) {
T entity = fetchById(id, entityClass);
delete(entity);
}

@SuppressWarnings("unchecked") 
public <T> List<T> fetchAll(Class<T> entityClass) { 
return factory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list(); 
}

@SuppressWarnings("rawtypes")
public <T> List fetchAll(String query) { 
return factory.getCurrentSession().createSQLQuery(query).list(); 
}

@SuppressWarnings("unchecked")
public <T> T fetchById(Serializable id, Class<T> entityClass) {
return (T)factory.getCurrentSession().get(entityClass, id);
} 
}