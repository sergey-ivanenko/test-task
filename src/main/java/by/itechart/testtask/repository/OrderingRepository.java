package by.itechart.testtask.repository;

import by.itechart.testtask.model.Ordering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends CrudRepository<Ordering, Long> {
}
