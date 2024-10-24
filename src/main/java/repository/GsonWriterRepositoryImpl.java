package repository;

import com.google.gson.Gson;

import controller.WriterController;
import java.io.File;
import java.io.Writer;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final File fileWriter = new File("files/writers.json");
    private WriterController writerController;
    private Gson gson = new Gson();
    private Writer writer;

}
