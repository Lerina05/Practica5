package aula;

import java.awt.Dimension;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Aplicacion {

	// Atributos
	private Lista miLista;

	// Constructor
	private Aplicacion() { // Private porque nadie lo va a usar fuera
		// miLista estaba declarado pero no creado, lo creo e inicializo a null
		miLista = null;
		int opcion = 0;
		String mensajeMenu = "1.- Crear Lista\n2.- A�adir Alumno\n3.- Borrar Alumno\n4.- Mostrar Datos Alumno\n5.- Salir";

		do {
			// Para usarlo con librer�as
			// CrearMenus.crearMenu(mensajeMenu, "Gestionar Lista Alumnos",
			// opciones)
			String cadena = JOptionPane.showInputDialog(mensajeMenu);
			opcion = Integer.parseInt(cadena);

			switch (opcion) {
			case 1:
				// Crear la lista sino existe
				if (miLista == null) {
					String nombreLista = JOptionPane
							.showInputDialog("Nombre de la lista");
					miLista = crearLista();
				} else {
					JOptionPane.showMessageDialog(null, "Ya existe una lista");
				}
				break;

			case 2:
				// A�adir alumnos
				// Si mi lista no existe
				if (miLista == null) {
					JOptionPane.showMessageDialog(null,
							"Debes crear una lista primero");
					// Si mi lista est� llena
				} else if (miLista.getMiLista().length == miLista
						.getNumeroAlumnos()) {
					JOptionPane
							.showMessageDialog(null,
									"La lista de alumnos est� completa, no se pueden a�adir m�s alumnos");
				} else {
					// Primero creamos el alumno
					Alumno miAlumno = crearAlumno();

					// En segundo lugar le a�ado a la lista
					miLista.a�adirAlumno(miAlumno);
				}
				break;

			case 3:
				if (miLista == null) {
					JOptionPane
							.showMessageDialog(null, "Primero crea la lista");
				} else if (miLista.getNumeroAlumnos() == 0) {
					JOptionPane.showMessageDialog(null,
							"No hay alumnos en la lista");
				} else {
					// Borrar alumnos
					String nombreBorrar = JOptionPane
							.showInputDialog("Introduce el alumno a borrar");
					miLista.borrarAlumno(nombreBorrar);
				}
				break;

			case 4:
				mostrarDatos();
				break;

			case 5:
				JOptionPane
						.showMessageDialog(null, "El programa ha finalizado");
				break;
			}

		} while (opcion != 5);
	}

	// M�todo para mostrar los alumnos de la lista en una tabla
	public void mostrarDatos() {
		// Vector para la cabecera de la tabla (columnas)
		Object[] titulo = { "NOMBRE", "EDAD" };
		// Crear el array con los datos de la lista
		Object[][] datos = new Object[miLista.getNumeroAlumnos()][titulo.length];
		/*
		 * datos son las filas que contiene la tabla, as� que con .length
		 * sabemos el n�mero de filas que tiene
		 */
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = miLista.getMiLista()[i].getNombre();
			datos[i][1] = miLista.getMiLista()[i].getEdad();
		}

		JTable tabla = new JTable(datos, titulo);
		// Damos un valor fijo a la tabla
		tabla.setPreferredScrollableViewportSize(new Dimension(200, 70));
		// Le decimos que queremos visualizarla con scroll
		JScrollPane barraDesplazamiento = new JScrollPane(tabla);
		JOptionPane.showMessageDialog(null, barraDesplazamiento, "Listado de Alumnos", 1);

	}

	// M�todo para crear un objeto de tipo Alumno
	public Alumno crearAlumno() {
		String nombre = JOptionPane.showInputDialog("Introduce el nombre");
		int edad = Integer.parseInt(JOptionPane
				.showInputDialog("Introduce la edad"));
		Alumno miAlumno = new Alumno(nombre, edad);
		return miAlumno;
	}

	// M�todo para crear un objeto de tipo Lista
	public Lista crearLista() {
		String maxAlum = JOptionPane
				.showInputDialog("M�ximo n�mero de alumnos");
		int totalAlumnos = Integer.parseInt(maxAlum);

		Lista nuevaLista = new Lista(totalAlumnos);

		return nuevaLista;
	}
	
	// Convertir la primera letra de cada palabra a mayuscula
	public static String primeraLetraMayuscula (String cadena) {
		String cadenaCompleta = "";
		String parteCadena = "";
		StringTokenizer miTokenizer = new StringTokenizer (cadena);
		
		while (miTokenizer.hasMoreTokens()) {
			parteCadena = miTokenizer.nextToken();
			cadenaCompleta += parteCadena.toUpperCase().charAt(0) + parteCadena.substring(1, parteCadena.length()).toLowerCase();
		}
		
		cadenaCompleta = cadenaCompleta.substring(0, cadenaCompleta.length() - 1);
		return cadenaCompleta;
	}

	public static void main(String[] args) {
		// Creo el objeto de tipo Aplicacion
		new Aplicacion();
		// Cerrar la aplicaci�n
		System.exit(0);
	}
}
