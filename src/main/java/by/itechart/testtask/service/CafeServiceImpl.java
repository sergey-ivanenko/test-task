package by.itechart.testtask.service;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.CafeMapper;
import by.itechart.testtask.model.Cafe;
import by.itechart.testtask.repository.CafeRepository;
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
public class CafeServiceImpl implements CafeService {
    private static Logger logger = LoggerFactory.getLogger(CafeServiceImpl.class);

    private final CafeRepository cafeRepository;
    private final CafeMapper cafeMapper;

    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository, CafeMapper cafeMapper) {
        this.cafeRepository = cafeRepository;
        this.cafeMapper = cafeMapper;
    }

    @Override
    public CafeDto add(CafeDto cafeDto) {
        logger.info(String.format("%s added.", cafeDto));
        return cafeMapper.toDto(cafeRepository.save(cafeMapper.toEntity(cafeDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public CafeDto findById(Long id) {
        return cafeMapper.toDto(cafeRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<CafeDto> findAll() {
        List<Cafe> cafes = (List<Cafe>) cafeRepository.findAll();
        return cafes.stream().map(cafeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CafeDto update(CafeDto cafeDto) {
        logger.info(String.format("Cafe %s updated.", cafeDto.getId()));
        return cafeMapper.toDto(cafeRepository.save(cafeMapper.toEntity(cafeDto)));
    }

    @Override
    public CafeDto deleteById(Long id) {
        CafeDto deletedCafe = cafeMapper.toDto(cafeRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        cafeRepository.deleteById(id);
        logger.info(String.format("Cafe %s deleted.", deletedCafe.getName()));

        return deletedCafe;
    }
}
