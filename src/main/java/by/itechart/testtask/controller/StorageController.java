package by.itechart.testtask.controller;

import by.itechart.testtask.dto.StorageDto;
import by.itechart.testtask.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {
    private static Logger logger = LoggerFactory.getLogger(StorageController.class);

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public List<StorageDto> findAll() {
        logger.info("invoked method findAll.");
        return storageService.findAll();
    }

    @GetMapping("/{id}")
    public StorageDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return storageService.findById(id);
    }

    @PostMapping("/add")
    public StorageDto add(@RequestBody @Valid StorageDto storageDto) {
        return storageService.add(storageDto);
    }

    @PutMapping("/update")
    public StorageDto update(@RequestBody @Valid StorageDto storageDto) {
        return storageService.update(storageDto);
    }

    @DeleteMapping("/{id}")
    public StorageDto deleteById(@PathVariable Long id) {
        return storageService.deleteById(id);
    }
}
