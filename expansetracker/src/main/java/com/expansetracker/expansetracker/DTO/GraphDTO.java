package com.expansetracker.expansetracker.DTO;
import java.util.List;
import com.expansetracker.expansetracker.Entity.Expense;
import com.expansetracker.expansetracker.Entity.Income;
import lombok.Data;

@Data
public class GraphDTO {
    private List<Expense> expenseList;
    private List<Income> incomeList;
}
