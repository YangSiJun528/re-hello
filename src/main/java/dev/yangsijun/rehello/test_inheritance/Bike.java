package dev.yangsijun.rehello.test_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("BIKE")
public class Bike extends Vehicle {

    private boolean hasBasket;

    public Bike(Long id, String brand, boolean hasBasket) {
        super(id, brand);
        this.hasBasket = hasBasket;
    }
}
