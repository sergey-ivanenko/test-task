package by.itechart.testtask.service;

import by.itechart.testtask.dto.BalanceDto;

import java.util.List;

public interface BalanceService {
    BalanceDto add(BalanceDto balanceDto);

    BalanceDto findById(Long id);

    List<BalanceDto> findAll();

    BalanceDto update(BalanceDto balanceDto);

    BalanceDto deleteById(Long id);
}
