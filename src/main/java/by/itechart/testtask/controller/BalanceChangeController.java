package by.itechart.testtask.controller;

import by.itechart.testtask.dto.BalanceChangeDto;
import by.itechart.testtask.service.BalanceChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/balance-change")
public class BalanceChangeController {
    private static Logger logger = LoggerFactory.getLogger(BalanceChangeController.class);

    private final BalanceChangeService balanceChangeService;

    @Autowired
    public BalanceChangeController(BalanceChangeService balanceChangeService) {
        this.balanceChangeService = balanceChangeService;
    }

    @GetMapping
    public List<BalanceChangeDto> findAll() {
        logger.info("invoked method findAll.");
        return balanceChangeService.findAll();
    }

    @GetMapping("/{id}")
    public BalanceChangeDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return balanceChangeService.findById(id);
    }

    @PostMapping("/add")
    public BalanceChangeDto add(@RequestBody @Valid BalanceChangeDto balanceChangeDto) {
        return balanceChangeService.add(balanceChangeDto);
    }

    @PutMapping("/update")
    public BalanceChangeDto update(@RequestBody @Valid BalanceChangeDto balanceChangeDto) {
        return balanceChangeService.update(balanceChangeDto);
    }

    @DeleteMapping("/{id}")
    public BalanceChangeDto deleteById(@PathVariable Long id) {
        return balanceChangeService.deleteById(id);
    }
}
