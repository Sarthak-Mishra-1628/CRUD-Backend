package com.expansetracker.expansetracker.Service.Income;
import org.springframework.stereotype.Service;
import com.expansetracker.expansetracker.DTO.IncDTO;
import com.expansetracker.expansetracker.Entity.Income;
import com.expansetracker.expansetracker.Repository.IncRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncServiceImple implements IncService {
    private final IncRepo incRepo;

    public Income post(IncDTO incdto){
        return save(new Income() , incdto);
    }

    private Income save(Income income , IncDTO dto){
        income.setTitle(dto.getTitle());
        income.setDate(dto.getDate());
        income.setAmount(dto.getAmount());
        income.setCat(dto.getCat());
        income.setDescr(dto.getDescr());

        return incRepo.save(income);
    }

    public List<Income> getAll(){
        List<Income> inc = incRepo.findAll();
        
        if(inc==null || inc.isEmpty()) throw new RuntimeException("No data found");

        return inc.stream()
               .sorted(Comparator.comparing(Income::getDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
               .collect(Collectors.toList());
    }

    public Income get(int id){
        Optional<Income> inc = incRepo.findById(id);
        if(inc.isPresent()) return inc.get();
        else throw new EntityNotFoundException("No data found");
    }

    public String update(int id, IncDTO dto){
        Optional<Income> expentity = incRepo.findById(id);
        if(expentity.isPresent()){
            Income exp = expentity.get();
            exp.setAmount(dto.getAmount());
            exp.setCat(dto.getCat());
            exp.setDate(dto.getDate());
            exp.setTitle(dto.getTitle());
            exp.setDescr(dto.getDescr());

            incRepo.save(exp);
            return "Done";
        }

        return "No data found";
    }

    public String delete(int id){
        Optional<Income> expentity = incRepo.findById(id);
        if(expentity.isPresent()){
            incRepo.deleteById(id);
            return "Done";
        }
        return "No data found";
    }
}
