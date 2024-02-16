package fecha;

/**
 * Clase que contiene diferentes métodos para manejar las fechas
 * y usando diferentes métodos, comprueba que la fecha sea correcta,
 * si un año es bisiesto o no... Etc.
 * @author Antonio
 * @version 1.0
 */
public class Fecha {
	/**
	 * Este atributo será el día.
	 */
	private int d; //d�a
	
	/**
	 * Este atributo es el mes.
	 */
	private int m; //mes
	
	/**
	 * Este atributo es el año.
	 */
	private int a; //a�o

	/**
	 * Este método es un constructor vacío.
	 */
	public Fecha() {

	}

	/**
	 * Método constructor que toma como parámetros el día, mes y año.
	 * @param dia Variable que contendrá el día
	 * @param mes Variable que contendrá el mes
	 * @param anio Variable que contendrá el año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Función que comprueba si la fecha es correcta o no. Devolverá
	 * un booleano indicando si lo es o no.
	 * @return diaCorrecto && mesCorrecto && anioCorrecto Devuelve tres booleanos
	 * indicando cuál de las tres variables son incorrectas.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}
	
	/**
	 * Función privada que sólo lo usa fechaCorrecta. Se encarga de comprobar
	 * si un año es bisiesto o no a través de un booleano.
	 * @return esBisiesto Devuelve un booleano diciendo si el año es bisiesto o no.
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}
	
	/**
	 * Función que añade un día más al atributo d.
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método que pasa la fecha a un String.
	 * @return Dependiendo de qué atributos valgan menor que o mayor que 10,
	 * devolverán un String u otro.
	 */
	// M�todo toString
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
