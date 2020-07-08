package by.itechart.testtask.service;

import by.itechart.testtask.dto.StorageDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.StorageMapper;
import by.itechart.testtask.model.Storage;
import by.itechart.testtask.repository.StorageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {
    private static Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    private final StorageRepository storageRepository;
    private final StorageMapper storageMapper;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository, StorageMapper storageMapper) {
        this.storageRepository = storageRepository;
        this.storageMapper = storageMapper;
    }

    @Override
    public StorageDto add(StorageDto storageDto) {
        logger.info(String.format("%s added.", storageDto));
        return storageMapper.toDto(storageRepository.save(storageMapper.toEntity(storageDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public StorageDto findById(Long id) {
        return storageMapper.toDto(storageRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<StorageDto> findAll() {
        List<Storage> storages = (List<Storage>) storageRepository.findAll();
        return storages.stream().map(storageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StorageDto update(StorageDto storageDto) {
        logger.info(String.format("Storage %d updated.", storageDto.getId()));
        return storageMapper.toDto(storageRepository.save(storageMapper.toEntity(storageDto)));
    }

    @Override
    public StorageDto deleteById(Long id) {
        StorageDto deletedStorage = storageMapper.toDto(storageRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        storageRepository.deleteById(id);
        logger.info(String.format("Storage %d deleted.", deletedStorage.getId()));

        return deletedStorage;
    }
}
