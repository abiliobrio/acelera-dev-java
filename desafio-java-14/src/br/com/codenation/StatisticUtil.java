package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;
	    for (int i = 0; i < elements.length; i++) {
	        soma += elements[i];
	    }
	    return soma / elements.length;
	}

	public static int mode(int[] elements) {
		int maxValor = 0;
		int maxPos = 0;

	    for (int i = 0; i < elements.length; i++) {
	        int posAtual = 0;
	        for (int j = 0; j < elements.length; j++) {
	            if (elements[j] == elements[i]) 
	            	posAtual++;
	        }
	        if (posAtual > maxPos) {
	            maxPos = posAtual;
	            maxValor = elements[i];
	        }
	    }

	    return maxValor;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
	    int media = elements.length / 2;
	    if (elements.length % 2 == 1) {
	        return elements[media];
	    } else {
	        return (elements[media-1] + elements[media]) / 2;
	    }
	}
}