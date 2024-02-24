package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.User;
import tech.ada.onlinelibrary.dto.UserPostRequest;
import tech.ada.onlinelibrary.repository.UserRepository;
import tech.ada.onlinelibrary.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

  
    private UserRepository userRepository;

    private UserService userService;

    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping ("/user")
    public ResponseEntity <List<User>> getAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userLogin) {
        boolean authenticated = userService.authenticateUser(userLogin.getUsername(), userLogin.getUserPassword());
        if (authenticated) {
            return ResponseEntity.ok().build(); // Authenticated
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Authentication failed
        }
    }
    @PostMapping("/user/register")
        public ResponseEntity<User> createUser (@RequestBody UserPostRequest userRequest){
            User user = modelMapper.map(userRequest, User.class);
            User newUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }

    @PutMapping("user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value="user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}