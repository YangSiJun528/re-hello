package dev.yangsijun.rehello.test_inheritance;

import org.springframework.data.repository.CrudRepository;

public interface AbstractUserRepository extends CrudRepository<AbstractUser, Long> {
}
