package by.itechart.testtask.controller;

import by.itechart.testtask.dto.TimesheetStatusDto;
import by.itechart.testtask.service.TimesheetStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/timesheet-status")
public class TimesheetStatusController {
    private static Logger logger = LoggerFactory.getLogger(TimesheetStatusController.class);

    private final TimesheetStatusService timesheetStatusService;

    @Autowired
    public TimesheetStatusController(TimesheetStatusService timesheetStatusService) {
        this.timesheetStatusService = timesheetStatusService;
    }

    @GetMapping
    public List<TimesheetStatusDto> findAll() {
        logger.info("invoked method findAll.");
        return timesheetStatusService.findAll();
    }

    @GetMapping("/{id}")
    public TimesheetStatusDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return timesheetStatusService.findById(id);
    }

    @PostMapping("/add")
    public TimesheetStatusDto add(@RequestBody @Valid TimesheetStatusDto timesheetStatusDto) {
        return timesheetStatusService.add(timesheetStatusDto);
    }

    @PutMapping("/update")
    public TimesheetStatusDto update(@RequestBody @Valid TimesheetStatusDto timesheetStatusDto) {
        return timesheetStatusService.update(timesheetStatusDto);
    }

    @DeleteMapping("/{id}")
    public TimesheetStatusDto deleteById(@PathVariable Long id) {
        return timesheetStatusService.deleteById(id);
    }
}
