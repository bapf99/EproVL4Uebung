package de.thbingen.epro.web;

import de.thbingen.epro.objects.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SpringService {

    ArrayList<User> users = new ArrayList<User>();

    @PostMapping(value = "/users/set", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addUser(@RequestBody(required = true) User user){
        if(users.add(user)){
            return 200;
        }else{
            return 415;
        }
    }

    @GetMapping(value = "/users/get/{id}")
    public User getUserByIndex(@PathVariable int id) {
        User user = users.get(id);
        return user;
    }

    @GetMapping(value = "/users/getAll")
    public ArrayList<User> getUsers() {
        return users;
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public int deleteUser(@PathVariable int id) {
        User removedUser = users.remove(id);
        if(removedUser != null) {
            return 200;
        } else {
            return 204;
        }
    }

}
