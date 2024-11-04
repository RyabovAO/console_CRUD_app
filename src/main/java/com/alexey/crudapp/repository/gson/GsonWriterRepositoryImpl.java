package com.alexey.crudapp.repository.gson;

import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.model.Writer;
import com.alexey.crudapp.repository.WriterRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final File fileWriters = new File("src/main/java/com/alexey/crudapp/files/writers.json");

    private List<Writer> getArrayWritersFromJson() {
        Type userListType = new TypeToken<ArrayList<Writer>>() {
        }.getType();
        try (FileReader fileReader = new FileReader(fileWriters)) {
            return GSON.fromJson(fileReader, userListType);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private Integer generateId(List<Writer> list) {
        return list.stream().mapToInt(Writer::getId).max().orElse(0) + 1;
    }

    private void writeWritersToFile(List<Writer> posts) {
        String toJson = GSON.toJson(posts);
        try (FileWriter fileWriter = new FileWriter(fileWriters)) {
            fileWriter.write(toJson);
        } catch (IOException e) {
            System.out.println("Файл writers.json не найден " + e.getMessage());
        }
    }

    @Override
    public Writer getById(Integer id) {
        return getArrayWritersFromJson().stream()
                .filter(w -> w.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return getArrayWritersFromJson();
    }

    @Override
    public Writer create(Writer writer) {
        List<Writer> currentWriter = getArrayWritersFromJson();
        Integer newId = generateId(currentWriter);
        writer.setId(newId);
        currentWriter.add(writer);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> currentWriter = getArrayWritersFromJson();
        currentWriter.stream()
                .map(w -> {
                            if (w.getId().equals(writer.getId())) {
                                return writer;
                            }
                            return w;
                        }
                ).toList();
        writeWritersToFile(currentWriter);
        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        List<Writer> currentWriter = getArrayWritersFromJson();
        currentWriter.stream().map(w -> {
            if (w.getId().equals(id)) {
                w.setStatus(Status.DELETED);
            }
            return w;
        }).toList();
        writeWritersToFile(currentWriter);
    }
}
