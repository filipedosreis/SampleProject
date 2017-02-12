package br.com.filipe.control;

import br.com.filipe.model.Departament;
import br.com.filipe.service.DepartamentService;
import br.com.filipe.util.ProjetotErroBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by filipedosreis@gmail.com on 09/02/2017.
 */
@Controller
public class DepartamentController {

    @Autowired
    protected DepartamentService departamentService;

    @RequestMapping(value = "/departament/list", method = RequestMethod.POST)
    public @ResponseBody List<Departament> listAll() {
        return departamentService.listAll();
    }

    @RequestMapping(value = "/departament/save", method = RequestMethod.POST)
    public @ResponseBody Departament save(@RequestBody Departament departament) {
        return departamentService.saveUpdate(departament);
    }

    @RequestMapping(value = "/departament/update", method = RequestMethod.POST)
    public @ResponseBody Departament update(@RequestBody Departament departament) {
        return departamentService.saveUpdate(departament);
    }

    @RequestMapping(value = "/departament/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestBody Departament departament) {
        departamentService.delete(departament);
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ProjetotErroBean handleException(DataIntegrityViolationException e) {
        ProjetotErroBean erro = new ProjetotErroBean(0, e.getMessage());
        return erro;
    }
}
