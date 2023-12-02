package dev.yangsijun.rehello.test_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CAR_USER")
public class CarUser extends AbstractUser {

    private String carUser;

    public CarUser(Long id, String name, Car car, String carUser) {
        super(id, name, car);
        this.carUser = carUser;
    }
}
