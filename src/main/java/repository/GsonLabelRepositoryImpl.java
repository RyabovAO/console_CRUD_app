package repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import model.Label;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final File fileLabel = new File("src/main/java/files/labels.json");
    private List<Label> labelArr;

    public void create(Label label) {
        try(FileWriter fileWriter = new FileWriter(fileLabel, true)) {
//            fileWriter.append(gson.toJson(label));
            gson.toJson(label, fileWriter);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Label> getArrayFromJson() {
        labelArr = new ArrayList<>();
        try(FileReader fileReader = new FileReader(fileLabel)) {
            labelArr = gson.fromJson(fileReader, (Type) Label.class);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return labelArr;
    }
}
