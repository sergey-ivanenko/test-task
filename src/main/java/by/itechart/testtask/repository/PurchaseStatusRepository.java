package by.itechart.testtask.repository;

import by.itechart.testtask.model.PurchaseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseStatusRepository extends CrudRepository<PurchaseStatus, Long> {
}
