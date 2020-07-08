package by.itechart.testtask.service;

import by.itechart.testtask.dto.OrderingDto;

import java.util.List;

public interface OrderingService {
    OrderingDto add(OrderingDto orderingDto);

    OrderingDto findById(Long id);

    List<OrderingDto> findAll();

    OrderingDto update(OrderingDto orderingDto);

    OrderingDto deleteById(Long id);
}
