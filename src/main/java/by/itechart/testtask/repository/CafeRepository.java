package by.itechart.testtask.repository;

import by.itechart.testtask.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends CrudRepository<Cafe, Long> {
}
