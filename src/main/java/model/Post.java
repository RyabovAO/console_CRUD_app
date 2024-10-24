package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Post {
    private int id;
    private String content;
    private String title;
    private List<Label> labels;
    private Status status;
}
