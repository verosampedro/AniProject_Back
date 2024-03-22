package dev.verosampedro.aniproject.users;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import dev.verosampedro.aniproject.roles.Role;
import dev.verosampedro.aniproject.requests.Request;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    @OneToMany(mappedBy = "assignedUser", cascade = CascadeType.ALL)
    @JsonBackReference // Añade esta anotación aquí
    private List<Request> requests = new ArrayList<>();

    // ** un Role puede tener muchos User, pero cada User tiene un único Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonManagedReference 
    private Role role;
        
    public User() {
    }
    
    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;  
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return hasRole("ROLE_ADMIN");
    }
    
    public boolean isUser() {
        return hasRole("ROLE_USER");
    }
    
    private boolean hasRole(String name) {
        return this.role.getName().equals(name);
    }
    
    public void assignRole(Role role) {
        this.role = role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void editProfile(String newUsername, String newPassword, String newEmail) {
        if (newUsername != null && !newUsername.isEmpty()) {
            this.username = newUsername;
        }
        if (newPassword != null && !newPassword.isEmpty()) {
            this.password = newPassword;
        }
        if (newEmail != null && !newEmail.isEmpty()) {
            this.email = newEmail;
        }
    }
}