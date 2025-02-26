package com.expansetracker.expansetracker.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.expansetracker.expansetracker.DTO.IncDTO;
import com.expansetracker.expansetracker.Entity.Income;
import com.expansetracker.expansetracker.Service.Income.IncService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/income")
@CrossOrigin("http://localhost:5173/")
@RequiredArgsConstructor
public class IncController {
    private final IncService incService;

    @PostMapping("/")
    public String postExp(@RequestBody IncDTO dto){
        Income created = incService.post(dto);

        if(created!=null) return "All good";
        return "No";
    }

    @GetMapping("/all")
    public List<Income> getAll(){
        return incService.getAll();
    }

    @GetMapping("/{id}")
    public Income get(@PathVariable Integer id){
        Income i = incService.get(id);
        if(i!=null) return i;

        else throw new EntityNotFoundException("No data found");

    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id , @RequestBody IncDTO dto){
        return incService.update(id, dto);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return incService.delete(id);
    }
}
 