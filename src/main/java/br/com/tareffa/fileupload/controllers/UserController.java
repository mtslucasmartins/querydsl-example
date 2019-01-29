package br.com.tareffa.fileupload.controllers;

import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.repositories.user.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/users"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = {""})
    public ResponseEntity<List<User>> findUsers(
            @RequestParam("page_size") Integer pageSize,
            @RequestParam("page_index") Integer pageIndex) throws Exception {
        return ResponseEntity.ok(userRepository.findAll(pageSize, pageIndex));
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userRepository.findById(id));
    }

}
