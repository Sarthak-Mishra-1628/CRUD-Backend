package com.expansetracker.expansetracker.DTO;
import java.time.LocalDate;
import lombok.Data;

@Data
public class IncDTO {
    private Integer id;

    private String title , descr , cat ;

    private LocalDate date;

    private Integer amount;
}
