/**
 * 
 */
package com.sample.jpa.model.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Action {

  @Id
  private String actionId;
  private String displayName;

  public Action(String actionId) {
    this.actionId = actionId;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Action [");
    if (actionId != null)
      builder.append("actionId=").append(actionId);
    builder.append("]");
    return builder.toString();
  }

  
  
}
