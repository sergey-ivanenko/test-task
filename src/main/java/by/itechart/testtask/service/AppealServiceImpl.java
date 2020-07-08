package by.itechart.testtask.service;

import by.itechart.testtask.dto.AppealDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.AppealMapper;
import by.itechart.testtask.model.Appeal;
import by.itechart.testtask.model.Cafe;
import by.itechart.testtask.model.Ordering;
import by.itechart.testtask.repository.AppealRepository;
import by.itechart.testtask.repository.CafeRepository;
import by.itechart.testtask.repository.OrderingRepository;
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
public class AppealServiceImpl implements AppealService {
    private static Logger logger = LoggerFactory.getLogger(AppealServiceImpl.class);

    private final AppealRepository appealRepository;
    private final AppealMapper appealMapper;

    @Autowired
    public AppealServiceImpl(AppealRepository appealRepository, AppealMapper appealMapper) {
        this.appealRepository = appealRepository;
        this.appealMapper = appealMapper;
    }

    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    OrderingRepository orderingRepository;

    @Override
    public AppealDto add(AppealDto appealDto) {
        Cafe cafe = cafeRepository.findById(appealDto.getCafeId()).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), appealDto.getCafeId())));
        Ordering ordering = orderingRepository.findById(appealDto.getOrderingNumber()).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), appealDto.getOrderingNumber())));

        Appeal appeal = appealMapper.toEntity(appealDto);
        appeal.setCafe(cafe);
        appeal.setOrdering(ordering);

        appealRepository.save(appeal);

        AppealDto appealDTO = appealMapper.toDto(appeal);
        logger.info(String.format("%s added.", appealDTO));

        return appealDTO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AppealDto findById(Long id) {
        return appealMapper.toDto(appealRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AppealDto> findAll() {
        List<Appeal> appeals = (List<Appeal>) appealRepository.findAll();
        return appeals.stream().map(appealMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AppealDto update(AppealDto appealDto) {
        logger.info(String.format("Appeal %s updated.", appealDto.getId()));
        return appealMapper.toDto(appealRepository.save(appealMapper.toEntity(appealDto)));
    }

    @Override
    public AppealDto deleteById(Long id) {
        AppealDto deletedAppeal = appealMapper.toDto(appealRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        appealRepository.deleteById(id);
        logger.info(String.format("Appeal %d deleted.", deletedAppeal.getId()));

        return deletedAppeal;
    }
}
