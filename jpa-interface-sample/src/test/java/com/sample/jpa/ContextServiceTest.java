package com.sample.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.jpa.dao.ActionCompositionRepo;
import com.sample.jpa.dao.ActionNodeRepo;
import com.sample.jpa.dao.ActionRepo;
import com.sample.jpa.dao.ActionTransitionRepo;
import com.sample.jpa.dao.ServiceRepo;
import com.sample.jpa.dao.StateNodeRepo;
import com.sample.jpa.dao.StateRepo;
import com.sample.jpa.dao.StateTransitionRepo;
import com.sample.jpa.model.action.Action;
import com.sample.jpa.model.action.ActionComposition;
import com.sample.jpa.model.action.ActionNode;
import com.sample.jpa.model.service.Service;
import com.sample.jpa.model.state.State;
import com.sample.jpa.model.state.StateDiagram;
import com.sample.jpa.model.state.StateNode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class ContextServiceTest {

  @Autowired
  private ServiceRepo serviceRepo;
  @Autowired
  private StateRepo stateRepo;
  @Autowired
  private StateTransitionRepo stateTransitionRepo;
  @Autowired
  private StateNodeRepo stateNodeRepo;
  
  @Autowired
  private ActionRepo  actionRepo;
  @Autowired
  private ActionNodeRepo actionNodeRepo;
  @Autowired
  private ActionCompositionRepo actionCompositionRepo;
  @Autowired
  private ActionTransitionRepo actionTransitionRepo;

  // @Test
  public void t1() {
    State s1 = new State();
    s1.setStateCode("S1");
    s1 = stateRepo.save(s1);

    StateNode sn1 = new StateNode();
    sn1.setData(s1);
    sn1 = stateNodeRepo.save(sn1);

    State s2 = new State();
    s2.setStateCode("S2");
    s2 = stateRepo.save(s2);
    StateNode sn2 = new StateNode();
    sn2.setData(s2);
    sn2 = stateNodeRepo.save(sn2);

    State s3 = new State();
    s3.setStateCode("S3");
    s3 = stateRepo.save(s3);
    StateNode sn3 = new StateNode();
    sn3.setData(s3);
    sn3 = stateNodeRepo.save(sn3);

    State s4 = new State();
    s4.setStateCode("S4");
    s4 = stateRepo.save(s4);
    StateNode sn4 = new StateNode();
    sn4.setData(s4);
    sn4 = stateNodeRepo.save(sn4);


    sn1.addEdge(sn1, sn2);
    sn1.addEdge(sn1, sn3);

    sn2.addEdge(sn2, sn4);
    sn3.addEdge(sn3, sn4);

    Service service = new Service();

    StateDiagram diagram = new StateDiagram();
    diagram.setRoot(sn1);

    service.setStateDiagram(diagram);
    diagram.setOwner(service);

    serviceRepo.save(service);

  }

  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
  public void testCreateStateNode() {
    State s1 = new State();
    s1.setStateCode("S1");
    s1 = stateRepo.save(s1);
    StateNode sn1 = new StateNode();
    sn1.setData(s1);
    sn1 = stateNodeRepo.save(sn1);

  }


  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
  public void testCreateStateDiagram() {
    State s1 = new State();
    s1.setStateCode("S1");
    s1 = stateRepo.save(s1);
    StateNode sn1 = new StateNode();
    sn1.setData(s1);

    State s2 = new State();
    s2.setStateCode("S2");
    s2 = stateRepo.save(s2);
    StateNode sn2 = new StateNode();
    sn2.setData(s2);

    State s3 = new State();
    s3.setStateCode("S3");
    s3 = stateRepo.save(s3);
    StateNode sn3 = new StateNode();
    sn3.setData(s3);


    State s4 = new State();
    s4.setStateCode("S4");
    s4 = stateRepo.save(s4);
    StateNode sn4 = new StateNode();
    sn4.setData(s4);



    sn1.addEdge(sn1, sn2);
    sn1.addEdge(sn1, sn3);

    sn2.addEdge(sn2, sn4);
    sn3.addEdge(sn3, sn4);


    sn1 = stateNodeRepo.save(sn1);
    sn2 = stateNodeRepo.save(sn2);
    sn3 = stateNodeRepo.save(sn3);
    sn4 = stateNodeRepo.save(sn4);


  }

  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
  public void testCreateServiceWithStateDiagram() {
    State s1 = new State();
    s1.setStateCode("S1");
    s1 = stateRepo.save(s1);
    StateNode sn1 = new StateNode();
    sn1.setData(s1);

    State s2 = new State();
    s2.setStateCode("S2");
    s2 = stateRepo.save(s2);
    StateNode sn2 = new StateNode();
    sn2.setData(s2);

    State s3 = new State();
    s3.setStateCode("S3");
    s3 = stateRepo.save(s3);
    StateNode sn3 = new StateNode();
    sn3.setData(s3);


    State s4 = new State();
    s4.setStateCode("S4");
    s4 = stateRepo.save(s4);
    StateNode sn4 = new StateNode();
    sn4.setData(s4);



    sn1.addEdge(sn1, sn2);
    sn1.addEdge(sn1, sn3);

    sn2.addEdge(sn2, sn4);
    sn3.addEdge(sn3, sn4);


    sn1 = stateNodeRepo.save(sn1);
    sn2 = stateNodeRepo.save(sn2);
    sn3 = stateNodeRepo.save(sn3);
    sn4 = stateNodeRepo.save(sn4);

    Service service = new Service();

    StateDiagram diagram = new StateDiagram();
    diagram.setRoot(sn1);

    service.setStateDiagram(diagram);
    diagram.setOwner(service);

    serviceRepo.save(service);

  }

  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
  public void testStateWithActionDiagram(){
    Action a1 = new Action();
    a1.setActionId("a1");
    a1 = actionRepo.save(a1);
    
    ActionNode an1 = new ActionNode();
    an1.setData(a1);
    
    
    Action a2 = new Action();
    a2.setActionId("a2");
    a2 = actionRepo.save(a2);
    
    ActionNode an2 = new ActionNode();
    an2.setData(a2);
    
    
    Action a3 = new Action();
    a3.setActionId("a3");
    a3 = actionRepo.save(a3);
    
    ActionNode an3 = new ActionNode();
    an3.setData(a3);
    
    Action a4 = new Action();
    a4.setActionId("a4");
    a4 = actionRepo.save(a4);
    
    ActionNode an4 = new ActionNode();
    an4.setData(a4);
    
    an1.addEdge(an1, an2);
    an1.addEdge(an1, an3);
    an2.addEdge(an2, an4);
    an3.addEdge(an3, an4);
    
    
    an1 = actionNodeRepo.save(an1);
    an2 = actionNodeRepo.save(an2);
    an3 = actionNodeRepo.save(an3);
    an4 = actionNodeRepo.save(an4);
    
    
    State s1 = new State();
    s1.setStateCode("S1");
    s1 = stateRepo.save(s1);
    StateNode sn1 = new StateNode();
    sn1.setData(s1);
    
    ActionComposition actionComposition = new ActionComposition();
    actionComposition.setOwner(sn1);
    actionComposition.setRoot(an1);
    
    sn1.setPreActions(actionComposition);
    
    stateNodeRepo.save(sn1);
  }
  
}
