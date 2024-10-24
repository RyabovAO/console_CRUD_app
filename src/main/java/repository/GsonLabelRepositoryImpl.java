package repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import model.Label;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final File fileLabel = new File("src/main/java/files/labels.json");
    private List<Label> labelList;

    public void create(Label label) {

        try(FileWriter fileWriter = new FileWriter(fileLabel)) {
//            fileWriter.append(gson.toJson(label));
            List<Label> newList = new ArrayList<>(getArrayFromJson());
            newList.add(label);
            gson.toJson(newList, fileWriter);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Label> getArrayFromJson() {
        Type userListType = new TypeToken<ArrayList<Label>>(){}.getType();
        labelList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(fileLabel)) {
            labelList = gson.fromJson(fileReader, userListType);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return labelList;
    }
}
