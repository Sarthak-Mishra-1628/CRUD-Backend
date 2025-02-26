package com.expansetracker.expansetracker.DTO;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ExpDTO {
    private Integer id;

    private String title , descr , cat ;

    private LocalDate date;

    private Integer amount;
}
