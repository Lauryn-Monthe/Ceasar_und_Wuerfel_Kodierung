package pis.hue1;
/**
 * 
 * @author Lauryn Monthe
 * @version 13.0.1 
 */
public interface Codec {
	public String kodiere(String klartext); 
	 public String dekodiere(String geheimtext);
	 public String gibLosung();
	 public void setzeLosung(String schluessel)throws
	 IllegalArgumentException;

}
