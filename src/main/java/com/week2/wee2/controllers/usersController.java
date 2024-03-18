package com.week2.wee2.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class usersController {

    // implement methods

//    @GetMapping()
//    public String getUsers() {
//        return "HTTP get request was sent";
//
//    }

    // query parameters
    @GetMapping()
    public String getUsers(@RequestParam(value = "page") int pageNum, @RequestParam(value = "limit") int limitNum) {
        return "HTTP get request was sent for page " + pageNum + " and limit is " + limitNum;
        // curl -X GET -H "Content-Type: application/json" 'http://localhost:8080/users?page=1&limit=10'
    }

    @GetMapping(path = "/{userID}")  // path parameters
    public String getUser(@PathVariable String userID) {
        return "HTTP get request was sent for user id " + userID;

    }


    @PostMapping
    public String createUsers() {
        return "HTTP post request was sent";

    }

    @PutMapping
    public String updateUsers() {
        return "HTTP put request was sent";

    }

    @DeleteMapping
    public String deleteUsers() {
        return "HTTP delete request was sent";

    }

}
