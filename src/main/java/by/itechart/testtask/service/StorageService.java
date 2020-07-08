package by.itechart.testtask.service;

import by.itechart.testtask.dto.StorageDto;

import java.util.List;

public interface StorageService {
    StorageDto add(StorageDto storageDto);

    StorageDto findById(Long id);

    List<StorageDto> findAll();

    StorageDto update(StorageDto storageDto);

    StorageDto deleteById(Long id);
}
