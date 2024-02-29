import core.Controller;
import core.Model;
import core.UserView;

public class Main {
    public static void main(String[] args) {
        new UserView(new Controller(new Model())).run();
    }
}