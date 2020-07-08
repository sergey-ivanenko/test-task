package by.itechart.testtask.controller;

import by.itechart.testtask.dto.ProductPriceDto;
import by.itechart.testtask.service.ProductPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {
    private static Logger logger = LoggerFactory.getLogger(ProductPriceController.class);

    private final ProductPriceService productPriceService;

    @Autowired
    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @GetMapping
    public List<ProductPriceDto> findAll() {
        logger.info("invoked method findAll.");
        return productPriceService.findAll();
    }

    @GetMapping("/{id}")
    public ProductPriceDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return productPriceService.findById(id);
    }

    @PostMapping("/add")
    public ProductPriceDto add(@RequestBody @Valid ProductPriceDto productPriceDto) {
        return productPriceService.add(productPriceDto);
    }

    @PutMapping("/update")
    public ProductPriceDto update(@RequestBody @Valid ProductPriceDto productPriceDto) {
        return productPriceService.update(productPriceDto);
    }

    @DeleteMapping("/{id}")
    public ProductPriceDto deleteById(@PathVariable Long id) {
        return productPriceService.deleteById(id);
    }
}
