package dev.yangsijun.rehello.test_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("BIKE_USER")
public class BikeUser extends AbstractUser {

    private String carUser;

    public BikeUser(Long id, String name, Bike bike, String carUser) {
        super(id, name, bike);
        this.carUser = carUser;
    }

}
