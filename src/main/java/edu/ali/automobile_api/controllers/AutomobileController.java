package edu.ali.automobile_api.controllers;

import edu.ali.automobile_api.dtos.ApiExceptionDto;
import edu.ali.automobile_api.dtos.AutomobileDto;
import edu.ali.automobile_api.entities.Automobile;
import edu.ali.automobile_api.exceptions.AlreadyExistsException;
import edu.ali.automobile_api.exceptions.BadParameterException;
import edu.ali.automobile_api.exceptions.NotFoundException;
import edu.ali.automobile_api.services.AutomobileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {

    private final AutomobileService automobileService;

    @Autowired
    public AutomobileController(AutomobileService automobileService) {
        this.automobileService = automobileService;
    }

    @GetMapping("/all")
    public List<AutomobileDto> getAllAutomobiles() {
        return automobileService.getAllAutomobiles();
    }

    @GetMapping("/vin/{vin}")
    public AutomobileDto getAutomobileByVin(@PathVariable String vin) {
        return automobileService.getAutomobileByVin(vin);
    }

    @GetMapping("/make/{make}")
    public List<AutomobileDto> getAutomobilesByMake(@PathVariable String make){
        return automobileService.getAutomobilesByMake(make);
    }

    @GetMapping("/model/{make}/{model}")
    public List<AutomobileDto> getAutomobilesByModel(@PathVariable String model){
        return automobileService.getAutomobilesByModel(model);
    }

    @GetMapping("/color/{color}")
    public List<AutomobileDto> getAutomobilesByColor(@PathVariable String color){
        return automobileService.getAutomobilesByColor(color);
    }

    @GetMapping("/year/{year}")
    public List<AutomobileDto> getAutomobilesByYear(@PathVariable int year){
        return automobileService.getAutomobilesByYear(year);
    }

    @GetMapping("/year/{startYear}/{endYear}")
    public List<AutomobileDto> getAutomobilesByYearBetween(@PathVariable int startYear,
                                                         @PathVariable int endYear){
        return automobileService.getAutomobilesByYearBetween(startYear,endYear);
    }

    @PostMapping("/create")
    public AutomobileDto createAutomobile(@RequestBody Automobile automobile){
        return automobileService.createAutomobile(automobile);
    }

    @PutMapping("/update")
    public AutomobileDto updateAutomobile(@RequestBody Automobile automobile){
        return automobileService.updateAutomobile(automobile);
    }

    @DeleteMapping("/delete/{vin}")
    public void deleteAutomobile(@PathVariable String vin){
        automobileService.deleteAutomobile(vin);
    }

    /// Exception Handling ///

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(
            NotFoundException ex, HttpServletRequest request) {
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null
        );
        return new ResponseEntity<>(apiExceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadParameterException.class)
    public ResponseEntity<?> handleBadParameterException(
            BadParameterException ex, HttpServletRequest request) {
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null
        );
        return new ResponseEntity<>(apiExceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(
            AlreadyExistsException ex, HttpServletRequest request) {
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(
                ex.getMessage(),
                HttpStatus.CONFLICT.value(),
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null
        );
        return new ResponseEntity<>(apiExceptionDto, HttpStatus.CONFLICT);
    }
}
