package by.itechart.testtask.repository;

import by.itechart.testtask.model.BalanceChange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceChangeRepository extends CrudRepository<BalanceChange, Long> {
}
