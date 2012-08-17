package com.cyganic.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Copyright (c) CHP Consulting Ltd. 2012
 */
@Entity
public class TestObject {

  @Id
  private long id;
  private String text;


  /**
   * @return the id
   */
  public long getId() {
    return id;
  }


  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }


  /**
   * @return the text
   */
  public String getText() {
    return text;
  }


  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }
}
