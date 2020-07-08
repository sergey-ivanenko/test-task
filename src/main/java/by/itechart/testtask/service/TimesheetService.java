package by.itechart.testtask.service;

import by.itechart.testtask.dto.TimesheetDto;

import java.util.List;

public interface TimesheetService {
    TimesheetDto add(TimesheetDto timesheetDto);

    TimesheetDto findById(Long id);

    List<TimesheetDto> findAll();

    TimesheetDto update(TimesheetDto timesheetDto);

    TimesheetDto deleteById(Long id);
}
