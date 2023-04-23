package com.cardwell.MagMutualTest.repository;

import com.cardwell.MagMutualTest.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findByProfession(String profession);

    List<User> findByDateCreatedBetween(Date startDate, Date endDate);

    Optional<User> findById(int id);
}