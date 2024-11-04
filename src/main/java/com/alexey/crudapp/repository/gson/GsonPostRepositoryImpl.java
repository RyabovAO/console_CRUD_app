package com.alexey.crudapp.repository.gson;

import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Post;
import com.alexey.crudapp.model.Status;
import com.alexey.crudapp.repository.PostRepository;
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

public class GsonPostRepositoryImpl implements PostRepository {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final File filePost = new File("src/main/java/com/alexey/crudapp/files/posts.json");

    private List<Post> getArrayPostFromJson() {
        Type userListType = new TypeToken<ArrayList<Post>>() {
        }.getType();
        try (FileReader fileReader = new FileReader(filePost)) {
            return GSON.fromJson(fileReader, userListType);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private Integer generateId(List<Post> list) {
        return list.stream().mapToInt(Post::getId).max().orElse(0) + 1;
    }

    private void writePostToFile(List<Post> posts) {
        String toJson = GSON.toJson(posts);
        try (FileWriter fileWriter = new FileWriter(filePost)) {
            fileWriter.write(toJson);
        } catch (IOException e) {
            System.out.println("Файл posts.json не найден " + e.getMessage());
        }
    }

    @Override
    public Post getById(Integer id) {
        return getArrayPostFromJson().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return getArrayPostFromJson();
    }

    @Override
    public Post create(Post post) {
        List<Post> currentPosts = getArrayPostFromJson();
        Integer newId = generateId(currentPosts);
        post.setId(newId);
        currentPosts.add(post);
        return post;
    }

    @Override
    public Post update(Post post) {
        List<Post> currentPosts = getArrayPostFromJson();
        currentPosts.stream()
                .map(p -> {
                    if (p.getId().equals(post.getId())) {
                        return post;
                    }
                    return p;
                }
        ).toList();
        writePostToFile(currentPosts);
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> currentPosts = getArrayPostFromJson();
        currentPosts.stream().map(p -> {
            if(p.getId().equals(id)) {
                p.setStatus(Status.DELETED);
            } return p;
        }).toList();
        writePostToFile(currentPosts);
    }
}
