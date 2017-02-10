package br.com.filipe.control;

import br.com.filipe.model.Departament;
import br.com.filipe.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public void listAll(@RequestBody Departament departament) {
        departamentService.delete(departament);
    }
}
