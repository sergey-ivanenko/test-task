package by.itechart.testtask.repository;

import by.itechart.testtask.model.ProductPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends CrudRepository<ProductPrice, Long> {
}
