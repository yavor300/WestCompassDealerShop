package springboot.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.vehicles.domain.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Model findByName(String model);
}
