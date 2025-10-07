package edu.ali.automobile_api.services;

import edu.ali.automobile_api.dtos.AutomobileDto;
import edu.ali.automobile_api.entities.Automobile;

import java.util.List;

public interface AutomobileService {
    List<AutomobileDto> getAllAutomobiles();
    AutomobileDto getAutomobileByVin(String vin);
    List<AutomobileDto> getAutomobilesByMake(String make);
    List<AutomobileDto> getAutomobilesByModel(String model);
    List<AutomobileDto> getAutomobilesByColor(String color);
    List<AutomobileDto> getAutomobilesByYear(int year);
    List<AutomobileDto> getAutomobilesByYearBetween(int startYear, int endYear);
    AutomobileDto createAutomobile(Automobile automobile);
    AutomobileDto updateAutomobile(Automobile automobile);
    void deleteAutomobile(String vin);
}
