package com.cyganic.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
public interface IReadOnlyDAO<ID extends Serializable, T> {

  /**
   * Returns a specific instance of <T> that has the given <ID>
   */
  public T findById(ID id);

  /**
   * Returns a {@link List} containing all objects of type <T>
   */
  public List<T> list();

  /**
   * Returns A {link List} of type <T> that match the given {@link Criterion}
   */
  public List<T> listByCriterion(Criterion... criterion);
}