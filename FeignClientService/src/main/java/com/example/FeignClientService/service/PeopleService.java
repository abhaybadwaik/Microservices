package com.example.FeignClientService.service;

import com.example.FeignClientService.model.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    private final List<People> peopleList = new ArrayList<>();

    public People registerPeople(People people){
        peopleList.add(people);
        return people;
    }

    public List<People> getPeople(){
        return peopleList;
    }
}
