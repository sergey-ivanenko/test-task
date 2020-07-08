package by.itechart.testtask.controller;

import by.itechart.testtask.dto.PurchaseStatusDto;
import by.itechart.testtask.service.PurchaseStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/purchase-status")
public class PurchaseStatusController {
    private static Logger logger = LoggerFactory.getLogger(PurchaseStatusController.class);

    private final PurchaseStatusService purchaseStatusService;

    @Autowired
    public PurchaseStatusController(PurchaseStatusService purchaseStatusService) {
        this.purchaseStatusService = purchaseStatusService;
    }

    @GetMapping
    public List<PurchaseStatusDto> findAll() {
        logger.info("invoked method findAll.");
        return purchaseStatusService.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseStatusDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return purchaseStatusService.findById(id);
    }

    @PostMapping("/add")
    public PurchaseStatusDto add(@RequestBody @Valid PurchaseStatusDto purchaseStatusDto) {
        return purchaseStatusService.add(purchaseStatusDto);
    }

    @PutMapping("/update")
    public PurchaseStatusDto update(@RequestBody @Valid PurchaseStatusDto purchaseStatusDto) {
        return purchaseStatusService.update(purchaseStatusDto);
    }

    @DeleteMapping("/{id}")
    public PurchaseStatusDto deleteById(@PathVariable Long id) {
        return purchaseStatusService.deleteById(id);
    }
}
