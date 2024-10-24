package controller;

import model.Label;
import repository.GsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {
    private GsonLabelRepositoryImpl gsonLabelRepository;

    public void newLabelEntity(String name) {
        gsonLabelRepository = new GsonLabelRepositoryImpl();
        List<Label> list = gsonLabelRepository.getArrayFromJson();
        Label label = new Label(name, list.size());
        gsonLabelRepository.create(label);
    }
}
