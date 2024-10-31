package packagetracking.pkg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Integer> {

    @Query("SELECT p FROM Package p WHERE p.courier.id = :courierId")
    List<Package> findByCourierId(@Param("courierId") Long courierId);
}
