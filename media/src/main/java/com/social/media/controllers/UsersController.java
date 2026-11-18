package com.social.media.controllers;
import com.social.media.models.User;
import com.social.media.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import com.social.media.repos.UsersRepo;

/**
* The controller contains the applications endpoints/ urls.
* UserController handles HTTP requests concerning users.
*/

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/users")
public class UsersController {
 
    @Autowired
    private UsersService userService;
 
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user){
       User savedUser = userService.saveUser(user);
       return ResponseEntity.ok(savedUser);
    }
 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        Optional<User> existingUser = userService.getUserByUsername(user.getUsername());
 
        if(existingUser.isEmpty()){
            return ResponseEntity.status(401).body("Invalid username or password");
        }
 
        User storedUser = existingUser.get();
 
        if(!storedUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.status(401).body("Invalid username or password");
        }
 
        return ResponseEntity.ok("Login successful");
    }
 
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
 
}
