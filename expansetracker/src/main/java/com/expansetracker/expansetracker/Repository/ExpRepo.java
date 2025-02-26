package com.expansetracker.expansetracker.Repository;
import java.time.LocalDate;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.expansetracker.expansetracker.Entity.Expense;

@Repository
public interface ExpRepo extends JpaRepository<Expense, Integer> {
    List<Expense> findByDateBetween(LocalDate st , LocalDate end);

    @Query("Select sum(e.amount) from Expense e")
    Double sumAllamounts();

    Optional<Expense> findFirstByOrderByDateDesc();
}
