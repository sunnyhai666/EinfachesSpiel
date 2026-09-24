import javax.swing.*;

public class GewinnFrame extends JFrame{
    public GewinnFrame() {
        setTitle("Zahlen-Gewinnspiel (v1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);

        setContentPane(new GewinnView());

        setVisible(true);
    }
}
