package by.itechart.testtask.controller;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.dto.OrderingDto;
import by.itechart.testtask.service.CafeService;
import by.itechart.testtask.service.OrderingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordering")
public class OrderingController {
    private static Logger logger = LoggerFactory.getLogger(OrderingController.class);

    private final OrderingService orderingService;

    @Autowired
    public OrderingController(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @GetMapping
    public List<OrderingDto> findAll() {
        logger.info("invoked method findAll.");
        return orderingService.findAll();
    }

    @GetMapping("/{id}")
    public OrderingDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return orderingService.findById(id);
    }

    @PostMapping("/add")
    public OrderingDto add(@RequestBody @Valid OrderingDto orderingDto) {
        return orderingService.add(orderingDto);
    }

    @PutMapping("/update")
    public OrderingDto update(@RequestBody @Valid OrderingDto orderingDto) {
        return orderingService.update(orderingDto);
    }

    @DeleteMapping("/{id}")
    public OrderingDto deleteById(@PathVariable Long id) {
        return orderingService.deleteById(id);
    }
}
