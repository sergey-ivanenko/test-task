package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.SalaryDto;
import by.itechart.testtask.dto.TimesheetDto;
import by.itechart.testtask.model.Salary;
import by.itechart.testtask.model.Timesheet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SalaryMapper {
    @Mapping(source = "user.id", target = "userId")
    SalaryDto toDto(Salary salary);

    @InheritInverseConfiguration
    Salary toEntity(SalaryDto salaryDto);
}
