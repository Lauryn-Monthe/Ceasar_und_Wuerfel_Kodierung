package pis.hue1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Lauryn Monthe
 * @version 13.0.1 
 */
public class CodecGui extends JFrame {
	JPanel panel = new JPanel();
	final Codec caesar; //Objekt von Klasse Caesar
	final Codec wuerfel; //Objekt von Klasse Wuerfel
	/**
	 * Die main Methode
	 * @param args Parameter von main Methode
	 */ 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new CodecGui("Hallo"); //Objekt von CodecGUI
			}
		});
	}
	/**
	 * Kontruktor von CodecGui
	 * @param title Titel von Gui
	 * Dieser Konstruktor fuegt die Komponent in GUI hin.
	 */
	public CodecGui(String title) {
		caesar = new Caesar();
		wuerfel = new Wuerfel("");
		setVisible(true); // Um das FRame zu sehen
		setSize(800, 600); //Size von Frame
		setLocationRelativeTo(null);
		setTitle("CodecGui"); // Title von GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Exit wenn man close druckt
		JRadioButton radiobutton1 = new JRadioButton("Caesar"); //RadioButton erstellen
		JRadioButton radiobutton2 = new JRadioButton("Wuerfel");
		JButton button3 = new JButton("Verschluesselung"); // Button erstellen
		JButton button4 = new JButton("Entschluesselung");
		JLabel label1 = new JLabel("Klartext eingeben: "); //Label erstellen
		JLabel label2 = new JLabel("Geheimtext eingeben: ");
		JLabel label3 = new JLabel("Losungswort 1 eingeben: ");
		JLabel label4 = new JLabel("Losungswort 2 eingeben: ");
		JTextField field1 = new JTextField(45); //Field erstellen
		JTextField field2 = new JTextField(45);
		JTextArea text1 = new JTextArea(10,20); //Area erstellen
		JTextArea text2 = new JTextArea(10,20);
		ButtonGroup bg= new ButtonGroup(); //ButtonGroup erstellen
		bg.add(radiobutton1); // die radiobutton in ButtonGroup hinzufuegen
		bg.add(radiobutton2);
		setBackground(Color.pink);
		setForeground(Color.blue);

		button3.addActionListener(new ActionListener() { //Aktion in button3 hinfuegen
			/**
			 * Diese Methode enhaelt die Funktionalitaeten von Kodiere
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				caesar.setzeLosung(field1.getText()); //Losung gleich der Text  in field1 
				if(text1.getText().isEmpty() || field1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(text1, "Klartext oder Losungswort ist leer");
				}
				else if(radiobutton1.isSelected()) { //Wenn man radiobutton1 druckt
					text2.setText(caesar.kodiere(text1.getText())); //Klartext kodieren und zurueckgeben in text2
				}
				else if(radiobutton2.isSelected()) { //Wenn man radiobutton2 druckt
					wuerfel.setzeLosung(field1.getText()); 
					wuerfel.kodiere(text1.getText());
					String text = wuerfel.kodiere(text1.getText());
					wuerfel.setzeLosung(field2.getText());
					text2.setText(wuerfel.kodiere(text));
					//Klartext kodieren(Doppelwuerfel) und zurueckgeben in text2
				}
			}
		});
		
		button4.addActionListener(new ActionListener() {
			/**
			 * Diese Methode enhaelt die Funktionalitaeten von Dekodiere
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(text2.getText().isEmpty() || field1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(text2, "Geheimtext oder Losungswort ist leer");
				}
				else if(radiobutton1.isSelected())
					text1.setText(caesar.dekodiere(text2.getText()));

				else if(radiobutton2.isSelected() && !field1.getText().isEmpty() && !field2.getText().isEmpty()) {
					//Wenn man radiobutton2 druckt
					wuerfel.setzeLosung(field2.getText());
					wuerfel.dekodiere(text2.getText());
					String text = wuerfel.dekodiere(text2.getText());
					wuerfel.setzeLosung(field1.getText());
					text1.setText(wuerfel.dekodiere(text));
					//Geheimtext kodieren(Doppelwuerfel) und zurueckgeben in text1
				}
			}
		});
		
		//Alle Objekten in in Objekt pannel hinfuegen
		panel.add(label1);
		panel.add(new JScrollPane(text1));
		panel.add(label2);
		panel.add(new JScrollPane(text2));
		panel.add(label3);
		panel.add(field1);
		panel.add(label4);
		panel.add(field2);
		panel.add(radiobutton1);
		panel.add(radiobutton2);
		panel.add(button3);
		panel.add(button4);
		//panel in JFrame hinfuegen
		add(panel);
	}

}
