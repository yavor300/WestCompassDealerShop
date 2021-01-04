package springboot.vehicles.service;

import springboot.vehicles.domain.models.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel model);
}
