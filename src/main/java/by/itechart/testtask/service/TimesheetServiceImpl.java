package by.itechart.testtask.service;

import by.itechart.testtask.dto.TimesheetDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.TimesheetMapper;
import by.itechart.testtask.model.Timesheet;
import by.itechart.testtask.repository.TimesheetRepository;
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
public class TimesheetServiceImpl implements TimesheetService {
    private static Logger logger = LoggerFactory.getLogger(TimesheetServiceImpl.class);

    private final TimesheetRepository timesheetRepository;
    private final TimesheetMapper timesheetMapper;

    @Autowired
    public TimesheetServiceImpl(TimesheetRepository timesheetRepository, TimesheetMapper timesheetMapper) {
        this.timesheetRepository = timesheetRepository;
        this.timesheetMapper = timesheetMapper;
    }

    @Override
    public TimesheetDto add(TimesheetDto timesheetDto) {
        logger.info(String.format("%s added.", timesheetDto));
        return timesheetMapper.toDto(timesheetRepository.save(timesheetMapper.toEntity(timesheetDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public TimesheetDto findById(Long id) {
        return timesheetMapper.toDto(timesheetRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<TimesheetDto> findAll() {
        List<Timesheet> timesheetes = (List<Timesheet>) timesheetRepository.findAll();
        return timesheetes.stream().map(timesheetMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TimesheetDto update(TimesheetDto timesheetDto) {
        logger.info(String.format("Timesheet %d updated.", timesheetDto.getId()));
        return timesheetMapper.toDto(timesheetRepository.save(timesheetMapper.toEntity(timesheetDto)));
    }

    @Override
    public TimesheetDto deleteById(Long id) {
        TimesheetDto deletedTimesheet = timesheetMapper.toDto(timesheetRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        timesheetRepository.deleteById(id);
        logger.info(String.format("Timesheet %d deleted.", deletedTimesheet.getId()));

        return deletedTimesheet;
    }
}
