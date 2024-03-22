package dev.verosampedro.aniproject.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u.group.id FROM User u WHERE u.id = :userId")
    Long findGroupIdByUserId(@Param("userId") Long userId);
}
