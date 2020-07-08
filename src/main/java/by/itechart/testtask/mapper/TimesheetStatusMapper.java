package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.BalanceChangeDto;
import by.itechart.testtask.dto.TimesheetStatusDto;
import by.itechart.testtask.model.BalanceChange;
import by.itechart.testtask.model.TimesheetStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TimesheetStatusMapper {
    @Mappings({
            @Mapping(source = "timesheet.id", target = "timesheetId"),
            @Mapping(source = "user.id", target = "userId")
    })
    TimesheetStatusDto toDto(TimesheetStatus timesheetStatus);

    @InheritInverseConfiguration
    TimesheetStatus toEntity(TimesheetStatusDto timesheetStatusDto);
}
