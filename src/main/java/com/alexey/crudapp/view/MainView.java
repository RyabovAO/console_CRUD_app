package com.alexey.crudapp.view;

import java.util.Scanner;

public class MainView {

    private final LabelView labelView = new LabelView();
    private final PostView postView = new PostView();
    private final WriterView writerView = new WriterView();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Выберите файлы:");
        System.out.println("1 - label");
        System.out.println("2 - post");
        System.out.println("3 - writer");
        int num = Integer.parseInt(scanner.nextLine());
        switch (num) {
            case 1:
                labelWork();
                break;
            case 2:
                postWork();
                break;
            case 3:
                writerWork();
                break;
            default:
                System.out.println("Не верное значение");
        }
    }

    private void labelWork() {
        System.out.println("Выберите действие");
        System.out.println("1 - создать");
        System.out.println("2 - обновить");
        System.out.println("3 - получить по id");
        System.out.println("4 - получить все записи");
        System.out.println("5 - удалить запись по id");
        int num = Integer.parseInt(scanner.nextLine());
        switch (num) {
            case 1:
                labelView.createLabel();
                break;
            case 2:
                labelView.updateLabel();
                break;
            case 3:
                labelView.getLabel();
                break;
            case 4:
                labelView.getAllLabel();
                break;
            case 5:
                labelView.deleteLabel();
                break;
            default:
                System.out.println("Не верное значение");
        }
    }

    private void postWork() {
        System.out.println("Выберите действие");
        System.out.println("1 - создать");
        System.out.println("2 - обновить");
        System.out.println("3 - получить по id");
        System.out.println("4 - получить все записи");
        System.out.println("5 - удалить запись по id");
        int num = Integer.parseInt(scanner.nextLine());
        switch (num) {
            case 1:
                postView.createPost();
                break;
            case 2:
                postView.updatePost();
                break;
            case 3:
                postView.getPost();
                break;
            case 4:
                postView.getAllPost();
                break;
            case 5:
                postView.deletePost();
                break;
            default:
                System.out.println("Не верное значение");
        }
    }

    private void writerWork() {
        System.out.println("Выберите действие");
        System.out.println("1 - создать");
        System.out.println("2 - обновить");
        System.out.println("3 - получить по id");
        System.out.println("4 - получить все записи");
        System.out.println("5 - удалить запись по id");
        int num = Integer.parseInt(scanner.nextLine());
        switch (num) {
            case 1:
                writerView.createWriter();
                break;
            case 2:
                writerView.updateWriter();
                break;
            case 3:
                writerView.getWriter();
                break;
            case 4:
                writerView.getAllWriters();
                break;
            case 5:
                writerView.deleteWriter();
                break;
            default:
                System.out.println("Не верное значение");
        }
    }
}
