package by.itechart.testtask.service;

import by.itechart.testtask.dto.ProductPriceDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.ProductPriceMapper;
import by.itechart.testtask.model.ProductPrice;
import by.itechart.testtask.repository.ProductPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductPriceServiceImpl implements ProductPriceService {
    private static Logger logger = LoggerFactory.getLogger(ProductPriceServiceImpl.class);

    private final ProductPriceRepository productPriceRepository;
    private final ProductPriceMapper productPriceMapper;

    public ProductPriceServiceImpl(ProductPriceRepository productPriceRepository, ProductPriceMapper productPriceMapper) {
        this.productPriceRepository = productPriceRepository;
        this.productPriceMapper = productPriceMapper;
    }

    @Override
    public ProductPriceDto add(ProductPriceDto productPriceDto) {
        logger.info(String.format("%s added.", productPriceDto));
        return productPriceMapper.toDto(productPriceRepository.save(productPriceMapper.toEntity(productPriceDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ProductPriceDto findById(Long id) {
        return productPriceMapper.toDto(productPriceRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ProductPriceDto> findAll() {
        List<ProductPrice> productPrices = (List<ProductPrice>) productPriceRepository.findAll();
        return productPrices.stream().map(productPriceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductPriceDto update(ProductPriceDto productPriceDto) {
        logger.info(String.format("Product price %d updated.", productPriceDto.getId()));
        return productPriceMapper.toDto(productPriceRepository.save(productPriceMapper.toEntity(productPriceDto)));
    }

    @Override
    public ProductPriceDto deleteById(Long id) {
        ProductPriceDto deletedProductPrice = productPriceMapper.toDto(productPriceRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        productPriceRepository.deleteById(id);
        logger.info(String.format("Price %d deleted.", deletedProductPrice.getId()));

        return deletedProductPrice;
    }
}
