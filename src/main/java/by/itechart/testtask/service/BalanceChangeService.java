package by.itechart.testtask.service;

import by.itechart.testtask.dto.BalanceChangeDto;

import java.util.List;

public interface BalanceChangeService {
    BalanceChangeDto add(BalanceChangeDto balanceChangeDto);

    BalanceChangeDto findById(Long id);

    List<BalanceChangeDto> findAll();

    BalanceChangeDto update(BalanceChangeDto balanceChangeDto);

    BalanceChangeDto deleteById(Long id);
}
