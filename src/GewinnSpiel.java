public class GewinnSpiel {

    public static void main(String[] args) {

        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();

        GewinnController controller =
                new GewinnController(model, view);

        view.setController(controller);

        new GewinnFrame(view);
    }
}