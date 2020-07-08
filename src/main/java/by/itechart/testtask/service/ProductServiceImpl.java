package by.itechart.testtask.service;

import by.itechart.testtask.dto.ProductDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.ProductMapper;
import by.itechart.testtask.model.Product;
import by.itechart.testtask.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto add(ProductDto productDto) {
        logger.info(String.format("%s added.", productDto));
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ProductDto findById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        logger.info(String.format("Product %s updated.", productDto.getId()));
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto deleteById(Long id) {
        ProductDto deletedProduct = productMapper.toDto(productRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        productRepository.deleteById(id);
        logger.info(String.format("Product %s deleted.", deletedProduct.getName()));

        return deletedProduct;
    }
}
