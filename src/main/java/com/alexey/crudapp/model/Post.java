package com.alexey.crudapp.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private String content;
    private String title;
    private List<Label> labels;
    private Status status;
}
