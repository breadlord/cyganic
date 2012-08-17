package com.cyganic.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
public abstract class AbstractReadOnlyDAO<ID extends Serializable, T> implements IReadOnlyDAO<ID, T>{

  private final EntityManager entityManager;
  private final Class<T> persistentClass;

  @SuppressWarnings("unchecked")
  public AbstractReadOnlyDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.persistentClass =
        (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }


  public void save(T entity) {
    entityManager.persist(entity);
  }


  @Override
  public T findById(ID id) {
    return entityManager.find(persistentClass, id);
  }


  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    Query findAllQuery = entityManager.createNamedQuery("FROM" + persistentClass.getName());
    return findAllQuery.getResultList();
  }


  public void delete(T entity) {
    if(entityManager.contains(entity)) {
      entityManager.remove(entity);
    }
  }


  public void deleteById(ID id) {
    T entity = entityManager.find(persistentClass, id);
    entityManager.remove(entity);
  }
}
