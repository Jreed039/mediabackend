package com.social.media.services;
import com.social.media.models.User;
import com.social.media.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
*The Service contains the application's business logic
*/
@Service
public class UsersService {
 
    @Autowired
    private UsersRepo userRepository;
 
    public User saveUser(User user) {
        return userRepository.save(user);
    }
 
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
 
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
 
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
 
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
 
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
 
}
 