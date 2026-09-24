import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnView extends JPanel {
    private GewinnModel model = new GewinnModel();

    private JLabel rundenErgebnis= new JLabel("Rundenergebnis:");
    private JLabel gesamtPunkte= new JLabel("Gesamtpunkte:");
    private JLabel deineZahl= new JLabel("Deine Zahl:");
    private JLabel computerZahl=  new JLabel("Computer:");
    private JButton nochmal= new JButton("Noch einmal!");

    private JTextField computerOutput= new JTextField();
    private JTextField input = new JTextField();
    private JLabel runde = new JLabel();
    private JLabel punkte = new JLabel();

    public GewinnView() {
        this.setLayout(new GridLayout(4, 2));
        computerOutput.setEnabled(false);

        add(rundenErgebnis);
        add(gesamtPunkte);
        add(runde);
        add(punkte);
        add(deineZahl);
        add(computerZahl);
        add(input);
        add(computerOutput);
        //add(nochmal);


        JButtonHandler bh = new JButtonHandler();
        nochmal.addActionListener(bh);
        input.addActionListener(bh);
    }

    private class JButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o  = e.getSource();

            if (o == nochmal) {
                runde.setText("Tippe eine Zahl von 1 bis 9");
                punkte.setText("Gesamtpunkte: 30");
                input.setText("");
                computerOutput.setText("");
            }

            if (o == input) {
                model.berechneComputerZahl();
                computerOutput.setText(Integer.toString(model.getComputerZahl()));

                model.berechneRunde(Integer.parseInt(input.getText()));
                runde.setText(Integer.toString(model.getRundenErgebnis()));

                punkte.setText(Integer.toString(model.getGesamtPunkte()));
            }
        }
    }
}
