package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GestaoTimeApp {


	public static void main(String[] args) {

		DesafioMeuTimeApplication gestaoTime = new DesafioMeuTimeApplication();

		
        gestaoTime.incluirTime(1l, "Vasco", LocalDate.now(), "branca", "preta");
        
        BigDecimal salario = new BigDecimal("100000.0");
        gestaoTime.incluirJogador(1l, 1l, "Jogador1", LocalDate.now(), 1, salario);

        salario = salario.add(new BigDecimal("1000.00"));
        gestaoTime.incluirJogador(2l, 1l, "Jogador1", LocalDate.now(), 1, salario);
        

        gestaoTime.listaTimes.forEach(System.out::println);
        gestaoTime.listaJogadores.forEach(System.out::println);


	}

}
