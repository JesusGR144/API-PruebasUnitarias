package com.jjgr.store_demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // POST
    public void addUser(User user) {
        Optional<User> userIsPresent = userRepository.findByEmail(user.getEmail());

        if (userIsPresent.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }

        userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Long id) {
        boolean userExists = new UserRepository.existsById(id);
        if(userExists){
            throw new IllegalStateException("User wjith id "+id+"does not exist");
        }
        userRepository.deleteById(id);
    }
}
