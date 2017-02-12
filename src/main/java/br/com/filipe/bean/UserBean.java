package br.com.filipe.bean;

import br.com.filipe.model.Departament;
import br.com.filipe.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.util.List;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@ManagedBean(name="userBean")
@ViewScoped
public class UserBean {

    private List<User> users;
    private List<Departament> departaments;
    private User selectedUser = new User();

    @PostConstruct
    public void init() {
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/rest/user/list");

        ClientResponse response = wr.type("application/json").post(ClientResponse.class, null);
        String json = response.getEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List registros = null;
        try {
            registros = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        users = registros;

        // Retrieve departaments
        wr = c.resource("http://localhost:8080/rest/departament/list");
        response = wr.type("application/json").post(ClientResponse.class, null);
        json = response.getEntity(String.class);

        mapper = new ObjectMapper();
        registros = null;
        try {
            registros = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Departament.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        departaments = registros;
    }

    public void save(){
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/rest/user/save");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ClientResponse response = null;

        try {
            String json = ow.writeValueAsString(selectedUser);
            response = wr.type("application/json").post(ClientResponse.class, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
            addMessage("Generic Error. Please try again.");
            return;
        }

        init();
        addMessage("Succes operation");
    }

    public void delete(){
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/rest/user/delete");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ClientResponse response = null;

        try {
            String json = ow.writeValueAsString(selectedUser);
            response = wr.type("application/json").post(ClientResponse.class, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
            addMessage("Generic Error. Please try again.");
            return;
        }

        init();
        addMessage("Record deleted!");
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Departament> getDepartaments() {
        return departaments;
    }

    public User getSelectedUser() {
        if(selectedUser.getDepartament() == null) {
            selectedUser.setDepartament(new Departament());
        }

        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
            this.selectedUser = selectedUser;
    }

    public void reset(ActionEvent event) {
        this.selectedUser = new User();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
