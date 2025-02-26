package com.expansetracker.expansetracker.Repository;
import java.time.LocalDate;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.expansetracker.expansetracker.Entity.Income;

@Repository
public interface IncRepo extends JpaRepository<Income, Integer> {
    List<Income> findByDateBetween(LocalDate st , LocalDate end);

    @Query("Select sum(i.amount) from Income i")
    Double sumAllamounts();

    Optional<Income> findFirstByOrderByDateDesc();
}
