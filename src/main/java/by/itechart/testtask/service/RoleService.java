package by.itechart.testtask.service;

import by.itechart.testtask.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto add(RoleDto roleDto);

    RoleDto findById(Long id);

    List<RoleDto> findAll();

    RoleDto update(RoleDto roleDto);

    RoleDto deleteById(Long id);
}
