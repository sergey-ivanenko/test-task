package by.itechart.testtask.service;

import by.itechart.testtask.dto.AppealCommentDto;

import java.util.List;

public interface AppealCommentService {
    AppealCommentDto add(AppealCommentDto appealCommentDto);

    AppealCommentDto findById(Long id);

    List<AppealCommentDto> findAll();

    AppealCommentDto update(AppealCommentDto appealCommentDto);

    AppealCommentDto deleteById(Long id);
}
