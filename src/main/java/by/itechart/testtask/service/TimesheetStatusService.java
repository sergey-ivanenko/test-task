package by.itechart.testtask.service;

import by.itechart.testtask.dto.TimesheetStatusDto;

import java.util.List;

public interface TimesheetStatusService {
    TimesheetStatusDto add(TimesheetStatusDto timesheetStatusDto);

    TimesheetStatusDto findById(Long id);

    List<TimesheetStatusDto> findAll();

    TimesheetStatusDto update(TimesheetStatusDto timesheetStatusDto);

    TimesheetStatusDto deleteById(Long id);
}
