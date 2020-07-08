package by.itechart.testtask.service;

import by.itechart.testtask.dto.PurchaseDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.PurchaseMapper;
import by.itechart.testtask.model.Purchase;
import by.itechart.testtask.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    private static Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public PurchaseDto add(PurchaseDto purchaseDto) {
        logger.info(String.format("%s added.", purchaseDto));
        return purchaseMapper.toDto(purchaseRepository.save(purchaseMapper.toEntity(purchaseDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PurchaseDto findById(Long id) {
        return purchaseMapper.toDto(purchaseRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<PurchaseDto> findAll() {
        List<Purchase> purchases = (List<Purchase>) purchaseRepository.findAll();
        return purchases.stream().map(purchaseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseDto update(PurchaseDto purchaseDto) {
        logger.info(String.format("Purchase %d updated.", purchaseDto.getId()));
        return purchaseMapper.toDto(purchaseRepository.save(purchaseMapper.toEntity(purchaseDto)));
    }

    @Override
    public PurchaseDto deleteById(Long id) {
        PurchaseDto deletedPurchase = purchaseMapper.toDto(purchaseRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        purchaseRepository.deleteById(id);
        logger.info(String.format("Purchase %d deleted.", deletedPurchase.getId()));

        return deletedPurchase;
    }
}
