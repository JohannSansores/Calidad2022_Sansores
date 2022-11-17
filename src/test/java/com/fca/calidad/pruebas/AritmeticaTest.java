package com.fca.calidad.pruebas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AritmeticaTest {
	private Aritmetica aritmetica;
	
	@Before
	public void setUp() throws Exception {
		aritmetica = new Aritmetica();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Este es el after");
	}

	@Test
	public void restaTest() {
		//Inicializar
		double resultadoEsperado = 4; //Resultado esperado 8 - 4
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.resta(8, 4);
		//Verificar
		assertThat(resultadoEsperado, is(resultadoEjecucion));
	}
	
	@Test
	public void sumaTest() {
		//Inicializar
		double resultadoEsperado = 4; //Resultado esperado 2 + 2
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.suma(2, 2);
		//Verificar
		assertThat(resultadoEsperado, is(resultadoEjecucion));
	}
	
	@Test
	public void multiplicacionTest() {
		//Inicializar
		double resultadoEsperado = 22; //Resultado esperado 11 * 2
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.multiplicacion(11, 2);
		//Verificar
		assertThat(resultadoEsperado, is(resultadoEjecucion));
	}
	
	@Test
	public void divisionTest() {
		//Inicializar
		double resultadoEsperado = 10; //Resultado esperado 100 / 10
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.division(100, 10);
		//Verificar
		assertThat(resultadoEsperado, is(resultadoEjecucion));
	}
	/*
	@Test(expected = ArithmeticException.class)
	public void division0Test() {
		//Inicializar
		double resultadoEsperado = Double.POSITIVE_INFINITY; //Resultado esperado 100 / 0
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.divisionEntera(100, 0);
		//Verificar
		//assertThat(resultadoEsperado, is(resultadoEjecucion));
	}
	
	@Test
	public void sumaTestFalla() {
		//Inicializar
		double resultadoEsperado = 7; //Resultado esperado 2 + 2
		double resultadoEjecucion = 0;
		//Ejercicio del código
		resultadoEjecucion = aritmetica.suma(2, 2);
		//Verificar
		assertThat(resultadoEsperado, is(resultadoEjecucion));
	}*/

}
