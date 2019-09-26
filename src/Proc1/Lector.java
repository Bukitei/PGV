package Proc1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.JFrame;

import org.jfree.data.category.DefaultCategoryDataset;
//import java.util.Scanner;

public class Lector {
	static int contador;
//	static int[] arr = new int[50];
	static ArrayList<Integer> arr = new ArrayList<>();
	static String n;
	static int i = 0;

	public static void main(String[] args) throws IOException {

//		Scanner in = new Scanner(System.in);
//		int[] arr = new int[50];
//		int n;
//		int i = 0;
		int mayor = 0;
		int menor;
		int suma = 0;
		int media;
		
		
//		System.out.println("Dame el primer número: ");
//		n = in.nextInt();
//		arr[i] = n;
//		i++;
//		
//		
//		while(n != -1) {
//			System.out.println("Dame otro número, cuando te quieras detener pon -1: ");
//			n = in.nextInt();
//			arr[i] = n;
//			i++;
//			contador++;
//		}
		
//		in.close();
		
		cargarDatosFicheros("enteros.txt");
		
		menor = arr.get(0);
		
		for(int j = 0; j < i; j++) {
			if(mayor < arr.get(j) && arr.get(j) != -1) {
				mayor = arr.get(j);
				}
			if(menor > arr.get(j) && arr.get(j) != -1) {
				menor = arr.get(j);
			}
			suma = suma + arr.get(j);			
		}
		
		media = suma / contador;
		
		ordenarBurbuja(arr);
		
		generarGrafico(arr);
		
		System.out.println("Hemos finalizado, el mayor número es: "+mayor+", el menor es: "+menor+", la media es: "+media+" y la suma es: "+suma+".");
	}

	public static void ordenarBurbuja(ArrayList<Integer> arr) {
		
		int cambiador;
		int counter = 0;
		
		for(int i = 1; i < contador; i++) {
			for(int j = 0; j < contador - i; j++) {
				if(arr.get(j) > arr.get(j+1)) {
					counter++;
					cambiador = arr.get(j+1);
					arr.remove(j+1);
					arr.add(j+1, arr.get(j));
					arr.remove(j);
					arr.add(j, cambiador);
					System.out.println("Modificación número "+counter+": ");
					imprimirArray(arr);
				}
			}
		}
	}
	
	public static void imprimirArray(ArrayList<Integer> arr) {
		
		System.out.println();
		System.out.print("[");
		
		for(int i = 0; i < contador; i++) {
			if(i != contador-1) {
				System.out.print(arr.get(i));
				System.out.print(", ");
			}else {
				System.out.print(arr.get(i));
			}
			
		}
		System.out.println("]");
		System.out.println();
	}

	public static void cargarDatosFicheros (String nombre) throws IOException{
		FileInputStream file = new FileInputStream(nombre);
		InputStreamReader in = new InputStreamReader(file, "UTF-8");
		BufferedReader data = new BufferedReader(in);
		
		int number = 0;
		
		while(contador < 20 && (n = data.readLine()) != null && (number = Integer.parseInt(n)) != -1) {
			arr.add(number);
			i++;
			contador++;
		}
		file.close();
		in.close();
		data.close();
		
	}
	
	private static void generarGrafico(ArrayList<Integer> nums) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Gráficos en números");
		frame.setSize(512,512);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {				
				dataset.addValue(count, "Fila "+i, "Columna "+j);
				count++;
			}
		}
		

		JFreeChart chart = ChartFactory.createBarChart(
				  "Gráfica",
				  "Categorías",
				  "Valores",
				  dataset,
				  PlotOrientation.VERTICAL,
				  true,
				  true,
				  true
				);
		
		ChartPanel chartPanel = new ChartPanel(chart, false);
		frame.setContentPane(chartPanel);
		frame.setVisible(true);
	}
}
