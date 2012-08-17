package com.cyganic.core.database;

import javax.persistence.EntityManager;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;


/**
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
public class TransactionInterceptor implements MethodInterceptor {

  private final EntityManager entityManager;

  /**
   *
   */
  @Inject
  public TransactionInterceptor(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  /**
   * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
   */
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    entityManager.getTransaction().begin();
    Object result = invocation.proceed();
    entityManager.getTransaction().commit();
    return result;
  }
}
