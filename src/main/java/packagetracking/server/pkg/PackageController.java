
package packagetracking.server.pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import packagetracking.server.courier.CourierService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/package")
    public Package create(@RequestBody Package myPackage) {
        return packageService.create(myPackage);
    }

    @GetMapping("/package")
    public List<Package> getAllPackages() {
        return packageService.findAll();
    }

    @GetMapping("/package/{id}")
    public Package getPackageById(@PathVariable int id) {
        return packageService.findById(id);
    }

    @PutMapping("/package/{id}")
    public Package updatePackage(@PathVariable int id, @RequestBody Package updatedPackage) {
        return packageService.update(id, updatedPackage);
    }
    @PutMapping("/package/add/{id}")
    public Package adPackage(@PathVariable int id, @RequestBody Package addedPackage) {
        return packageService.adPackage(id, addedPackage);
    }
    @DeleteMapping("/package/{id}")
    public void deletePackage(@PathVariable int id) {
        packageService.delete(id);
    }

    @GetMapping("/package/unassigned")
    public List<Package> getUnassignedPackages() {
        return packageService.findUnassignedPackages();
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/package/assign/{id}")
    public ResponseEntity<String> assignPackage(@PathVariable Long id, @RequestParam Long courierId) {
        try {
            boolean isAssigned = packageService.assignPackageToCourier(id, courierId);
            if (isAssigned) {
                return ResponseEntity.ok("Package successfully assigned to courier.");
            } else {
                return ResponseEntity.badRequest().body("Failed to assign package. Check the IDs provided.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
    @PutMapping("/package/deliver/{id}")
    public ResponseEntity<String> markAsDelivered(@PathVariable Long id) {
        try {
            boolean isDelivered = packageService.setDeliveredPackage(id);
            if (isDelivered) {
                return ResponseEntity.ok("Package marked as delivered.");
            } else {
                return ResponseEntity.badRequest().body("Failed to mark package as delivered. Check the package ID.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}


