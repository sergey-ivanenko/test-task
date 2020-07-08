package by.itechart.testtask.service;

import by.itechart.testtask.dto.PurchaseStatusDto;

import java.util.List;

public interface PurchaseStatusService {
    PurchaseStatusDto add(PurchaseStatusDto purchaseStatusDto);

    PurchaseStatusDto findById(Long id);

    List<PurchaseStatusDto> findAll();

    PurchaseStatusDto update(PurchaseStatusDto purchaseStatusDto);

    PurchaseStatusDto deleteById(Long id);
}
