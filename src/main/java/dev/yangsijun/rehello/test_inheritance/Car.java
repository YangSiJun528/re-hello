package dev.yangsijun.rehello.test_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    @NonNull
    private int numberOfDoors;

    public Car(Long id, String brand, int numberOfDoors) {
        super(id, brand);
        this.numberOfDoors = numberOfDoors;
    }
}
