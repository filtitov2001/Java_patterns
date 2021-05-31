package com.lab14.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class University {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public University(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
}
