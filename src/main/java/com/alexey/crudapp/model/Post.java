package com.alexey.crudapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Post {
    private Long id;
    private String content;
    private String title;
    private List<Label> labels;
    private Status status;
}
