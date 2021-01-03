package springboot.vehicles.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
public class Brand extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;
    @OneToMany(mappedBy = "brand")
    private Set<Model> models;
}
