package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.TimesheetDto;
import by.itechart.testtask.model.Timesheet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TimesheetMapper {
    @Mapping(source = "user.id", target = "userId")
    TimesheetDto toDto(Timesheet timesheet);

    @InheritInverseConfiguration
    Timesheet toEntity(TimesheetDto timesheetDto);
}
