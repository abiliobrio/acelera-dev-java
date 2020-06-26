package com.codenation.calculadora;

public class CalculadoraSalario {
	
	private static final double MINIMO = 1039.00;

	public long calcularSalarioLiquido(double salarioBase) {
		
		if (salarioBase < MINIMO) {
			return Math.round(0.00);
		}
		
		double vlrInss = calcularInss(salarioBase);
		
		double baseCalcIr = salarioBase - vlrInss;
		
		double vlrIr = calcularIr(baseCalcIr);
				
		return Math.round(salarioBase - (vlrInss + vlrIr));
	}

	private double calcularInss(double salarioBase) {
		return salarioBase * percInss(salarioBase);
	}

	private double calcularIr(double salarioBase) {
		return salarioBase * percIrr(salarioBase);
	}

	private double percInss(double baseCalcInss) {
		if (baseCalcInss <= 1500)
			return 0.08;
		else if (baseCalcInss <= 4000)
			return 0.09;
		else
			return 0.11;
	}
	
	private double percIrr(double baseCalcIr) {
		
		if (baseCalcIr <= 3000)
			return 0;
		else if (baseCalcIr > 3000 && baseCalcIr <= 6000)
			return 0.075;
		else
			return 0.15;
	}
	
}
