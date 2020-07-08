package by.itechart.testtask.controller;

import by.itechart.testtask.dto.TimesheetDto;
import by.itechart.testtask.service.TimesheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {
    private static Logger logger = LoggerFactory.getLogger(TimesheetController.class);

    private final TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping
    public List<TimesheetDto> findAll() {
        logger.info("invoked method findAll.");
        return timesheetService.findAll();
    }

    @GetMapping("/{id}")
    public TimesheetDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return timesheetService.findById(id);
    }

    @PostMapping("/add")
    public TimesheetDto add(@RequestBody @Valid TimesheetDto timesheetDto) {
        return timesheetService.add(timesheetDto);
    }

    @PutMapping("/update")
    public TimesheetDto update(@RequestBody @Valid TimesheetDto timesheetDto) {
        return timesheetService.update(timesheetDto);
    }

    @DeleteMapping("/{id}")
    public TimesheetDto deleteById(@PathVariable Long id) {
        return timesheetService.deleteById(id);
    }
}
