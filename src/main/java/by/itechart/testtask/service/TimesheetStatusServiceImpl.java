package by.itechart.testtask.service;

import by.itechart.testtask.dto.TimesheetStatusDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.TimesheetStatusMapper;
import by.itechart.testtask.model.TimesheetStatus;
import by.itechart.testtask.repository.TimesheetStatusRepository;
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
public class TimesheetStatusServiceImpl implements TimesheetStatusService {
    private static Logger logger = LoggerFactory.getLogger(TimesheetStatusServiceImpl.class);

    private final TimesheetStatusRepository timesheetStatusRepository;
    private final TimesheetStatusMapper timesheetStatusMapper;

    @Autowired
    public TimesheetStatusServiceImpl(TimesheetStatusRepository timesheetStatusRepository, TimesheetStatusMapper timesheetStatusMapper) {
        this.timesheetStatusRepository = timesheetStatusRepository;
        this.timesheetStatusMapper = timesheetStatusMapper;
    }

    @Override
    public TimesheetStatusDto add(TimesheetStatusDto timesheetStatusDto) {
        logger.info(String.format("%s added.", timesheetStatusDto));
        return timesheetStatusMapper.toDto(timesheetStatusRepository.save(timesheetStatusMapper.toEntity(timesheetStatusDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public TimesheetStatusDto findById(Long id) {
        return timesheetStatusMapper.toDto(timesheetStatusRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<TimesheetStatusDto> findAll() {
        List<TimesheetStatus> timesheetStatuses = (List<TimesheetStatus>) timesheetStatusRepository.findAll();
        return timesheetStatuses.stream().map(timesheetStatusMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TimesheetStatusDto update(TimesheetStatusDto timesheetStatusDto) {
        logger.info(String.format("Timesheet status %d updated.", timesheetStatusDto.getId()));
        return timesheetStatusMapper.toDto(timesheetStatusRepository.save(timesheetStatusMapper.toEntity(timesheetStatusDto)));
    }

    @Override
    public TimesheetStatusDto deleteById(Long id) {
        TimesheetStatusDto deletedTimesheetStatus = timesheetStatusMapper.toDto(timesheetStatusRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        timesheetStatusRepository.deleteById(id);
        logger.info(String.format("Timesheet status %d deleted.", deletedTimesheetStatus.getId()));

        return deletedTimesheetStatus;
    }
}
