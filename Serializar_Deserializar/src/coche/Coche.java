package coche;

import java.io.Serializable;

public class Coche implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String marca, modelo, matricula;
	private int anyoMatriculacion;
	private double precio;
	
	public Coche(String marca, String modelo, String matricula, int anyoMatriculacion, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.anyoMatriculacion = anyoMatriculacion;
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public int getAnyoMatriculacion() {
		return anyoMatriculacion;
	}
	
	public void setAnyoMatriculacion(int anyoMatriculacion) {
		this.anyoMatriculacion = anyoMatriculacion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "\nCoche:\n - Marca: " + marca + ".\n - Modelo: " + modelo + ".\n - Matricula: " + matricula + ".\n - Anyo de matriculacion: " + anyoMatriculacion + ".\n - Precio: " + precio + ".\n";
	}
	
}