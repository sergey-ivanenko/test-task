package by.itechart.testtask.service;

import by.itechart.testtask.dto.PurchaseStatusDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.PurchaseStatusMapper;
import by.itechart.testtask.model.PurchaseStatus;
import by.itechart.testtask.repository.PurchaseStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseStatusServiceImpl implements PurchaseStatusService {
    private static Logger logger = LoggerFactory.getLogger(PurchaseStatusServiceImpl.class);

    private final PurchaseStatusRepository purchaseStatusRepository;
    private final PurchaseStatusMapper purchaseStatusMapper;

    public PurchaseStatusServiceImpl(PurchaseStatusRepository purchaseStatusRepository, PurchaseStatusMapper purchaseStatusMapper) {
        this.purchaseStatusRepository = purchaseStatusRepository;
        this.purchaseStatusMapper = purchaseStatusMapper;
    }

    @Override
    public PurchaseStatusDto add(PurchaseStatusDto purchaseStatusDto) {
        logger.info(String.format("%s added.", purchaseStatusDto));
        return purchaseStatusMapper.toDto(purchaseStatusRepository.save(purchaseStatusMapper.toEntity(purchaseStatusDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PurchaseStatusDto findById(Long id) {
        return purchaseStatusMapper.toDto(purchaseStatusRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<PurchaseStatusDto> findAll() {
        List<PurchaseStatus> purchasStatuses = (List<PurchaseStatus>) purchaseStatusRepository.findAll();
        return purchasStatuses.stream().map(purchaseStatusMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseStatusDto update(PurchaseStatusDto purchaseStatusDto) {
        logger.info(String.format("Purchase status %d updated.", purchaseStatusDto.getId()));
        return purchaseStatusMapper.toDto(purchaseStatusRepository.save(purchaseStatusMapper.toEntity(purchaseStatusDto)));
    }

    @Override
    public PurchaseStatusDto deleteById(Long id) {
        PurchaseStatusDto deletedPurchaseStatus = purchaseStatusMapper.toDto(purchaseStatusRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        purchaseStatusRepository.deleteById(id);
        logger.info(String.format("Purchase status %d deleted.", deletedPurchaseStatus.getId()));

        return deletedPurchaseStatus;
    }
}
