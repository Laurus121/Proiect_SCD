package packagetracking.pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

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
}
