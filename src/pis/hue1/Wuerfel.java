package pis.hue1;
/**
 * 
 * @author Lauryn Monthe
 * @version 13.0.1 
 */
public class Wuerfel implements Codec {
	public String losung;
	/**
	 * 
	 * @param losung
	 */
	public Wuerfel(String losung) {
		this.losung = losung;
	}
	/**
	 * @param klartext Text zu kodieren
	 * Ein Array erstellen
	 * Index von Zeichen der Losungwort speichern
	 * Hinfuegen aufsteigenden Ziffern mit gespeichtete Index
	 * Das Array mit zwei for Schleifen durchlaufen 
	 * Wenn man der kleinste Ziffer gefunden hat, dann speichert man das Index
	 * Durchlaufen die Klartext bis die Laenge von Klartext geteilt durch Laenge von Losung und alles +1
	 * Hinguefen die erste Buchstabe von Klartext an diesem Index in eine String Variable und man macht i + die Laenge von Losung
	 * String Variable zurueckgeben
	 */
	@Override
	public String kodiere(String klartext) {
		String result = "";
		String temp = losung.toLowerCase(); //Alle Buchstaben von Losung klein machen
		int array[] = new int[temp.length()]; //Array erstellen, der die Laenge von Losung als Laenge hat
		int x = 0; //Deklaration und Initialisierung einer Variable
		char c = 'a';  //Deklaration und Initialisierung einer Variable
		do {
			for(int j = 0; j < losung.length(); j++) {
				if(c == temp.charAt(j)) { //Wenn c ist gleich mit einem Zeichen in Losung
					array[j] = x; //x in index j in array hinfuegen
					x++; //Inkrementation von x
				}
			}
			c++; //Inkrementation von c
		} while(c <= 'z');
		for(int j = 0; j < array.length; j++ ) {
			for(int i = 0; i < array.length; i++ ) {
				if(array[i] == j) { //Wenn j gleich mit einem Zeichen in Losung ist
					for(int z = 0; z < klartext.length() / losung.length()+1; z++) {
						result += klartext.charAt(i);//Das Zeichen hinfuegen
						i += losung.length();
						if(i >= klartext.length())
							break;
					}
				}
			}
		}
		return result;
	}
/**
 * @param geheimtext Text zu dekodieren
 * Ein Array erstellen
 * Index von Zeichen der Losungwort speichern
 * Hinfuegen aufsteigenden Ziffern mit gespeichtete Index
 * Das Array mit zwei for Schleifen durchlaufen 
 * Wenn man der kleinste Ziffer gefunden hat, dann speichert man das Index
 * Geheimtexte durchlaufen von dem Index bis die Laenge von Geheimtext 
 * Erste Buchstabe von Geheimtext in einem Array auf gespeichtete Index hinfuegen
 * Dann die index + Laenge der Losung
 * Die zewite Buchstarbe auf die neue Index speichern usw...
 */
	@Override
	public String dekodiere(String geheimtext) {
		String result = "";
		char[] b = new char[geheimtext.length()];
		String temp = losung.toLowerCase();//Alle Buchstaben von Losung klein machen
		int array[] = new int[temp.length()];//Array erstellen, der die Laenge von Losung als Laenge hat
		int x = 0; //Deklaration und Initialisierung einer Variable
		char c = 'a'; //Deklaration und Initialisierung einer Variable
		do {
			for(int j = 0; j <losung.length(); j++) { 
				if(c == temp.charAt(j)) { //Wenn c ist gleich mit einem Zeichen in Losung
					array[j] = x; //x in index j in array hinfuegen
					x++;
				}
			}
			c++;
		} while(c <= 'z');
		int stringPointer = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[j] == i) {
					for(int k = j; k < geheimtext.length(); k += losung.length()) { 
						b[k] = geheimtext.charAt(stringPointer); //Erste Buchstarbe auf Index k speichern
						stringPointer++;
					}
					break;
				}
			}
		}
		result = new String(b);
		return result;
	}
/**
 * Diese Methode return die Losung
 */
	@Override
	public String gibLosung() {
		return this.losung;
	}
/**
 * @param schluessel ist die neue Losung
 * Diese Methode setze die Losung und return die neue Losung
 */
	@Override
	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		this.losung = schluessel;
	}
}
