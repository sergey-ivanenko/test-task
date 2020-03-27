package by.itechart.testtask;

import by.itechart.testtask.dto.UserDto;
import by.itechart.testtask.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("HelloWorld")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/users")
    public List findAll() {
        logger.info("invoked method findAll");
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDto findUserById(@PathVariable Long id) {
        logger.info("invoked method findUserById");
        return userService.findUserById(id);
    }

    @PostMapping("/users/add")
    public UserDto add(@RequestBody @Valid UserDto userDto) {
        return userService.add(userDto);
    }

    @PutMapping("/users/update")
    public UserDto update(@RequestBody @Valid UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/users/{id}")
    public UserDto deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
