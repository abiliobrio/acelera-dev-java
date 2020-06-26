package com.codenation.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.codenation.calculadora.CalculadoraSalario;

public class CalculadoraSalarioTest {

	@Test
	public void salarioLiquidoIsNotNull() {
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(1000.0));
	}

}