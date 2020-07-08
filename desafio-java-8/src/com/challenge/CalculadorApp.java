package com.challenge;

import java.math.BigDecimal;

import com.challenge.desafio.CalculadorDeClasses;

public class CalculadorApp {

	public static void main(String[] args) {
		
		BigDecimal big1 = new BigDecimal("5000.0");
		BigDecimal big2 = new BigDecimal("5000.0");
		BigDecimal big3 = new BigDecimal("3000.0");
		
		ClasseAnnotation classTest = new ClasseAnnotation(big1, 10, big2, "teste1", 20, big3, "teste2");
		exibeResultado(classTest);
		
		Teste teste = new Teste(1, "abilio", 2.0, new BigDecimal("100.0"));
		exibeResultado(teste);
		  
	}
	
	public static void exibeResultado (Object classe) {
		CalculadorDeClasses calc = new CalculadorDeClasses();
		BigDecimal resultSoma = calc.somar(classe); 
		BigDecimal resultSubt = calc.subtrair(classe);
		System.out.println("Resultado método Somar da " + classe.getClass().toString() + ": " + resultSoma.toString());
		System.out.println("Resultado método Subtrair da " + classe.getClass().toString() + ": " + resultSubt.toString() + '\r');

		BigDecimal tot = calc.totalizar(classe);
		System.out.println("Total: " + tot);
		
		if (tot.equals(new BigDecimal(0))) {
			System.out.println("teste");
		}

	}

}
