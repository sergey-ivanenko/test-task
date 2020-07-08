package by.itechart.testtask.service;

import by.itechart.testtask.dto.BalanceDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.BalanceMapper;
import by.itechart.testtask.model.Balance;
import by.itechart.testtask.repository.BalanceRepository;
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
public class BalanceServiceImpl implements BalanceService {
    private static Logger logger = LoggerFactory.getLogger(BalanceServiceImpl.class);

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;

    @Autowired
    public BalanceServiceImpl(BalanceRepository balanceRepository, BalanceMapper balanceMapper) {
        this.balanceRepository = balanceRepository;
        this.balanceMapper = balanceMapper;
    }

    @Override
    public BalanceDto add(BalanceDto balanceDto) {
        logger.info(String.format("%s added.", balanceDto));
        return balanceMapper.toDto(balanceRepository.save(balanceMapper.toEntity(balanceDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BalanceDto findById(Long id) {
        return balanceMapper.toDto(balanceRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<BalanceDto> findAll() {
        List<Balance> balances = (List<Balance>) balanceRepository.findAll();
        return balances.stream().map(balanceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BalanceDto update(BalanceDto balanceDto) {
        logger.info(String.format("Balance %d updated.", balanceDto.getId()));
        return balanceMapper.toDto(balanceRepository.save(balanceMapper.toEntity(balanceDto)));
    }

    @Override
    public BalanceDto deleteById(Long id) {
        BalanceDto deletedBalance = balanceMapper.toDto(balanceRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        balanceRepository.deleteById(id);
        logger.info(String.format("Balance %d deleted.", deletedBalance.getId()));

        return deletedBalance;
    }
}
