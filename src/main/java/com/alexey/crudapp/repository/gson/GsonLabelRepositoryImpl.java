package com.alexey.crudapp.repository.gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.repository.LabelRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.alexey.crudapp.model.Label;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();;
    private final File fileLabel = new File("src/main/java/com/alexey/crudapp/files/labels.json");

    private List<Label> getArrayFromJson() {
        Type userListType = new TypeToken<ArrayList<Label>>() {
        }.getType();
        try (FileReader fileReader = new FileReader(fileLabel)) {
            return GSON.fromJson(fileReader, userListType);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void writeLabelsToFile(List<Label> labels) {
        String jsonString = GSON.toJson(labels);
        try(FileWriter fileWriter = new FileWriter(fileLabel)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            System.out.println("Файл labels.json не найден " + e.getMessage());
        }
    }

    private Integer generateNewId(List<Label> labels) {
        return labels.stream()
                .mapToInt(Label::getId).max().orElse(0) + 1;
    }

    @Override
    public Label getById(Integer id) {
        return getArrayFromJson().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Label> getAll() {
        return getArrayFromJson();
    }

    @Override
    public Label create(Label label) {
        List<Label> currentLabels = getArrayFromJson();
        Integer newId = generateNewId(currentLabels);
        label.setId(newId);
        currentLabels.add(label);
        writeLabelsToFile(currentLabels);
        return label;
    }

    @Override
    public Label update(Label label) {
        List<Label> currentLabels = getArrayFromJson().stream()
                .map(l -> {
                    if(l.getId().equals(label.getId())) {
                        return label;
                    }
                    return l;
                }).toList();
        writeLabelsToFile(currentLabels);
        return label;
    }

    @Override
    public void deleteById(Integer id) {
        List<Label> currentLabels = getArrayFromJson().stream()
                .map(l -> {
                    if(l.getId().equals(id)) {
                        l.setStatus(Status.DELETED);
                    }
                    return l;
                }).toList();

        writeLabelsToFile(currentLabels);
    }
}
