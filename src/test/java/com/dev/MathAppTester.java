package com.dev;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MathAppTester {

	 /*@InjectMocks annotation is used to create and instance of MathApplication and then
	   inject the mock object. Which is essentially any object created with @Mock (CalcService) 
	   that is part of this object (MathApplication)*/
	 @InjectMocks 
	 MathApplication mathApplication = new MathApplication();

	 //@Mock annotation is used to create the mock object to be injected
	 //@Mock
	 //CalculatorService calcService;
	 
	 /*Another way of mocking is to do it like this*/
	 CalculatorService calcService = mock(CalculatorService.class);
	 
	 /*If i use the @Mock or @InjectMock annotation like above i must write the following 
	   line of code. This will create the annotated (mocked) object (calcService) 
	   and inject it.*/ 
	 @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	 @Test
	 public void testAddWithMock(){
		 
		//add the behavior of calc service to add two numbers
	    when(calcService.add(10.0,20.0)).thenReturn(30.00);
			
	    //test the add functionality
	    Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	 }
}
