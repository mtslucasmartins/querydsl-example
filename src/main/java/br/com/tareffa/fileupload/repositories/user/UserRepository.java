package br.com.tareffa.fileupload.repositories.user;

import br.com.tareffa.fileupload.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
