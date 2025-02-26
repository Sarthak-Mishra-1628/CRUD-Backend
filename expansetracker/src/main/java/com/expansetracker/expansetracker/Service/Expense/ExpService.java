package com.expansetracker.expansetracker.Service.Expense;
import java.util.List;

import com.expansetracker.expansetracker.DTO.ExpDTO;
import com.expansetracker.expansetracker.Entity.Expense;

public interface ExpService {
    Expense post(ExpDTO expDTO);
    List<Expense> getAll();
    Expense get(Integer id);
    String update(Integer id , ExpDTO dto);
    String delete(int id);
}
