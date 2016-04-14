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
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("State [");
    if (stateCode != null)
      builder.append("stateCode=").append(stateCode);
    builder.append("]");
    return builder.toString();
  }

  
}
