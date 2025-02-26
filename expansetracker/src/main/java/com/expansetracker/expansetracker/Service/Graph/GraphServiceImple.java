package com.expansetracker.expansetracker.Service.Graph;
import java.time.LocalDate;
import java.util.*;
import org.springframework.stereotype.Service;
import com.expansetracker.expansetracker.DTO.GraphDTO;
import com.expansetracker.expansetracker.DTO.StasDTO;
import com.expansetracker.expansetracker.Entity.Expense;
import com.expansetracker.expansetracker.Entity.Income;
import com.expansetracker.expansetracker.Repository.ExpRepo;
import com.expansetracker.expansetracker.Repository.IncRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GraphServiceImple implements GraphService {
    private final IncRepo incRepo;
    private final ExpRepo expRepo;

    public GraphDTO getData(){
        LocalDate end = LocalDate.now();
        LocalDate st = end.minusDays(27);

        GraphDTO graphDto = new GraphDTO();
        graphDto.setExpenseList(expRepo.findByDateBetween(st,end));
        graphDto.setIncomeList(incRepo.findByDateBetween(st,end));

        return graphDto;        
    }

    public StasDTO getStats(){
        Double totalIncome = incRepo.sumAllamounts();
        Double totalExpense = expRepo.sumAllamounts();

        
        StasDTO statsDTO = new StasDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);
        
        Optional<Income> optionalIncome = incRepo.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expRepo.findFirstByOrderByDateDesc();

        if(optionalIncome.isPresent()) statsDTO.setLatestIncome(optionalIncome.get());
        if(optionalExpense.isPresent()) statsDTO.setLatestExpense(optionalExpense.get());

        statsDTO.setBalance(totalIncome - totalExpense);

        List<Income> incomeList = incRepo.findAll();
        List<Expense> expenseList = expRepo.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
        
        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
        statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);

        return statsDTO;
    }


}
