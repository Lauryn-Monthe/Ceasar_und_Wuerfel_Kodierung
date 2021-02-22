package pis.hue1;

/**
 * 
 * @author Lauryn Monthe
 * @version 13.0.1 
 */
public class Caesar implements Codec {
	
	public String losung;
	/**
	 *Dieser Konstruktor ist leer 
	 */
	public Caesar() {
	}
/**
 * @param klartext Text zu kodieren
 * Die Laenge von Losung in einer Variable speicher
 * Klartext mit einem for Schleife durchlaufen
 * Wenn ein Zeichen in Klartext ist zwischen a und z, dann die ASCII Code von diesem Zeichen + Laenge der Losung hinfuegen
 * Wenn ein Zeichen in Klartext ist nicht zwischen a und z, das Zeichen bleibt gleich
 * Das Resultat in einer String Variable speichern und zuruegeben
 */
	@Override
	public String kodiere(String klartext) {
		String result = ""; //Deklaration und Initialisierung von Variable result
		int verschiebung = losung.length(); //Deklaration von Variable verschiebung  und Initialisierung mit die Laenge von Losung
		for(int i = 0; i < klartext.length(); i++) {
			if((int)klartext.charAt(i) > 64 && (int)klartext.charAt(i) < 91) { 
				//Das Zeichen in index i muss zwischen A und Z sein, damit die Sondernzeichen nicht beaendert werden
				
				result += (char)(((int)klartext.charAt(i)-(int)'A'+verschiebung) % 26 + (int)'A'); 
				//Das Zeichen -(int)'A'(um die ASCII Code von der Buchstabe zwichen 0 und 25 zu haben)
				//+verschiebung %26 (um zu verschieben und das Resultat muss kleiner oder gleich 25 sein)
				//+(int)'A'(um die ASCII Code der kodierter Buchstabe zu finden)
			}
			else if((int)klartext.charAt(i) > 96 && (int)klartext.charAt(i) < 123) {
				//Das Zeichen in index i muss zwischen a und b sein, damit die Sondernzeichen nicht beaendert werden
				result += (char)(((int)klartext.charAt(i)-(int)'a'+verschiebung) % 26 + (int)'a');
			}
			else
				result += (char)((int)klartext.charAt(i));
			//Wenn es handelt sich nicht um eine Buchstabe, dann wird die Buchstabe nicht beaendern
		}
		return result;
	}
/**
 * @param geheimtext Text zu dekodieren
 * Die Laenge von Losung in einer Variable speicher
 * Klartext mit einem for Schleife durchlaufen
 * Wenn ein Zeichen in Klartext ist zwischen a und z, dann die ASCII Code von diesem Zeichen - Laenge der Losung hinfuegen
 * Wenn ein Zeichen in Klartext ist nicht zwischen a und z, das Zeichen bleibt gleich
 * Das Resultat in einer String Variable speichern und zuruegeben
 */
	@Override
	public String dekodiere(String geheimtext) {
		String result ="";
		int verschiebung = losung.length();
		for(int i = 0; i < geheimtext.length(); i++) {
			
			int x = (int)geheimtext.charAt(i) - verschiebung - (int)'A';
			int y = (int)geheimtext.charAt(i) - verschiebung - (int)'a';
			
			if(x >= 0 && (int)geheimtext.charAt(i) > 64 && (int)geheimtext.charAt(i) < 91) {
				result += (char)((x) % 26 + (int)'A');
				//Das Zeichen -(int)'A'(um die ASCII Code von der Buchstabe zwichen 0 und 25 zu haben)
				//+verschiebung %26 (um zu verschieben und das Resultat muss kleiner oder gleich 25 sein)
				//+(int)'A'(um die ASCII Code der kodierter Buchstabe zu finden)
			}
			else if(y >= 0 && (int)geheimtext.charAt(i) > 96 && (int)geheimtext.charAt(i) < 123) {
				result += (char)((y) % 26 + (int)'a');
			}
			else if(y <= 0 && (int)geheimtext.charAt(i) > 96 && (int)geheimtext.charAt(i) < 123) {
				result += (char)((y) + 26 + (int)'a');
				//Wenn y negativ ist, dann y%26 wird auch negativ sein. Deswegen muess man statt y%26, y+26 machen.
			}
			else if(x <= 0 && (int)geheimtext.charAt(i) > 64 && (int)geheimtext.charAt(i) < 91) {
				result += (char)((x) + 26 + (int)'A');
			}
			else
				result += (char)((int)geheimtext.charAt(i));
			//Wenn es handelt sich nicht um eine Buchstabe, dann wird die Buchstabe nicht beaendern
		}
		return result;
	}
/**
 * Diese Methode return die Losung
 */
	@Override
	public String gibLosung() {
		return this.losung; //liefern Losung zurueck
	}
/**
 * @param schluessel die neue Losung
 * Diese Methode setze die Losung und return die neue Losung
 */
	@Override
	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		this.losung = schluessel; //liefern die gesetztete Losung zurueck
	}
}
