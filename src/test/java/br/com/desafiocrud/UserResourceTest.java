package br.com.desafiocrud;

import br.com.desafiocrud.domain.User;
import br.com.desafiocrud.service.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserResourceTest extends JerseyTest {
    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(UserResource.class);
    }

    @Test
    public void testGetAll() {
        List<User> users = target("/user").request().get(List.class);
        assertTrue("Should return user list", users.size() > 0);

        Response response = target("/user").request().get();
        assertEquals("Http response should be 200", Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void testUserGetById(){
        final String json = target("/user/18").request().get(String.class);
        assertEquals("Should be equal json", "{\"id\":18,\"login\":\"test@gmail.com\",\"name\":\"Test18\",\"pass\":\"f5c3dd7514bf620a1b85450d2ae374b1\"}", json);

        User user = target("/user/18").request().get(User.class);
        assertEquals("Should return id 18", Long.valueOf(18), user.getId());
    }

    @Test
    public void testCreateUser() {
        Response response = target("/user").request()
                .post(Entity.json("{\"name\":\"UserTest\",\"login\":\"usertest@test.com\",\"pass\":\"usertest123\"}"));
        assertEquals("Http response should be 200", Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testUpdateUser() {
        User user = target("/user/22").request().get(User.class);
        System.out.println("actual: " + user.getLogin());
        user.setLogin("test22@test.com");

        Response response = target("user/22").request()
                .put(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));

        assertEquals("Http response should be 200", Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
