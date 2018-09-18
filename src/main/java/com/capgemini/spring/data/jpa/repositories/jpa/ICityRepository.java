
package com.capgemini.spring.data.jpa.repositories.jpa;


import com.capgemini.spring.data.jpa.entities.jpa.CountryEntity;
import com.capgemini.spring.data.jpa.entities.jpa.ProvinceEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.spring.data.jpa.entities.jpa.CityEntity;

import java.util.List;


@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {



   CityEntity findOneCityEntityByName(String name);

//   List<CityEntity> findAllCitiesByProvinceEntities(ProvinceEntity province);





}