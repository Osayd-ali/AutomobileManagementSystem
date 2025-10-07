package edu.ali.automobile_api.repositories;

import edu.ali.automobile_api.entities.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile,Long> {
    Automobile findByVin(String vin);

    List<Automobile> findByMake(String make);

    List<Automobile> findByModel(String model);

    List<Automobile> findByColor(String color);

    List<Automobile> findByYear(int year);

    List<Automobile> findByYearBetween(int startYear, int endYear);

    boolean existsByVin(String vin);
}
