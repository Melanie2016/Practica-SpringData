
package com.capgemini.spring.data.jpa.repositories.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.spring.data.jpa.entities.jpa.CityEntity;


@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {



   CityEntity findOneCityEntityByName(String name);

   @Query (value = "FROM City c LEFT JOIN Province p ON c.id = :id ")
   List<CityEntity> findAllCitiesByProvinceEntities(@Param ("id") Integer value);





}