package com.alexey.crudapp.view;

import com.alexey.crudapp.controller.PostController;
import com.alexey.crudapp.controller.WriterController;
import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Post;
import com.alexey.crudapp.model.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterView {

    private final WriterController writerController;
    private final Scanner scanner = new Scanner(System.in);

    public WriterView() {
        this.writerController = new WriterController();
    }

    public void createWriter() {
        System.out.println("Enter fist name");
        String fistName = scanner.nextLine();

        System.out.println("Enter last name");
        String lastName = scanner.nextLine();

        System.out.println("Enter posts");
        List<Post> posts = new ArrayList<>();

        Writer createdWriter = writerController.createWriter(fistName, lastName, posts);

        System.out.println("Created post: " + createdWriter);
    }

    public void updateWriter() {
        System.out.println("Enter writer id");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new fist name");
        String fistName = scanner.nextLine();

        System.out.println("Enter new last name ");
        String lastName = scanner.nextLine();

        System.out.println("Enter new posts");
        List<Post> posts = new ArrayList<>();

        Writer updateWriter = writerController.updateWriter(id, fistName, lastName, posts);

        System.out.println("post with id update to: " + updateWriter);
    }

    public void getWriter() {
        System.out.println("Enter writer id");
        int id = scanner.nextInt();
        Writer receivedWriter = writerController.getWriterById(id);
        System.out.println("writer with ID: " + receivedWriter.toString());
    }

    public void getAllWriters() {
        writerController.getAllWriters().forEach(l -> System.out.println(l.toString()));
    }

    public void deleteWriter() {
        System.out.println("Enter writer id");
        int id = scanner.nextInt();
        writerController.deleteWriterById(id);
        System.out.println("writer with id: " + id + " delete");
    }
}
