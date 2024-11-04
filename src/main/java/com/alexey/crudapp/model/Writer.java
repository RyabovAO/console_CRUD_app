package com.alexey.crudapp.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Writer {
    private Integer id;
    private String fistName;
    private String LastName;
    private List<Post> post;
    private Status status;
}
