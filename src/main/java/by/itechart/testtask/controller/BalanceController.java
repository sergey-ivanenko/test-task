package by.itechart.testtask.controller;

import by.itechart.testtask.dto.BalanceDto;
import by.itechart.testtask.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    private static Logger logger = LoggerFactory.getLogger(BalanceController.class);

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<BalanceDto> findAll() {
        logger.info("invoked method findAll.");
        return balanceService.findAll();
    }

    @GetMapping("/{id}")
    public BalanceDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return balanceService.findById(id);
    }

    @PostMapping("/add")
    public BalanceDto add(@RequestBody @Valid BalanceDto balanceDto) {
        return balanceService.add(balanceDto);
    }

    @PutMapping("/update")
    public BalanceDto update(@RequestBody @Valid BalanceDto balanceDto) {
        return balanceService.update(balanceDto);
    }

    @DeleteMapping("/{id}")
    public BalanceDto deleteById(@PathVariable Long id) {
        return balanceService.deleteById(id);
    }
}
