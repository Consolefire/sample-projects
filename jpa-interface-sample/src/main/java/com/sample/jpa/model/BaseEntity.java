package com.sample.jpa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sabuj.das
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  /**
   * Unique auto generated ID by the database
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Used for optimistic locking
   */
  @Version
  @Column(name = "version", columnDefinition = " INT DEFAULT 1 ", insertable=false, updatable=false)
  private int versionNumber = 1;

  


}
