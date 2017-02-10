package br.com.filipe.persistence;

import br.com.filipe.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {

}
