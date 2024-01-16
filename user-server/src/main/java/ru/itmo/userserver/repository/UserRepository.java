package ru.itmo.userserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.userserver.model.User;
;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String userName);
    Optional<User> findUserById(UUID id);

    boolean existsByUsername(String username);
}
