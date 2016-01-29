package com.sample.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.jpa.model.Context;
import com.sample.jpa.model.JpaContext;
import com.sample.jpa.service.ContextService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class ContextServiceTest {

	private Context contextToTest;

	@Autowired
	private ContextService contextService;

	@Before
	public void setup() {
		contextToTest = new JpaContext();
		contextToTest.setId(1L);
		contextToTest.setName("Sample 01");
	}

	@Test
	public void testCreateContext() {
		Context context = new JpaContext();
		context.setName(contextToTest.getName());
		contextService.create(context);
	}
	
	@Test
	public void testReadContext() {
		Context context = new JpaContext();
		context.setName(contextToTest.getName());
		contextService.create(context);
		
		Context context1 = contextService.read(1L);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println(context1);
		System.out.println("---------------------------------------------------------------------------------------");
		Assert.assertEquals(contextToTest.getName(), context1.getName());
	}

	@Test
	public void testUpdateContext() {
		Context context = new JpaContext();
		context.setName(contextToTest.getName());
		contextService.create(context);
		
		Context context1 = contextService.read(1L);
		System.out.println("Before Update ---------------------------------------------------------------------------------------");
		System.out.println(context1);
		System.out.println("---------------------------------------------------------------------------------------");
		Assert.assertEquals(contextToTest.getName(), context1.getName());
		context1.setName("Sample 02");
		contextService.update(context1);
		context1 = contextService.read(1L);
		System.out.println("After Update ---------------------------------------------------------------------------------------");
		System.out.println(context1);
		System.out.println("---------------------------------------------------------------------------------------");
		Assert.assertEquals("Sample 02", context1.getName());
		
	}

	//@Test
	public void testDeleteContext() {
		Context context = new JpaContext();
		context.setName(contextToTest.getName());
		contextService.create(context);
		
		contextService.delete(1L);
		Context context1 = contextService.read(1L);
		Assert.assertNull(context1);
	}
}
