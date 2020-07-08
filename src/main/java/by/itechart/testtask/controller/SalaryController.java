package by.itechart.testtask.controller;

import by.itechart.testtask.dto.SalaryDto;
import by.itechart.testtask.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    private static Logger logger = LoggerFactory.getLogger(SalaryController.class);

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<SalaryDto> findAll() {
        logger.info("invoked method findAll.");
        return salaryService.findAll();
    }

    @GetMapping("/{id}")
    public SalaryDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return salaryService.findById(id);
    }

    @PostMapping("/add")
    public SalaryDto add(@RequestBody @Valid SalaryDto salaryDto) {
        return salaryService.add(salaryDto);
    }

    @PutMapping("/update")
    public SalaryDto update(@RequestBody @Valid SalaryDto salaryDto) {
        return salaryService.update(salaryDto);
    }

    @DeleteMapping("/{id}")
    public SalaryDto deleteById(@PathVariable Long id) {
        return salaryService.deleteById(id);
    }
}
