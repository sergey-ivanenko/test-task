package by.itechart.testtask.repository;

import by.itechart.testtask.model.TimesheetStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetStatusRepository extends CrudRepository<TimesheetStatus, Long> {
}
