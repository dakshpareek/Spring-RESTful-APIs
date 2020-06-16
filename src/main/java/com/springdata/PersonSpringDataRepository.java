package com.springdata;

import com.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
