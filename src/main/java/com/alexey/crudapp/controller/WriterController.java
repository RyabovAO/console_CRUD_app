package com.alexey.crudapp.controller;

import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Post;
import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.model.Writer;
import com.alexey.crudapp.repository.WriterRepository;
import com.alexey.crudapp.repository.gson.GsonWriterRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController() {
        this.writerRepository = new GsonWriterRepositoryImpl();
    }

    public Writer createWriter (String fistName, String lastName, List<Post> posts) {
        Writer writer = new Writer();
        writer.setFistName(fistName);
        writer.setLastName(lastName);
        writer.setPost(posts);
        writer.setStatus(Status.ACTIVE);
        return writerRepository.create(writer);
    }

    public Writer updateWriter(int id, String fistName, String lastName, List<Post> posts) {
        Writer writer = getWriterById(id);
        writer.setFistName(fistName);
        writer.setLastName(lastName);
        writer.setPost(posts);
        return writerRepository.update(writer);
    }

    public Writer getWriterById(int id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public void deleteWriterById(int id) {
        writerRepository.deleteById(id);
    }
}
