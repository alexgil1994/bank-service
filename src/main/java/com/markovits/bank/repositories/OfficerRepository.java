package com.markovits.bank.repositories;

import com.markovits.bank.domain.Officer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends CrudRepository<Officer, Long> {

    Optional<Officer> findById(Long id);



}
