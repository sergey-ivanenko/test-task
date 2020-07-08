package by.itechart.testtask.repository;

import by.itechart.testtask.model.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Long> {
}
