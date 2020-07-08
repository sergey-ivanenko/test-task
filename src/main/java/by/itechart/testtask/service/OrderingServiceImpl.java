package by.itechart.testtask.service;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.dto.OrderingDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.MenuItemMapper;
import by.itechart.testtask.mapper.OrderingMapper;
import by.itechart.testtask.model.Cafe;
import by.itechart.testtask.model.MenuItem;
import by.itechart.testtask.model.Ordering;
import by.itechart.testtask.model.User;
import by.itechart.testtask.repository.MenuItemRepository;
import by.itechart.testtask.repository.OrderingRepository;
import by.itechart.testtask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderingServiceImpl implements OrderingService {
    private static Logger logger = LoggerFactory.getLogger(OrderingServiceImpl.class);

    private final OrderingRepository orderingRepository;
    private final OrderingMapper orderingMapper;

    @Autowired
    public OrderingServiceImpl(OrderingRepository orderingRepository, OrderingMapper orderingMapper) {
        this.orderingRepository = orderingRepository;
        this.orderingMapper = orderingMapper;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Override
    public OrderingDto add(OrderingDto orderingDto) {
        User user = userRepository.findById(orderingDto.getUserId()).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), orderingDto.getUserId())));

        List<MenuItem> menuItems = orderingDto.getMenuItems()
                .stream()
                .map(menuItemDto -> menuItemMapper.toEntity(menuItemDto))
                .collect(Collectors.toList());

        Ordering ordering = orderingMapper.toEntity(orderingDto);
        ordering.setUser(user);
        ordering.setMenuItems(menuItems);

        OrderingDto orderingDTO = orderingMapper.toDto(ordering);

        logger.info(String.format("%s added.", orderingDTO));

        orderingRepository.save(ordering);

        return orderingDTO;
        //return orderingMapper.toDto(orderingRepository.save(orderingMapper.toEntity(orderingDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public OrderingDto findById(Long id) {
        return orderingMapper.toDto(orderingRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrderingDto> findAll() {
        List<Ordering> orderings = (List<Ordering>) orderingRepository.findAll();
        return orderings.stream().map(orderingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderingDto update(OrderingDto orderingDto) {
        logger.info(String.format("Ordering %d updated.", orderingDto.getId()));
        return orderingMapper.toDto(orderingRepository.save(orderingMapper.toEntity(orderingDto)));
    }

    @Override
    public OrderingDto deleteById(Long id) {
        OrderingDto deletedOrdering = orderingMapper.toDto(orderingRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        orderingRepository.deleteById(id);
        logger.info(String.format("Cafe %d deleted.", deletedOrdering.getId()));

        return deletedOrdering;
    }
}
