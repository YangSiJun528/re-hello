# 중첩 상속 엔티티 구현 테스트

## 개요
원서 도메인 설계하다가 궁금해져서 테스트

상위 객체 자체를 상속 방식으로 구현하고,   
구현체에서 특정 하위 엔티티 구현체를 가지는 구조가 가능한지 테스트 

## 객체 설명

- **Vehicle**: 추상클래스, 하위 엔티티 역할
  - **Car**, **Bike**: 구현체, 다른 필드를 가진다.


- **AbstractUser**: 추상클래스, 상위 엔티티 역할
  - **CarUser**: 구현체, Vehicle 대신 Car를 받는 생성자 사용
  - **BikeUser**: 구현체, Vehicle 대신 Bike를 받는 생성자 사용 

## 전략에 따른 테이블 구조

### `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`

둘 다 `SINGLE_TABLE` 전략 사용

#### AbstractUser
```sql
CREATE TABLE `abstract_user`
(
    `id`         bigint      NOT NULL AUTO_INCREMENT,
    `vehicle_id` bigint       DEFAULT NULL,
    `user_type`  varchar(31) NOT NULL,
    `car_user`   varchar(255) DEFAULT NULL,
    `name`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `FKld7oeb1jagpgaiidthvdra7xj` (`vehicle_id`),
    CONSTRAINT `FKld7oeb1jagpgaiidthvdra7xj` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
)
```

#### Vehicle
```sql
CREATE TABLE `vehicle`
(
    `has_basket`      bit(1)       DEFAULT NULL,
    `number_of_doors` int          DEFAULT NULL,
    `id`              bigint      NOT NULL AUTO_INCREMENT,
    `vehicle_type`    varchar(31) NOT NULL,
    `brand`           varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
```

구현이 잘 되는 모습 확인


### @Inheritance(strategy = InheritanceType.JOINED)

마찬가지로 둘 다 `JOINED` 전략 사용
#### tables
```shell
mysql> show tables;
+----------------------+
| Tables_in_mydatabase |
+----------------------+
| abstract_user        |
| bike                 |
| bike_user            |
| car                  |
| car_user             |
| vehicle              |
+----------------------+
```

#### AbstractUser

```sql
CREATE TABLE `abstract_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_id` bigint DEFAULT NULL,
  `user_type` varchar(31) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKld7oeb1jagpgaiidthvdra7xj` (`vehicle_id`),
  CONSTRAINT `FKld7oeb1jagpgaiidthvdra7xj` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
)
```

```sql
CREATE TABLE `bike_user`
(
    `id`       bigint NOT NULL,
    `car_user` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FKkci45up6o86s5lglbavki5n64` FOREIGN KEY (`id`) REFERENCES `abstract_user` (`id`)
)
```

```sql
CREATE TABLE `car_user`
(
    `id`       bigint NOT NULL,
    `car_user` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK2wxlacufcvjxby8ba2mtj9ulq` FOREIGN KEY (`id`) REFERENCES `abstract_user` (`id`)
) 
```

#### Vehicle
```sql
CREATE TABLE `vehicle`
(
    `id`           bigint      NOT NULL AUTO_INCREMENT,
    `vehicle_type` varchar(31) NOT NULL,
    `brand`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
```

```sql
CREATE TABLE `bike` (
  `has_basket` bit(1) NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKhxs9llvku7xtxhblfh2410b2p` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`)
)
```

```sql
CREATE TABLE `car` (
  `number_of_doors` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKfugwdpykh9kb35q1quro44hrm` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`)
)
```

## 테스트 방법
1. [TestCommandLineRunner](TestCommandLineRunner.java) 주석 제거
2. 디버깅해서 저장, 조회 잘 되는거 확인
