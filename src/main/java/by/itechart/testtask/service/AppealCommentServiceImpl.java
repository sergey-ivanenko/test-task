package by.itechart.testtask.service;

import by.itechart.testtask.dto.AppealCommentDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.AppealCommentMapper;
import by.itechart.testtask.model.Appeal;
import by.itechart.testtask.model.AppealComment;
import by.itechart.testtask.model.User;
import by.itechart.testtask.repository.AppealCommentRepository;
import by.itechart.testtask.repository.AppealRepository;
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
public class AppealCommentServiceImpl implements AppealCommentService {
    private static Logger logger = LoggerFactory.getLogger(AppealCommentServiceImpl.class);

    private final AppealCommentRepository appealCommentRepository;
    private final AppealCommentMapper appealCommentMapper;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AppealRepository appealRepository;

    @Autowired
    public AppealCommentServiceImpl(AppealCommentRepository appealCommentRepository, AppealCommentMapper appealCommentMapper) {
        this.appealCommentRepository = appealCommentRepository;
        this.appealCommentMapper = appealCommentMapper;
    }

    @Override
    public AppealCommentDto add(AppealCommentDto appealCommentDto) {
        User user = userRepository.findById(appealCommentDto.getUserId()).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), appealCommentDto.getUserId())));
        Appeal appeal = appealRepository.findById(appealCommentDto.getAppealNumber()).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), appealCommentDto.getAppealNumber())));

        AppealComment appealComment = appealCommentMapper.toEntity(appealCommentDto);
        appealComment.setUser(user);
        appealComment.setAppeal(appeal);

        appealCommentRepository.save(appealComment);

        AppealCommentDto appealCommentDTO = appealCommentMapper.toDto(appealComment);
        logger.info(String.format("%s added.", appealCommentDTO));

        return appealCommentDTO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AppealCommentDto findById(Long id) {
        return appealCommentMapper.toDto(appealCommentRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AppealCommentDto> findAll() {
        List<AppealComment> appeals = (List<AppealComment>) appealCommentRepository.findAll();
        return appeals.stream().map(appealCommentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AppealCommentDto update(AppealCommentDto appealCommentDto) {
        logger.info(String.format("Appeal comment %s updated.", appealCommentDto.getId()));
        return appealCommentMapper.toDto(appealCommentRepository.save(appealCommentMapper.toEntity(appealCommentDto)));
    }

    @Override
    public AppealCommentDto deleteById(Long id) {
        AppealCommentDto deletedAppealComment = appealCommentMapper.toDto(appealCommentRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        appealCommentRepository.deleteById(id);
        logger.info(String.format("Appeal comment %d deleted.", deletedAppealComment.getId()));

        return deletedAppealComment;
    }
}
