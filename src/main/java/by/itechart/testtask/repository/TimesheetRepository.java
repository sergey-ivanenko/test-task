package by.itechart.testtask.repository;

import by.itechart.testtask.model.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
}
