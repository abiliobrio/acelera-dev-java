package com.challenge;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class ClasseAnnotation {
	
	public ClasseAnnotation(BigDecimal valor1, int valor2, BigDecimal valor3, String nome, long valor4, BigDecimal valor5,
			String texto) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.nome = nome;
		this.valor4 = valor4;
		this.valor5 = valor5;
		this.texto = texto;
	}

	@Somar
	private BigDecimal valor1;
	
	int valor2;
	
	@Somar
	private BigDecimal valor3;

	private String nome;

	private long valor4;
	
	@Subtrair
	private BigDecimal valor5;
	
	private String texto;

	public BigDecimal getValor1() {
		return valor1;
	}

	public void setValor1(BigDecimal valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public BigDecimal getValor3() {
		return valor3;
	}

	public void setValor3(BigDecimal valor3) {
		this.valor3 = valor3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getValor4() {
		return valor4;
	}

	public void setValor4(long valor4) {
		this.valor4 = valor4;
	}

	public BigDecimal getValor5() {
		return valor5;
	}

	public void setValor5(BigDecimal valor5) {
		this.valor5 = valor5;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	

	
}
