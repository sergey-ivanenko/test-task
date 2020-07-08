package by.itechart.testtask.service;

import by.itechart.testtask.dto.SalaryDto;

import java.util.List;

public interface SalaryService {
    SalaryDto add(SalaryDto salaryDto);

    SalaryDto findById(Long id);

    List<SalaryDto> findAll();

    SalaryDto update(SalaryDto salaryDto);

    SalaryDto deleteById(Long id);
}
