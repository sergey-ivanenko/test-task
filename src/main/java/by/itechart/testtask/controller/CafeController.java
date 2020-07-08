package by.itechart.testtask.controller;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.service.CafeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    private static Logger logger = LoggerFactory.getLogger(CafeController.class);

    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public List<CafeDto> findAll() {
        logger.info("invoked method findAll.");
        return cafeService.findAll();
    }

    @GetMapping("/{id}")
    public CafeDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return cafeService.findById(id);
    }

    @PostMapping("/add")
    public CafeDto add(@RequestBody @Valid CafeDto cafeDto) {
        return cafeService.add(cafeDto);
    }

    @PutMapping("/update")
    public CafeDto update(@RequestBody @Valid CafeDto cafeDto) {
        return cafeService.update(cafeDto);
    }

    @DeleteMapping("/{id}")
    public CafeDto deleteById(@PathVariable Long id) {
        return cafeService.deleteById(id);
    }
}
