import javax.swing.*;

public class GewinnView extends JPanel {
    private JLabel rundenErgebnis= new JLabel("Rundenergebnis");
    private JLabel gesamtPunkte= new JLabel("Gesamtpunkte");
    private JLabel deineZahl= new JLabel("Deine Zahl:");
    private JLabel computerZahl=  new JLabel("Computer:");
    private JButton nochmal= new JButton("Noch einmal!");

    private JTextField computerOutput= new JTextField();
    private JTextField input;
    private JLabel runde;
    private JLabel punkte;
}
