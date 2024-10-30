package com.alexey.crudapp.view;

import com.alexey.crudapp.controller.LabelController;
import com.alexey.crudapp.model.Label;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class LabelView {
    private final LabelController labelController;
    private final Scanner scanner = new Scanner(System.in);
    public LabelView() {
        this.labelController = new LabelController();
    }

    public void createLabel() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        Label createdLabel = labelController.createLabel(name);

        System.out.println("Created label: " + createdLabel);
    }


}
