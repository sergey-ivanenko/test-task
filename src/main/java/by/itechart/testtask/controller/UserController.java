package by.itechart.testtask.controller;

import by.itechart.testtask.dto.UserDto;
import by.itechart.testtask.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List findAll() {
        logger.info("invoked method findAll.");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        logger.info("invoked method findUserById.");
        return userService.findById(id);
    }

    @PostMapping("/add")
    public UserDto add(@RequestBody @Valid UserDto userDto) {
        return userService.add(userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestBody @Valid UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public UserDto deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
