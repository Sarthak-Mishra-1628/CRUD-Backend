package com.expansetracker.expansetracker.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.expansetracker.expansetracker.DTO.ExpDTO;
import com.expansetracker.expansetracker.Entity.Expense;
import com.expansetracker.expansetracker.Service.Expense.ExpService;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/expense")
@CrossOrigin("http://localhost:5173/")
@RequiredArgsConstructor
public class ExpController {
    private final ExpService expService;

    @PostMapping("/")
    public String postExp(@RequestBody ExpDTO dto){
        Expense created = expService.post(dto);

        if(created!=null) return "All good";
        return "No";
    }

    @GetMapping("/all")
    public List<Expense> getAll(){
        return expService.getAll();
    }

    @GetMapping("/{id}")
    public Expense get(@PathVariable int id){
        return expService.get(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id , @RequestBody ExpDTO dto){
        return expService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return expService.delete(id);
    }
    
}
 