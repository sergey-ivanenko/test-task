package by.itechart.testtask.controller;

import by.itechart.testtask.dto.AppealCommentDto;
import by.itechart.testtask.service.AppealCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class AppealCommentController {
    private static Logger logger = LoggerFactory.getLogger(AppealCommentController.class);

    private final AppealCommentService appealCommentService;

    @Autowired
    public AppealCommentController(AppealCommentService appealCommentService) {
        this.appealCommentService = appealCommentService;
    }

    @GetMapping
    public List<AppealCommentDto> findAll() {
        logger.info("invoked method findAll.");
        return appealCommentService.findAll();
    }

    @GetMapping("/{id}")
    public AppealCommentDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return appealCommentService.findById(id);
    }

    @PostMapping("/add")
    public AppealCommentDto add(@RequestBody @Valid AppealCommentDto appealCommentDto) {
        return appealCommentService.add(appealCommentDto);
    }

    @PutMapping("/update")
    public AppealCommentDto update(@RequestBody @Valid AppealCommentDto appealCommentDto) {
        return appealCommentService.update(appealCommentDto);
    }

    @DeleteMapping("/{id}")
    public AppealCommentDto deleteById(@PathVariable Long id) {
        return appealCommentService.deleteById(id);
    }
}
