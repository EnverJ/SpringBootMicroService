package com.week2.wee2.services;

import com.week2.wee2.beans.Country;
import com.week2.wee2.controllers.AddResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component  // permit access to  @Autowire
public class CountrySservice {
    static HashMap<Integer, Country> countryIdMap;

    public CountrySservice() {
        countryIdMap = new HashMap<Integer, Country>();
        Country indiaCountry = new Country(1, "India", "Delhi");
        Country EastTurkistanCountry = new Country(2, "EastTurkistan", "Urumqi");
        Country ukCountry = new Country(3, "UK", "London");

        countryIdMap.put(1, indiaCountry);
        countryIdMap.put(2, EastTurkistanCountry);
        countryIdMap.put(3, ukCountry);
    }

    public List getAllCountries() {
        List countries = new ArrayList(countryIdMap.values());
        return countries;
    }

    public Country sgetCountryById(int id) {
        Country country = countryIdMap.get(id);
        return country;
    }

    public Country getCountryByName(String countryName) {
        Country country = null;
        for (int i : countryIdMap.keySet()) {
            if (countryIdMap.get(i).getCountryName().equals(countryName)) {
                country = countryIdMap.get(i);
            }
        }
        return country;
    }

    public Country addCountry(Country country) {

        country.setId(getMaxId());
        countryIdMap.put(country.getId(), country);
        return country;
    }
    // utility method to get max id

    public static int getMaxId() {
        int max = 0;
        for (int id : countryIdMap.keySet()) {
            if (max <= id) {
                max = id;
            }
        }
        return max + 1;
    }

    public Country updateCountry(Country country) {
        if (country.getId() > 0) {
            countryIdMap.put(country.getId(), country);
        }
        return country;
    }

    public AddResponse deleteCountry(int id) {
        countryIdMap.remove(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMsg("Country deleted...");
        addResponse.setId(id);
        return addResponse;
    }

}
