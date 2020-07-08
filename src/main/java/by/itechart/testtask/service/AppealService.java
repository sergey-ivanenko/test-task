package by.itechart.testtask.service;

import by.itechart.testtask.dto.AppealDto;

import java.util.List;

public interface AppealService {
    AppealDto add(AppealDto appealDto);

    AppealDto findById(Long id);

    List<AppealDto> findAll();

    AppealDto update(AppealDto appealDto);

    AppealDto deleteById(Long id);
}
