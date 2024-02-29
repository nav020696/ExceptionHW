package core;

import Exceptions.NotCorrectDate;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void writeDates(String[] parameters) throws NotCorrectDate {
        model.writeToFile(parameters);
    }
}
