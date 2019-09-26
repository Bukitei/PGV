package Proc1;

import java.util.Scanner;

public class MayorNumero {

	public static void main(String[] args) {
		
		int num1;
		int num2;
		int result=0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pon el primero de los dos números: ");
		
		num1 = in.nextInt();
		
		System.out.println("Ahora el segundo: ");
		
		num2 = in.nextInt();
		in.close();
		
		if(num1 > num2) {
			result = num1;
		}
		
		if(num2 > num1) {
			result = num2;
		}
		
		if(result == 0) {
			System.out.println("No hay mayor.");
		}else {
			System.out.println("El mayor es: "+result);
		}
	}

}
