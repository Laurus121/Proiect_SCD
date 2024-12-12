package packagetracking.server.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(
            value = "SELECT DISTINCT c.* \n" +
                    "        FROM courier c\n" +
                    "        WHERE NOT EXISTS (\n" +
                    "            SELECT 1 \n" +
                    "            FROM package p \n" +
                    "            WHERE p.courier_id = c.id AND p.status = 1\n" +
                    "        )",
            nativeQuery = true
    )
    List<Courier> findCouriersWithoutPendingPackages();

    @Query(value = "SELECT manager.name AS manager_name, COUNT(p.id) AS delivered_count " +
            "FROM courier AS manager " +
            "LEFT JOIN courier AS courier ON manager.id = courier.manager_id " +
            "LEFT JOIN package AS p ON courier.id = p.courier_id " +
            "WHERE p.status = 2 " +
            "GROUP BY manager.name",
            nativeQuery = true)
    List<Object[]> findManagersAndDeliveredNumber();
}

