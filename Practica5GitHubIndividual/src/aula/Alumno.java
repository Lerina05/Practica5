package aula;

public class Alumno {
	
	// Atributos
	private String nombre;
	private int edad;
	
	// Constructor
	public Alumno (String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// Comportamiento
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}	
}
