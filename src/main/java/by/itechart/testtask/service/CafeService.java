package by.itechart.testtask.service;

import by.itechart.testtask.dto.CafeDto;

import java.util.List;

public interface CafeService {
    CafeDto add(CafeDto cafeDto);

    CafeDto findById(Long id);

    List<CafeDto> findAll();

    CafeDto update(CafeDto cafeDto);

    CafeDto deleteById(Long id);
}
