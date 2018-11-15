package br.com.desafiocrud.service;

import br.com.desafiocrud.domain.User;
import br.com.desafiocrud.domain.dto.UserCreateResponseDTO;
import br.com.desafiocrud.domain.dto.UserDeleteResponseDTO;
import br.com.desafiocrud.domain.dto.UserGetResponseDTO;
import br.com.desafiocrud.domain.dto.UserUpdateResponseDTO;
import br.com.desafiocrud.repository.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "user" path)
 */
@Path("user")
public class UserResource {

    private UserRepository userRepository;
    public UserResource() {
        userRepository = new UserRepository();
    }

    /**
     * Create user
     * @param user
     * @return UserCreateResponseDTO
     */
    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public UserCreateResponseDTO create(User user) {
        User userSaved = userRepository.create(user);
        return new UserCreateResponseDTO(userSaved).build();
    }

    /**
     * Get user
     * @param id
     * @return UserGetResponseDTO
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserGetResponseDTO get(@PathParam("id") Long id) {
        User user = userRepository.find(id);
        return new UserGetResponseDTO(user).build();
    }

    /**
     * Update user
     * @param id
     * @param user
     * @return UserUpdateResponseDTO
     */
    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserUpdateResponseDTO update(@PathParam("id") Long id, User user) {
        user.setId(id);
        User userUpdated = null;
        if (userRepository.find(id) != null) {
            userUpdated = userRepository.update(user);
        }
        return new UserUpdateResponseDTO(userUpdated).build();
    }

    /**
     * Delete user
     * @param id
     * @return UserDeleteResponseDTO
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDeleteResponseDTO delete(@PathParam("id") Long id) {
        User userDeleted = userRepository.find(id);
        if (userDeleted != null) {
            userRepository.delete(userDeleted);
        }
        return new UserDeleteResponseDTO(userDeleted).build();
    }

    /**
      * @return all users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public List<UserGetResponseDTO> all() {
        List<UserGetResponseDTO> usersResponse = new ArrayList<>();
        List<User> users = userRepository.findAll();
        if (userRepository.findAll() != null) {
            for (User user : users) {
                usersResponse.add(new UserGetResponseDTO(user).build());
            }
        }
        return usersResponse;
    }
}
