package edu.ali.automobile_api.initializers;

import edu.ali.automobile_api.entities.Automobile;
import edu.ali.automobile_api.repositories.AutomobileRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutomobileDataInitializer {
    private final AutomobileRepository automobileRepository;

    @Autowired
    public AutomobileDataInitializer(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }
    @PostConstruct
    public void init() {
        if (automobileRepository.count() > 0) {
            System.out.println("Skipping auto data initialization — records already exist.");
            return;
        }
        List<Automobile> autos = List.of(
                new Automobile("1HGCM82633A123456", "Toyota", "Camry", "Silver", 2020),
                new Automobile("2T1BURHE9JC012345", "Toyota", "Corolla", "White", 2018),
                new Automobile("1HGFA16597L123456", "Honda", "Civic", "Black", 2019),
                new Automobile("1HGCR2F3XHA012345", "Honda", "Accord", "Silver", 2021),
                new Automobile("3FAHP0HA7AR123456", "Ford", "Fusion", "Gray", 2017),
                new Automobile("1FMCU0F70EUA12345", "Ford", "Escape", "Blue", 2023),
                new Automobile("1G1ZD5ST4JF123456", "Chevrolet", "Malibu", "White", 2016),
                new Automobile("2GNFLFEK5H6123456", "Chevrolet", "Equinox", "Red", 2022),
                new Automobile("1N4AL3AP8HC123456", "Nissan", "Altima", "Gray", 2020),
                new Automobile("3N1AB7AP3KY123456", "Nissan", "Sentra", "Black", 2019),
                new Automobile("5NPE24AF6FH123456", "Hyundai", "Sonata", "Blue", 2021),
                new Automobile("KMHD74LF6KU123456", "Hyundai", "Elantra", "Silver", 2023),
                new Automobile("5XXGT4L34HG123456", "Kia", "Optima", "Black", 2018),
                new Automobile("3KPF24AD4LE123456", "Kia", "Forte", "White", 2020),
                new Automobile("4S3BNAF63H3012345", "Subaru", "Legacy", "Gray", 2022),
                new Automobile("JF1GPAL68E8223456", "Subaru", "Impreza", "Blue", 2017),
                new Automobile("3VW2B7AJ5HM123456", "Volkswagen", "Jetta", "Red", 2021),
                new Automobile("1VWAT7A30EC123456", "Volkswagen", "Passat", "White", 2016),
                new Automobile("JM1BM1W36E1123456", "Mazda", "3", "Black", 2019),
                new Automobile("JM1GJ1V55G1234567", "Mazda", "6", "Silver", 2020),
                new Automobile("WBA3A5C56DF123456", "BMW", "3 Series", "Blue", 2022),
                new Automobile("WDDGF8AB1DR123456", "Mercedes", "C-Class", "Gray", 2023),
                new Automobile("WAUAFAFL1GN123456", "Audi", "A4", "Black", 2021),
                new Automobile("5YJ3E1EA7KF123456", "Tesla", "Model 3", "White", 2023),
                new Automobile("58ABK1GG6LU123456", "Lexus", "ES", "Red", 2020),
                new Automobile("19UUB1F31FA123456", "Acura", "TLX", "Silver", 2018),
                new Automobile("JN1BV7AR5FM123456", "Infiniti", "Q50", "Black", 2017),
                new Automobile("YV1612FS9G1234567", "Volvo", "S60", "Gray", 2019),
                new Automobile("2G4GS5GX3E9123456", "Buick", "Regal", "White", 2016),
                new Automobile("1C3CCCAB1FN123456", "Chrysler", "200", "Beige", 2015)
        );
        automobileRepository.saveAll(autos);
        System.out.println("Initialized 30 test automobiles with realistic VINs.");
    }
}
