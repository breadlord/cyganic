package com.cyganic.core.database;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
@Singleton
public class EntityManagerProvider implements Provider<EntityManager> {

  private static final String PERSISTENCE_UNIT_NAME = "db-manager";

  private final Map<String, String> properties = new HashMap<String, String>();

  private EntityManagerFactory entityManagerFactory;

  private ThreadLocal<EntityManager> entityManager;

  /**
   * @see com.google.inject.Provider#get()
   */
  @Override
  public EntityManager get() {
    if (entityManagerFactory == null) {
      entityManagerFactory = getEntityManagerFactory();
    }
    if (entityManager.get() == null) {
      entityManager.set(entityManagerFactory.createEntityManager());
    }
    return entityManager.get();
  }

  public EntityManagerFactory getEntityManagerFactory() {
    return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
  }


  /**
   * Get the properties.
   * @return
   */
  public Map<String, String> getProperties() {
    return properties;
  }
}
