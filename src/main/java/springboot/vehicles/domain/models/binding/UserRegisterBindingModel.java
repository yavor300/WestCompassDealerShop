package springboot.vehicles.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
}
