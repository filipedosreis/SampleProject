package br.com.filipe.service;

import br.com.filipe.model.Departament;
import br.com.filipe.persistence.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public List<Departament> listAll() {
        return departamentRepository.findAll();
    }

    public Departament saveUpdate(Departament departament) {
        return departamentRepository.save(departament);
    }

    public void delete(Departament departament) {
        departamentRepository.delete(departament);
    }

    Departament findByName(String departamentName) {
        return departamentRepository.findByName(departamentName);
    }

}
