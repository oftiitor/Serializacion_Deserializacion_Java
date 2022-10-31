package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import coche.Coche;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static ArrayList<Coche> coches;
	
	public static void main(String[] args) {

		int opcion = 0;
		boolean salir = true;
		File fichero = new File("Coches.txt");
		
		if (fichero.exists()) {
			coches = Deserializar("Coches.txt");
		} else {
			coches = new ArrayList<Coche>();
		}
		
		do {
			
			try {
				
				System.out.println("\nElija una de las siguientes opciones:");
				System.out.println("1. Leer la informacion de un coche.");
				System.out.println("2. Introducir un nuevo coche.");
				System.out.println("3. Salir.\n");
				
				opcion = Integer.parseInt(br.readLine());
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			switch (opcion) {
			case 1:
				
				if (coches.isEmpty()) {
					System.out.println("No existen coches.");
				} else {
					
					System.out.println("Introduce la matricula del coche que desea buscar.");
										
					try {
						System.out.println(buscarCoche(br.readLine()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
								
				break;
				
			case 2:
				
				String marca = "";
				String modelo = "";
				String matricula = "";
				int anyoMatriculacion = 0;
				double precio = 0;
				
				boolean comprobarNumeros = true;
				
				try {
					
					System.out.println("Introduce la marca del coche:");
					marca = br.readLine();
					
					System.out.println("Introduce el modelo del coche:");
					modelo = br.readLine();
					
					System.out.println("Introduce la matricula del coche:");
					matricula = br.readLine();
					
					System.out.println("Introduce el anyo de matriculacion del coche:");

					do {
						
						comprobarNumeros = true;
						
						try {
							anyoMatriculacion = Integer.parseInt(br.readLine());
						} catch (Exception e) {
							System.out.println("Introduce un anyo valido (Numerico).");
							comprobarNumeros = false;
						}
						
					} while (comprobarNumeros==false);
					
					System.out.println("Introduce el precio del coche:");
					
					do {
						
						comprobarNumeros = true;
						
						try {
							precio = Double.parseDouble(br.readLine());
						} catch (Exception e) {
							System.out.println("Introduce un precio valido (Numerico).");
							comprobarNumeros = false;
						}
					} while (comprobarNumeros==false);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				Coche coche = new Coche(marca, modelo, matricula, anyoMatriculacion, precio);
				coches.add(coche);
												
				break;
				
			case 3:
				System.out.println("\nGracias por usar nuestros servicios.\nEsperamos volver a verte pronto.");
				salir = false;
				break;

			default:
				System.out.println("El numero introducido no es valido");
				break;
			}
			
		} while (salir == true);
		
		Serializar(coches, "Coches.txt");
		
	}
	
	private static Coche buscarCoche(String matricula) {
		
		for (Coche coche : coches) {
			if (coche.getMatricula().equalsIgnoreCase(matricula)) {
				return coche;
			}
		}
		
		return null;
	}

	public static void Serializar(ArrayList<Coche> coches, String ruta) {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream(ruta);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(coches);
			
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Coche> Deserializar(String ruta) {
		
		ArrayList<Coche> coches = null;
		FileInputStream fis;
		ObjectInputStream ois;
		
		try {
			fis = new FileInputStream(ruta);
			ois = new ObjectInputStream(fis);
			
			coches = (ArrayList<Coche>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return coches;
		
	}

}