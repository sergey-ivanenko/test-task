package by.itechart.testtask.controller;

import by.itechart.testtask.dto.RoleDto;
import by.itechart.testtask.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List findAll() {
        logger.info("invoked method findAll.");
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable Long id) {
        logger.info("invoked method findUserById.");
        return roleService.findById(id);
    }

    @PostMapping("/add")
    public RoleDto add(@RequestBody @Valid RoleDto roleDto) {
        return roleService.add(roleDto);
    }

    @PutMapping("/update")
    public RoleDto update(@RequestBody @Valid RoleDto roleDto) {
        return roleService.update(roleDto);
    }

    @DeleteMapping("/{id}")
    public RoleDto deleteById(@PathVariable Long id) {
        return roleService.deleteById(id);
    }
}
