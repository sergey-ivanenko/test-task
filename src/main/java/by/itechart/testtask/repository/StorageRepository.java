package by.itechart.testtask.repository;

import by.itechart.testtask.model.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {
}
