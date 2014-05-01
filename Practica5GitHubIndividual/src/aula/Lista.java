package aula;

import javax.swing.JOptionPane;

public class Lista {

	// Atributos
	private Alumno[] miLista;
	private int numeroAlumnos; // Número real de alumnos en lista

	// Constructor
	public Lista(int maximoNumeroAlumnos) {
		miLista = new Alumno[maximoNumeroAlumnos];
		numeroAlumnos = 0; // En el momento de crear la lista de alumnos, el
							// número de alumnos que hay es 0
	}

	// Comportamiento
	public Alumno[] getMiLista() {
		return miLista;
	}

	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}

	// Añado un alumno a la lista a la primera posición libre e incremento el
	// número de alumnos en uno
	public void añadirAlumno(Alumno alumno) {
		miLista[numeroAlumnos] = alumno;
		numeroAlumnos++;
	}

	// Busca en la lista si existe el alumno cuyo nombre le pasamos
	public int buscarAlumno(String nombreBuscado) {
		int posicion = -1;
		boolean encontrado = false;
		int i = 0;
		do {
			if (miLista[i].getNombre().equals(nombreBuscado)) {
				posicion = i;
				encontrado = true;
			}
			i++;
		} while (i < numeroAlumnos && encontrado == false);
		return posicion;
	}

	// Borra un alumno de la lista
	public void borrarAlumno(String nombreBorrar) {
		int posicion = buscarAlumno(nombreBorrar);
		// Si lo ha encontrado lo borro, sino mensaje de que no existe
		if (posicion == -1) {
			JOptionPane.showMessageDialog(null, "El alumno " + nombreBorrar
					+ " no está en la lista");
		} else if (posicion == miLista.length - 1) {
			// Por si el alumno a borrar se encuentra en la última porsición del
			// array
			miLista[posicion] = null;
			numeroAlumnos--;
		} else {
			for (int i = posicion; i < numeroAlumnos; i++) {
				miLista[posicion] = miLista[i];
				// A partir de la posición donde se encuentra el alumno a
				// borrar, guarda lo de la posición siguente en la actual
			}
			numeroAlumnos--;
		}

	}
}
