package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object classe) {
		BigDecimal result = new BigDecimal(0);
		Field[] campos = classe.getClass().getDeclaredFields();
		for (Field prop : campos) {
			prop.setAccessible(true);
			if (prop.getType().toString().equals("class java.math.BigDecimal")) {
				if (prop.isAnnotationPresent(Somar.class)) {
					try {
						BigDecimal vlr = new BigDecimal(0);
						vlr = (BigDecimal) prop.get(classe);
						result = result.add(vlr);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	@Override
	public BigDecimal subtrair(Object classe) {
		BigDecimal result = new BigDecimal(0);
		Field[] campos = classe.getClass().getDeclaredFields();
		for (Field prop : campos) {
			prop.setAccessible(true);
			if (prop.getType().toString().equals("class java.math.BigDecimal")) {
				if (prop.isAnnotationPresent(Subtrair.class)) {
					try {
						BigDecimal vlr = new BigDecimal(0);
						vlr = (BigDecimal) prop.get(classe);
						result = result.add(vlr);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	@Override
	public BigDecimal totalizar(Object classe) {

		BigDecimal soma = new BigDecimal(0);
		BigDecimal subtr = new BigDecimal(0);

		Field[] campos = classe.getClass().getDeclaredFields();
		for (Field prop : campos) {
			prop.setAccessible(true);
			if (prop.getType().toString().equals("class java.math.BigDecimal")) {
				if (prop.isAnnotationPresent(Somar.class)) {
					BigDecimal valor = new BigDecimal(0);
					try {
						valor = (BigDecimal) prop.get(classe);
						soma = soma.add(valor);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				} else if (prop.isAnnotationPresent(Subtrair.class)) {
					BigDecimal valor;
					try {
						valor = (BigDecimal) prop.get(classe);
						subtr = subtr.add(valor);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return soma.subtract(subtr);
	}

}
