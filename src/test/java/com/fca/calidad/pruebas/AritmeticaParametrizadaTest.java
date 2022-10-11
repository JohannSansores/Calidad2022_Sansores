package com.fca.calidad.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AritmeticaParametrizadaTest {
	private double arg1;
	private double arg2;
	private double arg3;
	private Aritmetica miAritmetica;
	
	public AritmeticaParametrizadaTest(double arg1, double arg2, double arg3) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{4, 2, 8},
			{6, -3, -18},
			{-5, -5, 25}
		});
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	}

}
