import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        Random random = new Random();
        this.computerZahl = random.nextInt(9)+1; // Zahl zwischen 1 und 9
    }

    public void berechneRunde(int spielerzahl) {
        this.spielerZahl = spielerzahl;
        if (spielerzahl == computerZahl) {
            this.rundenErgebnis = +20;
            this.gesamtPunkte += 20;
        }

        else if (spielerzahl-1 == computerZahl || spielerzahl+1 == computerZahl) {
            this.rundenErgebnis = +5;
            this.gesamtPunkte += 5;
        }

        else {
            this.rundenErgebnis = -10;
            this.gesamtPunkte -= 10;
        }
    }

    public boolean hatGewonnen() {
        if (this.gesamtPunkte >= 100) {
            return true;
        }
        return false;
    }

    public boolean hatVerloren() {
        if (this.gesamtPunkte <= 0) {
            return true;
        }
        return false;
    }
}
