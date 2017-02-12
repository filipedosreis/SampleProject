package br.com.filipe.control;

import br.com.filipe.model.User;
import br.com.filipe.service.UserService;
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
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public @ResponseBody
    List<User> listAll() {
        return userService.listAll();
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public @ResponseBody User save(@RequestBody User departament) {
        return userService.saveUpdate(departament);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public @ResponseBody
    User update(@RequestBody User departament) {
        return userService.saveUpdate(departament);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestBody User departament) {
        userService.delete(departament);
    }
}
