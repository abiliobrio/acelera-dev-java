package br.com.codenation;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma =0;

		for(int i = 0; i < elements.length; i++){
			soma += elements[i];
		}
		return soma/elements.length;
	}

	public static int mode(int[] elements) {
		int valorModa = 0;
		int quantidadeModa = 0;
		int valorModaVez = 0;
		int quantidadeModaVez = 0;
		int quantidadeModaRepetida =0;
		for(int i = 0; i < elements.length; i++){
			valorModaVez = elements[i];
			quantidadeModaVez = 0;
			for(int u = 0; u < elements.length; u++){
				 if (elements[u] == valorModaVez) {
					 quantidadeModaVez += 1;
					 quantidadeModaRepetida =0;
				 }
			}
			if (quantidadeModaVez > quantidadeModa ){
				valorModa = valorModaVez;
			}else if (quantidadeModaVez == quantidadeModa){
				quantidadeModaRepetida += quantidadeModaRepetida;
			}
		}
		if (quantidadeModaRepetida > 0){
			return 0;
		}
		return valorModa;
	}

	public static int median(int[] elements) {
		int tamanho = elements.length;
		if (tamanho % 2 == 0) {

			return (elements[tamanho/2] + elements[(tamanho/2)+1])/2;

		} else {
			return elements[(tamanho/2)];
		}

	}
}