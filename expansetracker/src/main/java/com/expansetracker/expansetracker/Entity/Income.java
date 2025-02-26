package com.expansetracker.expansetracker.Entity;
import java.time.LocalDate;

import com.expansetracker.expansetracker.DTO.IncDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title , descr , cat ;

    private LocalDate date;

    private Integer amount;

    public IncDTO geIncDTO(){
        IncDTO incdto = new IncDTO();

        incdto.setId(id);
        incdto.setTitle(title);
        incdto.setDate(date);
        incdto.setDescr(descr);
        incdto.setAmount(amount);
        incdto.setCat(cat);

        return incdto;
    }
}
