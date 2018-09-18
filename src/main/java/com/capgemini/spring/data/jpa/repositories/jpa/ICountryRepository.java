
package com.capgemini.spring.data.jpa.repositories.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.spring.data.jpa.entities.jpa.CountryEntity;



@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, Integer> {


    CountryEntity findOneByCode (String code);

    List<CountryEntity> findAllByIdBetween (Integer start, Integer end);

    List<CountryEntity> findAllByIdGreaterThan (Integer value);

    @Query ("FROM Country c WHERE c.id < :id")
    List<CountryEntity> findAllByIdIsLessThan2 (@Param ("id") Integer value);

    @Query (value = "SELECT * FROM country WHERE cou_name LIKE ?1",
            nativeQuery = true)
    List<CountryEntity> findAllByName (String val);
}