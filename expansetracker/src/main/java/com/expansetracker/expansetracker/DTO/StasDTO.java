package com.expansetracker.expansetracker.DTO;

import com.expansetracker.expansetracker.Entity.Income;
import com.expansetracker.expansetracker.Entity.Expense;
import lombok.Data;

@Data
public class StasDTO {
    private Double income , expense ;

    private Income latestIncome;
    private Expense latestExpense;
    private double balance , minIncome , maxIncome , minExpense , maxExpense;

}
