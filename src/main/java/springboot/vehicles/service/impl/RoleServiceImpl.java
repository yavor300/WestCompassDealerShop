package springboot.vehicles.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.vehicles.domain.entities.Role;
import springboot.vehicles.domain.models.service.RoleServiceModel;
import springboot.vehicles.repository.RoleRepository;
import springboot.vehicles.service.RoleService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRolesInDb() {
        if (this.roleRepository.count() == 0){
            this.roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
            this.roleRepository.saveAndFlush(new Role("ROLE_BUYER"));
            this.roleRepository.saveAndFlush(new Role("ROLE_SELLER"));
        }
    }

    @Override
    public Set<RoleServiceModel> findAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RoleServiceModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RoleServiceModel findByAuthority(String role) {
        return modelMapper.map(roleRepository.findByAuthority(role), RoleServiceModel.class);
    }
}
