package br.com.tareffa.fileupload.controllers;

import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/users"})
public class UserController {
//

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<User>> findUsers() throws Exception {
        return ResponseEntity.ok(userRepository.findUsersByEmail("lucas@ottimizza.com.br"));
    }

    @GetMapping(path = {"/2"})
    public ResponseEntity<String> findUsers2() throws Exception {
        return ResponseEntity.ok("OK");
    }
//
//    @GetMapping(path = {"/by_email"})
//    public ResponseEntity<List<User>> findUsersByEmail() throws Exception {
//        return ResponseEntity.ok(userRepository.findAll());
//    }

}
