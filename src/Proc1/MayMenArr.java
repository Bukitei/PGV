package Proc1;

import java.util.Scanner;

public class MayMenArr {
	
	static int contador;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] arr = new int[50];
		int n;
		int i = 0;
		int mayor = 0;
		int menor;
		int suma = 0;
		int media;
		
		
		System.out.println("Dame el primer número: ");
		n = in.nextInt();
		arr[i] = n;
		i++;
		
		
		while(n != -1) {
			System.out.println("Dame otro número, cuando te quieras detener pon -1: ");
			n = in.nextInt();
			arr[i] = n;
			i++;
			contador++;
		}
		
		in.close();
		
		menor = arr[0];
		
		for(int j = 0; j < i; j++) {
			if(mayor < arr[j] && arr[j] != -1) {
				mayor = arr[j];
				}
			if(menor > arr[j] && arr[j] != -1) {
				menor = arr[j];
			}
			suma = suma + arr[j];			
		}
		
		media = suma / contador;
		
		ordenarBurbuja(arr);
		
		System.out.println("Hemos finalizado, el mayor número es: "+mayor+", el menor es: "+menor+", la media es: "+media+" y la suma es: "+suma+".");
	}
	
	public static void ordenarBurbuja(int[] arr) {
		
		int cambiador;
		int counter = 0;
		
		for(int i = 1; i < contador; i++) {
			for(int j = 0; j < contador - i; j++) {
				if(arr[j] > arr[j+1]) {
					counter++;
					cambiador = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = cambiador;
					System.out.println("Modificación número "+counter+": ");
					imprimirArray(arr);
				}
			}
		}
	}
	
	public static void imprimirArray(int[] arr) {
		
		System.out.println();
		System.out.print("[");
		
		for(int i = 0; i < contador; i++) {
			if(i != contador-1) {
				System.out.print(arr[i]);
				System.out.print(", ");
			}else {
				System.out.print(arr[i]);
			}
			
		}
		System.out.println("]");
		System.out.println();
	}

}
