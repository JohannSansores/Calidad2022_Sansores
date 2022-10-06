package com.fca.calidad.pruebas;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AritmeticaTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Este es el before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Este es el after");
	}

	@Test
	public void restaTest() {
		System.out.println("Este es la prueba suma");
		
	}
	
	@Test
	public void sumaTest() {
		System.out.println("Este es la prueba resta");
		
	}

}
