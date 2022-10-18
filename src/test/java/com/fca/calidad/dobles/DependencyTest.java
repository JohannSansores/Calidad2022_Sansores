package com.fca.calidad.dobles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.*;
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

	@Test
	public void testDummy() {
		assertThat(dependency.getClassName(),is(nullValue()));
	}
}