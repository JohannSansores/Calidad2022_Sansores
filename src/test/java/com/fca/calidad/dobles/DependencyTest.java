package com.fca.calidad.dobles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DependencyTest {

	Dependency dependency;
	@Before
	public void setUp() throws Exception {
		dependency = Mockito.mock(Dependency.class);
	}

	@After
	public void tearDown() throws Exception {
	}
/*
	@Test
	public void testDummy() {
		assertThat(dependency.getClassName(),is(nullValue()));
	}
	
	private void setBehavior() {
		when(dependency.getClassName()).thenReturn("Nombre de la clase");
	}
	
	@Test
	public void testGetClassName() {
		setBehavior();
		String resultadoEsperado = "Nombre de la clase";
		assertThat(dependency.getClassName(),is(resultadoEsperado));
	}
	
	private void setAddTwo() {
		when(dependency.addTwo(2)).thenReturn(4);
	}
	
	@Test
	public void testAddTwo() {
		setAddTwo();
		int resultadoEsperado = 4;
		int resultadoEsperado2 = 6;
		assertThat(dependency.addTwo(2),is(resultadoEsperado));
		assertThat(dependency.addTwo(4),is(resultadoEsperado2));
	}
	
	private void setAddTwo2() {
		when(dependency.addTwo(anyInt())).thenReturn(4);
	}
	
	@Test
	public void testAddTwo2() {
		setAddTwo2();
		int resultadoEsperado = 4;
		int resultadoEsperado2 = 4;
		assertThat(dependency.addTwo(2),is(resultadoEsperado));
		assertThat(dependency.addTwo(4),is(resultadoEsperado2));
	}
	
	@Test
	public void Arg() {
		int resultadoEsperado = 47;
		when(dependency.addTwo(anyInt())).thenCallRealMethod();
		int resultadoPrueba = dependency.addTwo(45);
		assertThat(resultadoEsperado, is(resultadoPrueba));
	} */
	
	@Test
	public void mockAnsware_Test2() {
		when(dependency.addTwo(anyInt())).thenAnswer(
				new Answer<Integer>() {
					public Integer answer(InvocationOnMock invocation) throws Throwable{
						int arg = (Integer) invocation.getArguments()[0];
						return arg + 10;
					}
				});
		assertThat(20, is(dependency.addTwo(10)));
		assertThat(49, is(dependency.addTwo(39)));
	}
}