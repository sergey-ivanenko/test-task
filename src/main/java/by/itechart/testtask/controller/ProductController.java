package by.itechart.testtask.controller;

import by.itechart.testtask.dto.ProductDto;
import by.itechart.testtask.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        logger.info("invoked method findAll.");
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return productService.findById(id);
    }

    @PostMapping("/add")
    public ProductDto add(@RequestBody @Valid ProductDto productDto) {
        return productService.add(productDto);
    }

    @PutMapping("/update")
    public ProductDto update(@RequestBody @Valid ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping("/{id}")
    public ProductDto deleteById(@PathVariable Long id) {
        return productService.deleteById(id);
    }
}
