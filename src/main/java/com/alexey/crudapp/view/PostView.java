package com.alexey.crudapp.view;

import com.alexey.crudapp.controller.LabelController;
import com.alexey.crudapp.controller.PostController;
import com.alexey.crudapp.model.Label;
import com.alexey.crudapp.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController;
    private final Scanner scanner = new Scanner(System.in);

    public PostView() {
        this.postController = new PostController();
    }

    public void createPost() {
        System.out.println("Enter title");
        String title = scanner.nextLine();

        System.out.println("Enter content");
        String content = scanner.nextLine();

        System.out.println("Enter labels");
        List<Label> labels = new ArrayList<>();

        Post createdPost = postController.createPost(title, content, labels);

        System.out.println("Created post: " + createdPost);
    }

    public void updatePost() {
        System.out.println("Enter post id");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new title");
        String newName = scanner.nextLine();

        System.out.println("Enter new content");
        String content = scanner.nextLine();

        System.out.println("Enter new labels");
        List<Label> labels = new ArrayList<>();

        Post updatePost = postController.updatePost(id, newName, content, labels);

        System.out.println("post with id update to: " + updatePost);
    }

    public void getPost() {
        System.out.println("Enter post id");
        int id = scanner.nextInt();
        Post receivedPost = postController.getPostById(id);
        System.out.println("post with ID: " + receivedPost.toString());
    }

    public void getAllPost() {
        postController.getAllPost().forEach(l -> System.out.println(l.toString()));
    }

    public void deletePost() {
        System.out.println("Enter post id");
        int id = scanner.nextInt();
        postController.deletePostById(id);
        System.out.println("post with id: " + id + " delete");
    }
}
