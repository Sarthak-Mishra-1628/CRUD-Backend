package com.expansetracker.expansetracker.Service.Income;
import java.util.List;
import com.expansetracker.expansetracker.DTO.IncDTO;
import com.expansetracker.expansetracker.Entity.Income;

public interface IncService {
    Income post(IncDTO dto);
    List<Income> getAll();
    Income get(int id);
    String update(int id, IncDTO dto);
    String delete(int id);
}
