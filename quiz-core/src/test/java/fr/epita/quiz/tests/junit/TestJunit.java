package fr.epita.quiz.tests.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit {
	
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	
	@BeforeClass
	public static void beforeAll() {
		
		LOGGER.info("beforeall");
		//System.out.println("beforeall");
	}
	
	
	@Before
	public void prepareForEach() {
		LOGGER.info("beforeEach");

		//System.out.println("beforeEach");
	}
	
	
	@Test
	public void firstSuccessTest() {
		
		LOGGER.info("testsucces");

		//System.out.println("testsucces");
	}
	
	@Test
	public void firstFailTest() {
		
		LOGGER.info("testfail");

		//System.out.println("testfail");
		Assert.fail();
	}

	@Test
	public void firstErrorTest() {
		
		LOGGER.error("testError");

		//System.out.println("testerror");
		//double zero=0;
		//System.out.println(1/zero);
		
		int zero =0;
		
		double other = 1/zero;
	}
	
	@After
	public void tearDownForEach() {
		
		LOGGER.info("afterEach");

		
		//System.out.println("afterEach");
	}
	
	@AfterClass
	public static void afterAll() {
		
		LOGGER.info("afterAll");

		
		//System.out.println("afterall");
	}
	
	
}
