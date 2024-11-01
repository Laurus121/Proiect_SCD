package packagetracking.Courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packagetracking.pkg.Package;
import packagetracking.pkg.PackageRepository;

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

    public Courier update(Long id, Courier updatedcourier) {
        return courierRepository.findById(id).map(existingCourier -> {
            if (updatedcourier.getName() != null) {
                existingCourier.setName(updatedcourier.getName());
            }
            if (updatedcourier.getId() != null) {
                existingCourier.setId(updatedcourier.getId());
            }
            if (updatedcourier.getEmail() != null) {
                existingCourier.setEmail(updatedcourier.getEmail());
            }
            if (updatedcourier.getManager() != null && updatedcourier.getManager().getId() != null) {
                Optional<Courier> manager = courierRepository.findById(Long.valueOf(updatedcourier.getManager().getId()));
                manager.ifPresent(existingCourier::setManager);
            }
            return courierRepository.save(existingCourier);
        }).orElse(null);
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
}
