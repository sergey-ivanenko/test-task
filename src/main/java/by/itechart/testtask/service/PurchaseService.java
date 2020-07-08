package by.itechart.testtask.service;

import by.itechart.testtask.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {
    PurchaseDto add(PurchaseDto purchaseDto);

    PurchaseDto findById(Long id);

    List<PurchaseDto> findAll();

    PurchaseDto update(PurchaseDto purchaseDto);

    PurchaseDto deleteById(Long id);
}
