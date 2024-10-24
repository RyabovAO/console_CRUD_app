package controller;

import model.Label;
import repository.GsonLabelRepositoryImpl;

public class LabelController {
    private GsonLabelRepositoryImpl gsonLabelRepository;

    public void newLabelEntity(String name) {
        Label label = new Label(name);
        gsonLabelRepository = new GsonLabelRepositoryImpl();
        gsonLabelRepository.create(label);
    }
}
