package br.com.tareffa.fileupload.controllers;

import org.springframework.http.HttpStatus;
import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.services.UserService;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.tareffa.fileupload.exceptions.ResourceNotFoundException;
import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Inject
	UserService userService;

	@GetMapping()
	public ResponseEntity<List<User>> findUsers(@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer pageIndex) throws Exception {
		try {
			return ResponseEntity.ok(userService.findAll(pageSize, pageIndex));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) throws Exception {
		try {
			return ResponseEntity.ok(userService.findById(id));
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
