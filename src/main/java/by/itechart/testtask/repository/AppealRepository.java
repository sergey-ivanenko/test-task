package by.itechart.testtask.repository;

import by.itechart.testtask.model.Appeal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends CrudRepository<Appeal, Long> {
}
