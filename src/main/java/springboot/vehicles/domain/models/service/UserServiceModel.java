package springboot.vehicles.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {
    private String username;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Set<RoleServiceModel> roles;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Set<OfferServiceModel> offers;
}
