package com.expansetracker.expansetracker.Service.Expense;
import org.springframework.stereotype.Service;

import com.expansetracker.expansetracker.DTO.ExpDTO;
import com.expansetracker.expansetracker.Entity.Expense;
import com.expansetracker.expansetracker.Repository.ExpRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpServiceImple implements ExpService {
    private final ExpRepo expRepo;

    public Expense post(ExpDTO expDTO){
        return save(new Expense() , expDTO);
    }

    private Expense save(Expense exp , ExpDTO expdto){
        exp.setAmount(expdto.getAmount());
        exp.setDescr(expdto.getDescr());
        exp.setCat(expdto.getCat());
        exp.setId(expdto.getId());
        exp.setDate(expdto.getDate());
        exp.setTitle(expdto.getTitle());

        return expRepo.save(exp);
    }

    public List<Expense> getAll(){
        List<Expense> entities = expRepo.findAll();
        if(entities==null || entities.isEmpty()) throw new RuntimeException("No data found");

        return entities.stream()
            .sorted(Comparator.comparing(Expense::getDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
            .collect(Collectors.toList());
    }

    public Expense get(Integer id){
        Optional<Expense> expentity = expRepo.findById(id);
        if(expentity.isPresent()) return expentity.get();
        else throw new EntityNotFoundException("No data found");
    }

    public String update(Integer id , ExpDTO dto){
        Optional<Expense> expentity = expRepo.findById(id);
        if(expentity.isPresent()){
            Expense exp = expentity.get();
            exp.setAmount(dto.getAmount());
            exp.setCat(dto.getCat());
            exp.setDate(dto.getDate());
            exp.setTitle(dto.getTitle());
            exp.setDescr(dto.getDescr());

            expRepo.save(exp);
            return "Done";
        }

        return "No data found";
    }

    public String delete(int id){
        Optional<Expense> expentity = expRepo.findById(id);
        if(expentity.isPresent()){
            expRepo.deleteById(id);
            return "Done";
        }
        return "No data found";
    }
}
