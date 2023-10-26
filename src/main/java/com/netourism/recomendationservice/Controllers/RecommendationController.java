package com.netourism.recomendationservice.Controllers;

import com.netourism.recomendationservice.Models.Hobby;
import com.netourism.recomendationservice.Models.User;
import com.netourism.recomendationservice.Repositories.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
@Autowired
    private HobbyRepository hobbyRepository;
@GetMapping("/get")
    public List<Hobby> getAllHobbies(){
    return hobbyRepository.findAll();
}
@PostMapping("/add")
    public Hobby addHobby(@RequestBody Hobby a){
    hobbyRepository.save(a);
    return a;
}
@GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteHobby(@PathVariable(value = "id") Long id){
    hobbyRepository.deleteById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
}

@GetMapping("/{hobbyId}/users")
public List<User> getUsersForHobby(@PathVariable(value="hobbyId") Long hobbyId) {
    Hobby hobby = hobbyRepository.findById(hobbyId).orElse(null);
    if (hobby != null) {
        return hobby.getPracticers();
    } else {
            return Collections.emptyList(); // Or return an appropriate response.
    }
}


@GetMapping("/users/{hobbyTitle}")
public List<User> getUsersForHobby(@PathVariable("hobbyTitle") String title) {
    Hobby hobby = hobbyRepository.findByTitle(title);
    if (hobby != null){
            return hobby.getPracticers();
    } else {
            return Collections.emptyList(); // Or return an appropriate response.
    }
    }



    @GetMapping("/hobbies/{userId}")
    public List<Hobby> getHobbiesForUser(@PathVariable Long userId) {
        List<Hobby> hobbies = hobbyRepository.findHobbiesByUserId(userId);
        return hobbies;
    }

}
