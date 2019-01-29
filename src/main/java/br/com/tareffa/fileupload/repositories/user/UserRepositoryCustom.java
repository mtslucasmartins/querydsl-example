package br.com.tareffa.fileupload.repositories.user;

import java.util.List;

import br.com.tareffa.fileupload.models.User;

public interface UserRepositoryCustom {

	List<User> findAll(Integer pageSize, Integer pageIndex);

    List<User> findUsersByEmail(String email);

    List<User> findUsersByEmail(String email, Integer pageSize, Integer pageIndex);

}
