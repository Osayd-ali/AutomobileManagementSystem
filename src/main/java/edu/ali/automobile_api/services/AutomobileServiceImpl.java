package edu.ali.automobile_api.services;

import edu.ali.automobile_api.dtos.AutomobileDto;
import edu.ali.automobile_api.entities.Automobile;
import edu.ali.automobile_api.exceptions.AlreadyExistsException;
import edu.ali.automobile_api.exceptions.BadParameterException;
import edu.ali.automobile_api.exceptions.NotFoundException;
import edu.ali.automobile_api.repositories.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutomobileServiceImpl implements AutomobileService {
    private AutomobileRepository repository;

    @Autowired
    public AutomobileServiceImpl(AutomobileRepository repository) {
        this.repository = repository;
    }

    @Value("${automobile.min.year}")
    private int minYear;

    @Override
    public List<AutomobileDto> getAllAutomobiles() {
        List<Automobile> automobiles = repository.findAll();
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found");
        }

        return automobiles.stream()
                .map(AutomobileDto::new)
                .toList();
    }

    @Override
    public AutomobileDto getAutomobileByVin(String vin) {
        Automobile automobile = repository.findByVin(vin);
        if(automobile == null){
            throw new NotFoundException("Automobile with VIN " + vin + " does not exist");
        }
        else {
            return new AutomobileDto(automobile);
        }
    }

    @Override
    public List<AutomobileDto> getAutomobilesByMake(String make) {
        List<Automobile> automobiles = repository.findByMake(make);
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found for make " + make);
        }
        else {
            return automobiles.stream()
                    .map(AutomobileDto::new)
                    .toList();
        }
    }

    @Override
    public List<AutomobileDto> getAutomobilesByModel(String model) {
        List<Automobile> automobiles = repository.findByModel(model);
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found for model " + model);
        }
        else {
            return automobiles.stream()
                    .map(AutomobileDto::new)
                    .toList();
        }
    }

    @Override
    public List<AutomobileDto> getAutomobilesByColor(String color) {
        List<Automobile> automobiles = repository.findByColor(color);
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found for color " + color);
        }
        else {
            return automobiles.stream()
                    .map(AutomobileDto::new)
                    .toList();
        }
    }

    @Override
    public List<AutomobileDto> getAutomobilesByYear(int year) {
        List<Automobile> automobiles = repository.findByYear(year);
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found for year " + year);
        }
        else {
            return automobiles.stream()
                    .map(AutomobileDto::new)
                    .toList();
        }
    }

    @Override
    public List<AutomobileDto> getAutomobilesByYearBetween(int startYear, int endYear) {
        List<Automobile> automobiles = repository.findByYearBetween(startYear, endYear);
        if(automobiles.isEmpty()){
            throw new NotFoundException("No automobiles found between years " + startYear + " and " + endYear);
        }
        else {
            return automobiles.stream()
                    .map(AutomobileDto::new)
                    .toList();
        }
    }

    @Override
    public AutomobileDto createAutomobile(Automobile automobile) {
        validateAutomobile(automobile);
        if(repository.existsByVin(automobile.getVin())) {
            throw new AlreadyExistsException("Automobile with VIN " + automobile.getVin() + " already exists");
        }
        Automobile savedAutomobile = repository.save(automobile);
        return new AutomobileDto(savedAutomobile);
    }

    @Override
    public AutomobileDto updateAutomobile(Automobile automobile) {
        validateAutomobile(automobile);
        if(!repository.existsByVin(automobile.getVin())) {
            throw new NotFoundException("Automobile with VIN " + automobile.getVin() + " does not exist");
        }

        Automobile existingAutomobile = repository.findByVin(automobile.getVin());
        existingAutomobile.setMake(automobile.getMake());
        existingAutomobile.setModel(automobile.getModel());
        existingAutomobile.setColor(automobile.getColor());
        existingAutomobile.setYear(automobile.getYear());
        Automobile updatedAutomobile = repository.save(existingAutomobile);
        return new AutomobileDto(updatedAutomobile);
    }

    @Override
    public void deleteAutomobile(String vin) {
        if(!repository.existsByVin(vin)) {
            throw new NotFoundException("Automobile with VIN " + vin + " does not exist");
        }
        else  {
            repository.delete(repository.findByVin(vin));
            System.out.println("Automobile with VIN " + vin + " deleted");
        }
    }

    /// Validation Methods ////

    private void validateAutomobile(Automobile automobile) {
        validateVin(automobile.getVin());
        validateMake(automobile.getMake());
        validateModel(automobile.getModel());
        validateColor(automobile.getColor());
        validateYear(automobile.getYear());
    }

    private void validateVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new BadParameterException("VIN must not be null and must be exactly 17 characters");
        }
    }

    private void validateMake(String make){
        if(make == null || make.isEmpty()){
            throw new BadParameterException("Make must not be null or empty");
        }
    }

    private void validateModel(String model){
        if(model == null || model.isEmpty()){
            throw new BadParameterException("Model must not be null or empty");
        }
    }

    private void validateColor(String color){
        if(color == null || color.isEmpty()){
            throw new BadParameterException("Color must not be null or empty");
        }
    }

    private void validateYear(int year){
        int currentYear = LocalDate.now().getYear();
        if(year < minYear || year > currentYear){
            throw new BadParameterException("Year must be between " + minYear + " and " + currentYear);
        }
    }
}