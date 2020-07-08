package by.itechart.testtask.controller;

import by.itechart.testtask.dto.PurchaseDto;
import by.itechart.testtask.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private static Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseDto> findAll() {
        logger.info("invoked method findAll.");
        return purchaseService.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return purchaseService.findById(id);
    }

    @PostMapping("/add")
    public PurchaseDto add(@RequestBody @Valid PurchaseDto purchaseDto) {
        return purchaseService.add(purchaseDto);
    }

    @PutMapping("/update")
    public PurchaseDto update(@RequestBody @Valid PurchaseDto purchaseDto) {
        return purchaseService.update(purchaseDto);
    }

    @DeleteMapping("/{id}")
    public PurchaseDto deleteById(@PathVariable Long id) {
        return purchaseService.deleteById(id);
    }
}
