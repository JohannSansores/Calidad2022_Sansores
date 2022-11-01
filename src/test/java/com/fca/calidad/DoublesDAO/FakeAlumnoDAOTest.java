package com.fca.calidad.DoublesDAO;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FakeAlumnoDAOTest {
	
	private FakeAlumnoDAO DAO;
	public HashMap<String, Alumno> baseDatos;
	
	@Before
	public void setUp() throws Exception {}{
		DAO = Mockito.mock(FakeAlumnoDAO.class);
		baseDatos = new HashMap<String, Alumno>();
	}
	//Falta
	@Test
	public void searchAlumnoTest() {
		when(DAO.searchAlumno((String) any())).thenAnswer(new Answer<Alumno>() {
			
			public Alumno answer(InvocationOnMock invocation) throws Throwable{
				String arg = (String) invocation.getArguments()[0];
				baseDatos.get(arg);
				return arg;
			}
		});
		//Setup
		//Agregar a la base de datos
		Alumno alumno = new Alumno("nombre","1", "correo",0);
		baseDatos.put("1", alumno);
		
		DAO.searchAlumno("1");
		
		String valorEsperado = "nombre";
		String valorEjecucion = baseDatos.get("1").getNombre();
		
		assertThat(valorEsperado, is(valorEjecucion));
	}
	/*
	@Test
	public void deleteAlumnoTest() {
		when(DAO.deleteAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				Alumno arg = (Alumno) invocation.getArguments()[0];
				//Obtenemos el ID del alumno
				baseDatos.remove(arg, null);
				return true;
			}
		});
		//Setup
		//Agregar a la base de datos
		Alumno alumno = new Alumno("nombre","1", "correo",14);
		baseDatos.put("1", alumno);
		
		DAO.deleteAlumno(alumno);
		
		String valorEsperado = null;
		String valorEjecucion = null;
		
		assertThat(valorEsperado, is(valorEjecucion));
	}
	/*
	@Test
	public void updateEmailTest() {
		when(DAO.updateEmail(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				Alumno arg = (Alumno) invocation.getArguments()[0];
				//Cambiamos el correo en el mismo ID
				baseDatos.put(arg.getId(), arg);
				return true;
			}
		});
		//Setup
		//Agregar a la base de datos
		Alumno alumno = new Alumno("nombre","1","email",14);
		baseDatos.put("1", alumno);
		
		//Cambiar el correo
		alumno.setEmail("NuevoCorreo");
		
		//Llamar al método para actualizar la bd
		DAO.updateEmail(alumno);
		
		String valorEsperado = "NuevoCorreo";
		String valorEjecucion = baseDatos.get("1").getEmail();
		
		assertThat(valorEsperado, is(valorEjecucion));
	}

	@Test
	public void agregarTest() {
		
		when(DAO.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				Alumno arg = (Alumno) invocation.getArguments()[0];
				//Agregar a la base de datos
				baseDatos.put("1",arg);
				System.out.println("Tamaño despues =" +baseDatos.size() + "\n");
				return true;
			}
		}
		
	);
	Alumno a = new Alumno("nombre","id","email",14);
	int sizeBefore = baseDatos.size();
	Boolean res = DAO.addAlumno(a);
	int sizeAfter = baseDatos.size();
	
	assertThat(sizeAfter,is(sizeBefore+1));
		
	}

	*/
	@After
	public void tearDown() throws Exception {
	}

	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}

}
