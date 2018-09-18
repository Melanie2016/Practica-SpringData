

package com.capgemini.spring.data.jpa.repositories.jpa;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.spring.data.jpa.entities.jpa.CountryEntity;
import com.capgemini.spring.data.jpa.entities.jpa.ProvinceEntity;


@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {


    List<ProvinceEntity> findAllByCountryOrderByNameDesc (CountryEntity country);
}