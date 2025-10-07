package edu.ali.automobile_api.dtos;

import edu.ali.automobile_api.entities.Automobile;

public record AutomobileDto (
        String vin, String make, String model, String color, int year){

    public AutomobileDto(Automobile automobile){
        this(automobile.getVin(), automobile.getMake(), automobile.getModel(), automobile.getColor(), automobile.getYear());
    }

}

