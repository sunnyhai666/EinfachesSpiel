import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnView extends JPanel {
    private GewinnController controller;

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
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Button
        c.gridy = 4;
        c.gridwidth = 2;
        add(nochmal, c);
        c.gridwidth = 1;


        //Spalte 1
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = 0.2;
        add(rundenErgebnis, c);

        c.gridy = 1;
        c.weighty = 0.2;
        add(runde, c);

        c.gridy = 2;
        c.weighty = 0.2;
        add(deineZahl, c);

        c.gridy = 3;
        c.weighty = 2.0;
        add(input, c);


        //Spalte 2
        c.gridx = 1;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = 0.2;
        add(gesamtPunkte, c);

        c.gridy = 1;
        c.weighty = 0.2;
        add(punkte, c);

        c.gridy = 2;
        c.weighty = 0.2;
        add(computerZahl, c);

        c.gridy = 3;
        c.weighty = 2.0;
        add(computerOutput, c);

        nochmal.setEnabled(false);
        computerOutput.setEnabled(false);
        runde.setBackground(Color.WHITE);
        punkte.setBackground(Color.WHITE);

        runde.setOpaque(true);
        runde.setText("Tippe eine Zahl von 1 bis 9");

        punkte.setOpaque(true);
        punkte.setText("Gesamtpunkte: 30");

        input.setHorizontalAlignment(JTextField.CENTER);
        computerOutput.setHorizontalAlignment(JTextField.CENTER);

        input.setFont(new Font("", Font.PLAIN, 50));
        computerOutput.setFont(new Font("", Font.PLAIN, 50));

        JButtonHandler bh = new JButtonHandler();
        nochmal.addActionListener(bh);
        input.addActionListener(bh);
    }

    public void setController(GewinnController controller) {
        this.controller = controller;
    }

    public void zeigeErgebnis(int computerZahl, int rundenErgebnis, int gesamtPunkte, boolean verloren, boolean gewonnen) {
        computerOutput.setText(computerZahl+"");
        nochmal.setEnabled(true);
        input.setEnabled(false);

        if (gewonnen) {
            runde.setText("Gewonnen :D");
        }
        else if (verloren) {
            runde.setText("Verloren D:");
        }
        else if (rundenErgebnis > 0){
            runde.setText("+"+rundenErgebnis);
        }
        else {
            runde.setText(rundenErgebnis+"");
        }

        punkte.setText(gesamtPunkte + "");
    }

    public void zeigeUngueltigeEingabe() {
        runde.setForeground(Color.RED);
        runde.setText("Bitte eine Zahl von 1 bis 9 eingeben!");
    }

    private class JButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();

            if (o == nochmal) {
                runde.setForeground(Color.BLACK);
                input.setEnabled(true);
                nochmal.setEnabled(false);
                runde.setText("Tippe eine Zahl von 1 bis 9");
                input.setText("");
                computerOutput.setText("");
            }

            if (o == input) {
                try {
                    int zahl =  Integer.parseInt(input.getText());
                    controller.spieleRunde(zahl);
                }
                catch (NumberFormatException ex) {
                    controller.spieleRunde(-1);
                }
            }
        }
    }
}
