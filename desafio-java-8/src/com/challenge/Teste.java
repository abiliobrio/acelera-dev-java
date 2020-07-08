package com.challenge;

import java.math.BigDecimal;

public class Teste {

	public Teste(int valor1, String nome, Double valor2, BigDecimal valor3) {
		super();
		this.valor1 = valor1;
		this.nome = nome;
		this.valor2 = valor2;
		this.valor3 = valor3;
	}
	
	private int valor1;
	private String nome;
	private Double valor2;
	private BigDecimal valor3;
	
	public int getValor1() {
		return valor1;
	}
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor2() {
		return valor2;
	}
	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}
	public BigDecimal getValor3() {
		return valor3;
	}
	public void setValor3(BigDecimal valor3) {
		this.valor3 = valor3;
	}

	
}
