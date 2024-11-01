package packagetracking.Courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(
            value = "SELECT c.* FROM courier c JOIN package p on c.id=p.courier_id WHERE p.status != 'PENDING'\n",
            nativeQuery = true)
    List<Courier> findCouriersWithoutPendingPackages();

    @Query(value = "SELECT c.manager.name, COUNT(p.id) FROM Package p JOIN p.courier c WHERE p.status = 'DELIVERED' GROUP BY c.manager.name", nativeQuery = true)
    List<Object[]> findManagersAndDeliveredNumber();
}

