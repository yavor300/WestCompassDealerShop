package springboot.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.vehicles.domain.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
}
