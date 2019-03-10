package br.com.tareffa.fileupload.services;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import br.com.tareffa.fileupload.enums.Errors;
import br.com.tareffa.fileupload.exceptions.ResourceNotFoundException;
import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.repositories.user.UserRepository;

@Service
public class UserService {

  UserRepository userRepository;
	
  public List<User> findAll(Integer pageSize, Integer pageIndex) throws Exception {
		return userRepository.findAll(pageSize, pageIndex);
	}

	public User findById(Long id) throws ResourceNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow(() -> new ResourceNotFoundException(Errors.USER_NOT_FOUND));
	}

}
