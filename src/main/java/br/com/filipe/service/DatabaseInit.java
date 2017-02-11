package br.com.filipe.service;

import br.com.filipe.model.Departament;
import br.com.filipe.model.User;
import br.com.filipe.util.JsonImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Component
public class DatabaseInit implements ApplicationListener<ContextRefreshedEvent> {

    public DatabaseInit() {
    }

    @Autowired
    protected DepartamentService departamentService;

    @Autowired
    protected UserService userService;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
            List<Departament> departaments = JsonImport.getEntityList("departament", Departament.class);
            if (departaments != null) {
                for (final Departament departam : departaments) {
                    Departament departamentDB = departamentService.findByName(departam.getName());

                    if (departamentDB == null) {
                        departamentService.saveUpdate(departam);
                    }
                }
            }

            List<User> users = JsonImport.getEntityList("user", User.class);
            if (users != null) {
                for (final User user : users) {
                    User userDB = userService.findByName(user.getName());
                    Departament departamentDB = departamentService.findByName(user.getDepartament().getName());

                    if (departamentDB != null && userDB == null) {
                        user.setDepartament(departamentDB);
                        userService.saveUpdate(user);
                    }
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
