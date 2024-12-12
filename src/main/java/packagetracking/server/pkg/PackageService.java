package packagetracking.server.pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packagetracking.server.courier.Courier;
import packagetracking.server.courier.CourierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private CourierRepository courierRepository;

    public Package create(Package myPackage) {
        return packageRepository.save(myPackage);
    }

    public List<Package> findAll() {
        return packageRepository.findAll();
    }

    public Package findById(int id) {
        return packageRepository.findById(id).orElse(null);
    }

    public Package update(int id, Package updatedPackage) {
        return packageRepository.findById(id)
                .map(existingPackage -> {
                    if (updatedPackage.getStatus() != null) {
                        existingPackage.setStatus(updatedPackage.getStatus());
                    }
                    if (updatedPackage.getDeliveryAddress() != null) {
                        existingPackage.setDeliveryAddress(updatedPackage.getDeliveryAddress());
                    }
                    if (updatedPackage.getId() != null) {
                        existingPackage.setId(updatedPackage.getId());
                    }
                    if (updatedPackage.getCourier() != null) {
                        existingPackage.setCourier(updatedPackage.getCourier());
                    }
                    if (updatedPackage.getCreatedOn() != null) {
                        existingPackage.setCreatedOn(updatedPackage.getCreatedOn());
                    }
                    return packageRepository.save(existingPackage);
                })
                .orElse(null);
    }

    public void delete(int id) {
        packageRepository.deleteById(id);
    }
    public List<Package> findUnassignedPackages() {
        return packageRepository.findAll()
                .stream()
                .filter(pkg -> pkg.getCourier() == null)
                .toList();
    }

    public boolean assignPackageToCourier(Long packageId, Long courierId) {
        Optional<Package> optionalPackage = packageRepository.findById(Math.toIntExact(packageId));
        Optional<Courier> optionalCourier = courierRepository.findById(courierId);

        if (optionalPackage.isPresent() && optionalCourier.isPresent()) {
            Package pkg = optionalPackage.get();
            Courier courier = optionalCourier.get();

            pkg.setCourier(courier);
            pkg.setStatus(PackageStatus.PENDING);

            packageRepository.save(pkg);
            return true;
        }

        return false;
    }
    public boolean setDeliveredPackage(Long packageId){
        Optional<Package> optionalPackage = packageRepository.findById(Math.toIntExact(packageId));

        if (optionalPackage.isPresent()) {
            Package pkg = optionalPackage.get();
            pkg.setStatus(PackageStatus.DELIVERED);
            packageRepository.save(pkg);
            return true;
        }

        return false;
    }

    public Package adPackage(int id, Package addedPackage) {
        return packageRepository.findById(id)
            .map(existingPackage -> {
                if (addedPackage.getStatus() != null) {
                    existingPackage.setStatus(PackageStatus.NEW);
                }
                if (addedPackage.getDeliveryAddress() != null) {
                    existingPackage.setDeliveryAddress(addedPackage.getDeliveryAddress());
                }
                if (addedPackage.getId() != null) {
                    existingPackage.setId(addedPackage.getId());
                }
                if (addedPackage.getCourier() != null) {
                    existingPackage.setCourier(addedPackage.getCourier());
                }
                if (addedPackage.getCreatedOn() != null) {
                    existingPackage.setCreatedOn(addedPackage.getCreatedOn());
                }
                return packageRepository.save(existingPackage);
            })
            .orElse(null);
    }
}

