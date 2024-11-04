package com.alexey.crudapp.controller;

import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.repository.LabelRepository;
import com.alexey.crudapp.repository.gson.GsonLabelRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController() {
        this.labelRepository = new GsonLabelRepositoryImpl();
    }

    public Label createLabel(String name) {
        if(name == null) {
            return null;
        }
        Label label = new Label();
        label.setName(name);
        label.setStatus(Status.ACTIVE);
        return labelRepository.create(label);
    }

    public Label updateLabel(int id, String newName) {
        if(newName == null) {
            return null;
        }
        Label label = getLabelById(id);
        label.setName(newName);
        return labelRepository.update(label);
    }

    public Label getLabelById(int id) {
        return labelRepository.getById(id);
    }

    public List<Label> getAllLabel() {
        return labelRepository.getAll();
    }

    public void deleteLabelById(int id) {
        labelRepository.deleteById(id);
    }
}