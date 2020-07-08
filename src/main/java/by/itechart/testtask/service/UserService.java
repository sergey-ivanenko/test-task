package by.itechart.testtask.service;

import by.itechart.testtask.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto add(UserDto userDto);

    UserDto findById(Long id);

    UserDto findByLogin(String login);

    List<UserDto> findAll();

    UserDto update(UserDto userDto);

    UserDto deleteById(Long id);
}
