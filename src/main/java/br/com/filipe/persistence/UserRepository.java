package br.com.filipe.persistence;

import br.com.filipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(name = "User.findByName")
    User findByName(String userName);

}
