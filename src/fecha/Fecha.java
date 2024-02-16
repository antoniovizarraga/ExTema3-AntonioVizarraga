package fecha;

/**
 * Clase que contiene diferentes métodos para manejar las fechas
 * y usando diferentes métodos, comprueba que la fecha sea correcta,
 * si un año es bisiesto o no... Etc.
 * @author Antonio
 * @version 1.0
 */
public class Fecha {
	public static final int DIEZ = 10;

	/**
	 * Este atributo será el día.
	 */
	private int diaAtributo; //d�a
	
	/**
	 * Este atributo es el mes.
	 */
	private int mesAtributo; //mes
	
	/**
	 * Este atributo es el año.
	 */
	private int anioAtributo; //a�o

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
		this.diaAtributo = dia;
		this.mesAtributo = mes;
		this.anioAtributo = anio;
	}

	
	/**
	 * Función que comprueba si la fecha es correcta o no. Devolverá
	 * un booleano indicando si lo es o no.
	 * @return diaCorrecto && mesCorrecto && anioCorrecto Devuelve tres booleanos
	 * indicando cuál de las tres variables son incorrectas.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anioAtributo > 0;
		mesCorrecto = mesAtributo >= 1 && mesAtributo <= 12;
		boolean diaMayor1 = diaAtributo >= 1;
		switch (mesAtributo) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && diaAtributo <= 29;
			} else {
				diaCorrecto = diaMayor1 && diaAtributo <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && diaAtributo <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && diaAtributo <= 31;
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
		return anioAtributo % 4 == 0 && anioAtributo % 100 != 0 || anioAtributo % 400 == 0;
	}
	
	/**
	 * Función que añade un día más al atributo d.
	 */
	// M�todo diaSiguiente
	public void nextDay() {
		diaAtributo++;
		if (!fechaCorrecta()) {
			diaAtributo = 1;
			mesAtributo++;
			if (!fechaCorrecta()) {
				mesAtributo = 1;
				anioAtributo++;
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
		String date = "";
		
		if (diaAtributo < DIEZ && mesAtributo < DIEZ) {
			date = "0" + diaAtributo + "-0" + mesAtributo + "-" + anioAtributo;
		} else if (diaAtributo < DIEZ && mesAtributo >= DIEZ) {
			date = "0" + diaAtributo + "-" + mesAtributo + "-" + anioAtributo;
		} else if (diaAtributo >= DIEZ && mesAtributo < DIEZ) {
			date = diaAtributo + "-0" + mesAtributo + "-" + anioAtributo;
		} else {
			date = diaAtributo + "-" + mesAtributo + "-" + anioAtributo;
		}
		
		return date;
	}

}
