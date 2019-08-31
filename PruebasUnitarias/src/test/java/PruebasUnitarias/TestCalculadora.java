package PruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculadora {
	
	Calculadora calcula = new Calculadora();
	
	@Test
	public void test() {
		int resultadoMultiplica = calcula.multiplica(2, 4);
		assertEquals(8, resultadoMultiplica);
	}

}
