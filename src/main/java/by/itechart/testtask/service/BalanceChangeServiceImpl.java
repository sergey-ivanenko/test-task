package by.itechart.testtask.service;

import by.itechart.testtask.dto.BalanceChangeDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.BalanceChangeMapper;
import by.itechart.testtask.model.BalanceChange;
import by.itechart.testtask.repository.BalanceChangeRepository;
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
public class BalanceChangeServiceImpl implements BalanceChangeService {
    private static Logger logger = LoggerFactory.getLogger(BalanceChangeServiceImpl.class);

    private final BalanceChangeRepository balanceChangeRepository;
    private final BalanceChangeMapper balanceChangeMapper;

    @Autowired
    public BalanceChangeServiceImpl(BalanceChangeRepository balanceChangeRepository, BalanceChangeMapper balanceChangeMapper) {
        this.balanceChangeRepository = balanceChangeRepository;
        this.balanceChangeMapper = balanceChangeMapper;
    }

    @Override
    public BalanceChangeDto add(BalanceChangeDto balanceChangeDto) {
        logger.info(String.format("%s added.", balanceChangeDto));
        return balanceChangeMapper.toDto(balanceChangeRepository.save(balanceChangeMapper.toEntity(balanceChangeDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BalanceChangeDto findById(Long id) {
        return balanceChangeMapper.toDto(balanceChangeRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<BalanceChangeDto> findAll() {
        List<BalanceChange> balanceChanges = (List<BalanceChange>) balanceChangeRepository.findAll();
        return balanceChanges.stream().map(balanceChangeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BalanceChangeDto update(BalanceChangeDto balanceChangeDto) {
        logger.info(String.format("Balance change %d updated.", balanceChangeDto.getId()));
        return balanceChangeMapper.toDto(balanceChangeRepository.save(balanceChangeMapper.toEntity(balanceChangeDto)));
    }

    @Override
    public BalanceChangeDto deleteById(Long id) {
        BalanceChangeDto deletedBalanceChange = balanceChangeMapper.toDto(balanceChangeRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        balanceChangeRepository.deleteById(id);
        logger.info(String.format("Balance change %d deleted.", deletedBalanceChange.getId()));

        return deletedBalanceChange;
    }
}
