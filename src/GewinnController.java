import java.awt.*;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
    }

    public void spieleRunde(int zahl) {
        if (zahl >= 1 && zahl <= 9) {
            model.berechneComputerZahl();
            model.berechneRunde(zahl);

            view.zeigeErgebnis(model.getComputerZahl(), model.getRundenErgebnis(), model.getGesamtPunkte(), model.hatVerloren(), model.hatGewonnen());
        }
        else {
            view.zeigeUngueltigeEingabe();
        }
    }
}
