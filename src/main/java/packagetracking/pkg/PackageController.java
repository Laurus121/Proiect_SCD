package packagetracking.pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/package/{id}")
    public void deletePackage(@PathVariable int id) {
        packageService.delete(id);
    }
}
