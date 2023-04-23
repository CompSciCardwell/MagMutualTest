package com.cardwell.MagMutualTest.controller;

import com.cardwell.MagMutualTest.model.User;
import com.cardwell.MagMutualTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // CREATE operation
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // READ operations
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/name")
    public ResponseEntity<List<User>> getUsersByName(@RequestParam("firstName") String firstName,
                                                     @RequestParam("lastName") String lastName) {
        List<User> users = userRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/profession")
    public ResponseEntity<List<User>> getUsersByProfession(@RequestParam("profession") String profession) {
        List<User> users = userRepository.findByProfessionIgnoreCase(profession);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/date-range")
    public ResponseEntity<List<User>> getUsersByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<User> users = userRepository.findByDateCreatedBetween(startDate, endDate);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE operation
    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setProfession(user.getProfession());
            existingUser.setCountry(user.getCountry());
            existingUser.setCity(user.getCity());
            existingUser.setDateCreated(user.getDateCreated());

            User updatedUser = userRepository.save(existingUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/byLocation")
    public List<User> getUsersByLocation(@RequestParam(required = false) String city,
                                         @RequestParam(required = false) String country) {
        if (city != null) {
            return userRepository.findByCityIgnoreCase(city);
        } else if (country != null) {
            return userRepository.findByCountryIgnoreCase(country);
        } else {
            throw new IllegalArgumentException("Either city or country must be provided.");
        }
    }

}