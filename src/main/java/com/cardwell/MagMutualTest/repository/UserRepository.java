package com.cardwell.MagMutualTest.repository;

import com.cardwell.MagMutualTest.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    List<User> findByProfessionIgnoreCase(String profession);

    List<User> findByDateCreatedBetween(Date startDate, Date endDate);

    Optional<User> findById(int id);

    List<User> findByCountryIgnoreCase(String country);

    List<User> findByCityIgnoreCase(String city);
}