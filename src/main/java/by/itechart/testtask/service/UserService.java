package by.itechart.testtask.service;

import by.itechart.testtask.dto.UserDto;
import by.itechart.testtask.model.User;
import java.util.List;

public interface UserService {
    UserDto add(UserDto userDto);
    UserDto findUserById(Long id);
    List<UserDto> findAll();
    UserDto update(UserDto userDto);
    UserDto deleteById(Long id);
}
