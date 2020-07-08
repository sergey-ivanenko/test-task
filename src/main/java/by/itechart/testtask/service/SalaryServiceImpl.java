package by.itechart.testtask.service;

import by.itechart.testtask.dto.SalaryDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.SalaryMapper;
import by.itechart.testtask.model.Salary;
import by.itechart.testtask.repository.SalaryRepository;
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
public class SalaryServiceImpl implements SalaryService {
    private static Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);

    private final SalaryRepository salaryRepository;
    private final SalaryMapper salaryMapper;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository, SalaryMapper salaryMapper) {
        this.salaryRepository = salaryRepository;
        this.salaryMapper = salaryMapper;
    }

    @Override
    public SalaryDto add(SalaryDto salaryDto) {
        logger.info(String.format("%s added.", salaryDto));
        return salaryMapper.toDto(salaryRepository.save(salaryMapper.toEntity(salaryDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public SalaryDto findById(Long id) {
        return salaryMapper.toDto(salaryRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<SalaryDto> findAll() {
        List<Salary> salaries = (List<Salary>) salaryRepository.findAll();
        return salaries.stream().map(salaryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SalaryDto update(SalaryDto salaryDto) {
        logger.info(String.format("Salary %d updated.", salaryDto.getId()));
        return salaryMapper.toDto(salaryRepository.save(salaryMapper.toEntity(salaryDto)));
    }

    @Override
    public SalaryDto deleteById(Long id) {
        SalaryDto deletedSalary = salaryMapper.toDto(salaryRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        salaryRepository.deleteById(id);
        logger.info(String.format("Salary %d deleted.", deletedSalary.getId()));

        return deletedSalary;
    }
}
