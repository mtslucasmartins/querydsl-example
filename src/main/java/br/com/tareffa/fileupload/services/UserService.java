package br.com.tareffa.fileupload.services;

import br.com.tareffa.fileupload.models.User;
import br.com.tareffa.fileupload.repositories.user.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(Integer pageSize, Integer pageIndex) throws Exception {
        return userRepository.findAll(pageSize, pageIndex);
    }

    public Optional<User> findById(Long id) throws Exception {
        return userRepository.findById(id);
    }

}
