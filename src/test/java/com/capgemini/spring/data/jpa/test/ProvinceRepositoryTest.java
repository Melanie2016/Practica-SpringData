
package com.capgemini.spring.data.jpa.test;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.spring.data.jpa.entities.jpa.CountryEntity;
import com.capgemini.spring.data.jpa.entities.jpa.ProvinceEntity;
import com.capgemini.spring.data.jpa.repositories.jpa.ICountryRepository;
import com.capgemini.spring.data.jpa.repositories.jpa.IProvinceRepository;


@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ProvinceRepositoryTest {


    @Autowired
    private ICountryRepository   repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;


    private final Logger logger = LoggerFactory.getLogger (ProvinceRepositoryTest.class);


    public ProvinceRepositoryTest () {

        super ();
    }


    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf (1), "ar", "Argentina"),
                new CountryEntity (Integer.valueOf (2), "ve", "Venezuela")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity (Integer.valueOf (1), "Buenos Aires", countries[0]),
                new ProvinceEntity (Integer.valueOf (2), "Cordoba", countries[0]),
                new ProvinceEntity (Integer.valueOf (3), "Caracas", countries[1]),
                new ProvinceEntity (Integer.valueOf (4), "Miranda", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (countries)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));
    }

    @Test
    public void testGetAllByCountry () {

        logger.info ("Getting provinces...");

        CountryEntity c = new CountryEntity ();
        c.setId (Integer.valueOf (1));

        List<ProvinceEntity> list = this.repositoryProvince.findAllByCountryOrderByNameDesc (c);

        Assert.assertNotNull ("There are provinces...", list);
        Assert.assertFalse ("There are provinces...",list.isEmpty ());
    }
}