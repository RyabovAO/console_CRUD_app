package java.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Writer {
    private int id;
    private String fistName;
    private String LastName;
    private List<Post> post;
    private Status status;
}
