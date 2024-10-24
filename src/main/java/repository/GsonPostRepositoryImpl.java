package repository;

import com.google.gson.Gson;

import controller.PostController;
import java.io.File;
import model.Post;

public class GsonPostRepositoryImpl implements PostRepository {
    private final File filePost = new File("files/posts.json");
    private PostController postController;
    private Gson gson = new Gson();
    private Post post;


}
