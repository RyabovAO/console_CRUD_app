package view;

import controller.LabelController;
import java.util.Scanner;

public class UserInput {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        LabelController labelController = new LabelController();
        labelController.newLabelEntity(scanner.nextLine());
    }
}
