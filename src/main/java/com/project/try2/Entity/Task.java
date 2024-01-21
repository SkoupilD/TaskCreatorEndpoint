package com.project.try2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String text;
    private LocalDate date;
    private LocalDateTime time;
    private Integer level;

}
