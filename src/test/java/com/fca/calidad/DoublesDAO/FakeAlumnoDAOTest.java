package com.fca.calidad.DoublesDAO;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FakeAlumnoDAOTest {
	
	private FakeAlumnoDAO DAO;
	public HashMap<String, Alumno> baseDatos;
	
	@Before
	public void setUp() throws Exception {
		DAO = Mockito.mock(FakeAlumnoDAO.class);
		baseDatos = new HashMap<String, Alumno>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//Test para crear un alumno
	@Test
	public void addAlumnoTest() {
		when(DAO.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				// Set behavior
				Alumno arg = (Alumno) invocation.getArguments()[0];
				
				// Save in baseDatos
				baseDatos.put("1", arg);
				//System.out.println("Size después=" + baseDatos.size() + "\n");
				return true;
			}
		});
	// Setup
	// Create a
	Alumno a = new Alumno("nombre", "id", "email", 21);
	
	// Check sizeBefore baseDatos
	int sizeBefore = baseDatos.size();
	Boolean res = DAO.addAlumno(a);
	
	// Check sizeAfter baseDatos
	int sizeAfter = baseDatos.size();
	
	// Verify
	assertThat(sizeAfter,is(sizeBefore+1));
	System.out.println("Resultado addAlumno: " + res);
	}
	
	//Test para eliminar alumno
	@Test
	public void deleteAlumnoTest() {
		when(DAO.deleteAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				// Set behavior
				Alumno arg = (Alumno) invocation.getArguments()[0];
				
				// Delete with specific id
				baseDatos.remove(arg.getId());
				return true;
			}
		});
		// Setup
		// Create a
		Alumno a = new Alumno("nombre", "1", "email", 21);
		
		// Save in baseDatos
		baseDatos.put("1", a);
		int sizeSaved = baseDatos.size();
		//System.out.println(sizeSaved);
		// Delete in baseDatos
		Boolean res = DAO.deleteAlumno(a);
		int sizeDeleted = baseDatos.size();
		//System.out.println(sizeDeleted);

		
		// Verify
		assertThat(sizeDeleted,is(sizeSaved-1));
		System.out.println("Resultado deleteAlumno: " + res);
	}
	
	//Test para editar alumno
	@Test
	public void updateEmailTest() {
		when(DAO.updateEmail(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				// Set behavior
				Alumno arg = (Alumno) invocation.getArguments()[0];
				
				// Save new in same id
				baseDatos.put(arg.getId(),arg);
				return true;
			}
		});
		// Setup
		// add to baseDatos
		Alumno a = new Alumno("nombre", "id", "email", 21);
		baseDatos.put("1", a);

		// Set new email
		String nuevoCorreo = "nuevoCorreo";
		a.setEmail(nuevoCorreo);
		
		// Call update method
		Boolean res = DAO.updateEmail(a);
		
		// Verify
		String valorEsperado = nuevoCorreo;
		String valorEjecucion = baseDatos.get("1").getEmail();
		assertThat(valorEsperado,is(valorEjecucion));
		System.out.println("Resultado updateEmail: " + res);
	}
	
	//Test para buscar alumno
	@Test
	public void searchAlumnoTest() {
		when(DAO.searchAlumno(anyString())).thenAnswer(new Answer<Alumno>() {
			public Alumno answer(InvocationOnMock invocation) throws Throwable{
				// Set behavior
				String id = (String) invocation.getArguments()[0];
				
				// Save new in same id
				Alumno a = baseDatos.get(id);
				return a;
			}
		});
		// Setup
		// add to baseDatos
		Alumno a = new Alumno("nombre", "1", "email", 21);
		baseDatos.put("1", a);

		// Call search method
		Alumno res = DAO.searchAlumno("1");
		
		// Verify
		String nomEsperado = res.getNombre();
		String idEsperado = res.getId();
		int edadEsperado = res.getEdad();
		String emailEsperado = res.getEmail();

		String nomEjecucion = baseDatos.get("1").getNombre();
		String idEjecucion = baseDatos.get("1").getId();
		int edadEjecucion = baseDatos.get("1").getEdad();
		String emailEjecucion = baseDatos.get("1").getEmail();
		
		assertThat(nomEsperado,is(nomEjecucion));
		assertThat(idEsperado,is(idEjecucion));
		assertThat(edadEsperado,is(edadEjecucion));
		assertThat(emailEsperado,is(emailEjecucion));


		System.out.println("Resultado searchAlumno: " + res);
	}
	
}
