/**
 * 
 */
package com.sample.jpa.model.service;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sample.jpa.model.state.StateDiagram;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table(name="sd_services")
@Getter
@Setter
public class Service {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @OneToOne(mappedBy="owner", cascade=CascadeType.ALL)
  private StateDiagram stateDiagram;
  
}
