package com.cyganic.core;

import javax.persistence.EntityManager;

import com.cyganic.core.database.TransactionInterceptor;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.persist.Transactional;

/**
 * TODO CoreModule class-level Javadoc.
 *
 * <p>...</p>
 *
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
public class CoreModule extends AbstractModule {

  /**
   * @see com.google.inject.AbstractModule#configure()
   */
  @Override
  protected void configure() {
    bindTransactionality();
  }


  /**
   * Bind in {@link Transactional} support through guice-aop.
   */
  private void bindTransactionality() {
    TransactionInterceptor interceptor = new TransactionInterceptor(getProvider(EntityManager.class).get());
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), interceptor);
  }
}
