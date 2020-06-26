package com.codenation.java;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static void main(String[] args) {

		System.out.println(fibonacci());
		
		Integer nr = Integer.parseInt(args[0].toString());

		System.out.print(nr);
		if (isFibonacci(nr))
			System.out.println(" é um número Fibonacci");
		else
			System.out.println(" não é um número Fibonacci");

	}

	public static List<Integer> fibonacci() {

		List<Integer> lista = new ArrayList<Integer>();

		int antes = 0;
		int atual = 1;
		int prox = 0;
		int ultimo = 350;

		lista.add(antes);
		lista.add(atual);

		while (atual < ultimo) {

			prox = antes + atual;
			lista.add(prox);
			antes = atual;
			atual = prox;
		}

		return lista;
	}

	public static Boolean isFibonacci(Integer numero) {
		
		return fibonacci().contains(numero); 

	}

}