package nl.remco.novi.backend.eindopdracht.into_art.repository;

import nl.remco.novi.backend.eindopdracht.into_art.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsernameIs(String username);
}
