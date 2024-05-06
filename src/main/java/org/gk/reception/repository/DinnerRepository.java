package org.gk.reception.repository;

import org.gk.reception.model.Dinner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DinnerRepository extends MongoRepository<Dinner, String>{
}
