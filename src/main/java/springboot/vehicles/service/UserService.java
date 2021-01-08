package springboot.vehicles.service;

import springboot.vehicles.domain.models.service.UserServiceModel;

import java.util.Set;

public interface UserService {
    UserServiceModel register(UserServiceModel model);

    Set<UserServiceModel> getAll();

    UserServiceModel getByUsername(String username);
}
