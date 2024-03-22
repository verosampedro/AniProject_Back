package dev.verosampedro.aniproject.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.verosampedro.aniproject.roles.Role;
import dev.verosampedro.aniproject.roles.RoleRepository;
import io.micrometer.common.lang.NonNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
 
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
    return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User save(@NonNull User type) {
        User newUser = new User();

        userRepository.save(newUser);
        return newUser;
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    // Establece el rol de admin:
    public void setRoleToUser(User user) {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRole(adminRole);        
    }
}