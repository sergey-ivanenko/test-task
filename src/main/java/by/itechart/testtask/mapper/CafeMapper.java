package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.model.Cafe;
import org.mapstruct.Mapper;

@Mapper
public interface CafeMapper {
    CafeDto toDto(Cafe cafe);

    Cafe toEntity(CafeDto cafeDto);
}
