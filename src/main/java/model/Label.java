package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label {
    private int id = 0;
    private String name;
    private Status status;

    public Label(String name) {
        this.name = name;
        this.id += id;
        this.status = Status.ACTIVE;
    }
}
