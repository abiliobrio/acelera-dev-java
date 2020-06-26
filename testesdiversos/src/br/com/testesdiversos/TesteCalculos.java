package br.com.testesdiversos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TesteCalculos {
	
	public static void main(String[] args) {

/*		double d1 = 0.1; 
        double d2 = 0.2;
        System.out.println(d1 + d2);
        
        System.out.println(2.00 - 1.1);
        System.out.println(2.00 - 1.2);
        System.out.println(2.00 - 1.3);
        System.out.println(2.00 - 1.4);
        System.out.println(2.00 - 1.5);
        System.out.println(2.00 - 1.6);
        System.out.println(2.00 - 1.7);
        System.out.println(2.00 - 1.8);
        System.out.println(2.00 - 1.9);
        System.out.println(2.00 - 2);
        
        BigDecimal big1 = new BigDecimal("0.1");
        BigDecimal big2 = new BigDecimal("0.2");
        BigDecimal bigResult = big1.add(big2);
        System.out.println(bigResult.toString());
            

        big1 = new BigDecimal(0.1);
        big2 = new BigDecimal(0.2);
        bigResult = big1.add(big2);
        System.out.println(bigResult.toString());
*/        
        System.out.println("Divide");
        System.out.println(new BigDecimal("1.00").divide
                (new BigDecimal("1.3"),3,RoundingMode.UP));     
        
  }

}
