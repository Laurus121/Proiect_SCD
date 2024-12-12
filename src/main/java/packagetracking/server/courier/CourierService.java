package packagetracking.server.courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packagetracking.server.pkg.Package;
import packagetracking.server.pkg.PackageRepository;
import packagetracking.server.pkg.PackageStatus;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private PackageRepository packageRepository;

    public Courier create(Courier courier) {
        return courierRepository.save(courier);
    }

    public List<Courier> findAll() {
        return courierRepository.findAll();
    }

    public Courier findById(Long id) {
        return courierRepository.findById(id).orElse(null);
    }

    public Courier update(Long id, Courier updatedCourier) {
        Optional<Courier> existingCourier = courierRepository.findById(id);
        if (existingCourier.isPresent()) {
            Courier courier = existingCourier.get();
            courier.setName(updatedCourier.getName());
            courier.setManager(updatedCourier.getManager());
            return courierRepository.save(courier);
        }
        return null;
    }

    public void delete(Long id) {
        courierRepository.deleteById(id);
    }

    public List<Package> getPackagesForCourier(Long courierId) {
        return packageRepository.findByCourierId(courierId);
    }

    public List<Courier> getAllCouriersWithoutPendingPackages() {
        return courierRepository.findCouriersWithoutPendingPackages();
    }

    public List<ManagerDeliveredStats> getManagersAndDeliveredNumber() {
        List<Object[]> rawData = courierRepository.findManagersAndDeliveredNumber();
        return rawData.stream().map(data -> new ManagerDeliveredStats((String) data[0], ((Number) data[1]).intValue())).toList();
    }

    public Package assignToCourier(Integer packageId, Long courierId) {
        Package pkg = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));
        Courier courier = courierRepository.findById(courierId)
                .orElseThrow(() -> new RuntimeException("Courier not found"));

        pkg.setCourier(courier);
        pkg.setStatus(PackageStatus.PENDING);
        return packageRepository.save(pkg);
    }
}