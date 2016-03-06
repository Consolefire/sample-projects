/**
 * 
 */
package com.sample.jpa.model.state;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Getter
@Setter
public class State {

  @Id
  private String stateCode;
  private String displayName;

  
}
