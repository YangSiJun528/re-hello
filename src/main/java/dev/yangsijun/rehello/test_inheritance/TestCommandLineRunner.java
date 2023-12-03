package dev.yangsijun.rehello.test_inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * 테스트코드로 테스트하고 싶었는데,
 * Docker Compose Support 사용하면서 테스트코드가 안돌아감
 * 찾아볼 정도로 중요한건 아니라 CommandLineRunner로 돌림
 */
@Component
public class TestCommandLineRunner implements CommandLineRunner {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AbstractUserRepository abstractUserRepository;

    @Override
    public void run(String... args) {
//        vehicleRepository.deleteAll();
//        abstractUserRepository.deleteAll();
//        creatTest();
//        var vehicles = vehicleRepository.findAll();
//        var abstractUsers = abstractUserRepository.findAll();
//        System.out.println(vehicles);
//        System.out.println(abstractUsers);
    }

    public void creatTest() {

        try {
            // Bike 엔티티 생성 및 저장
            Bike bike = new Bike(1L, "Schwinn", true);
            vehicleRepository.save(bike);

            // BikeUser 엔티티 생성 및 저장
            BikeUser bikeUser = new BikeUser(1L, "BikeUser1", bike, "BikeUser2-A");
            abstractUserRepository.save(bikeUser);

            // Car 엔티티 생성 및 저장
            Car car = new Car(2L, "Toyota", 4);
            vehicleRepository.save(car);

            // CarUser 엔티티 생성 및 저장
            CarUser carUser = new CarUser(2L, "CarUser1", car, "CarUser1-A");
            abstractUserRepository.save(carUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
