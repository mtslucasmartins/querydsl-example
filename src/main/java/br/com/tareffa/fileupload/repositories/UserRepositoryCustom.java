package br.com.tareffa.fileupload.repositories;

import br.com.tareffa.fileupload.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryCustom {

    List<User> findUsersByEmail(String email);

    List<User> findUsersByEmail(String email, Integer pageSize, Integer pageIndex);

}
