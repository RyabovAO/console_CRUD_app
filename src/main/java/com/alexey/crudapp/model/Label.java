package com.alexey.crudapp.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    private Integer id;
    private String name;
    private Status status;
}
