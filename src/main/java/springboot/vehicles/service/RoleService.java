package springboot.vehicles.service;

import springboot.vehicles.domain.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {
    void seedRolesInDb();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String role);
}
