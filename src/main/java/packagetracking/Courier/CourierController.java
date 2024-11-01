package packagetracking.Courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import packagetracking.pkg.Package;

import java.util.List;

@RestController
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping("/courier")
    public Courier create(@RequestBody Courier courier) {
        return courierService.create(courier);
    }

    @GetMapping("/courier")
    public List<Courier> getAllCouriers() {
        return courierService.findAll();
    }

    @GetMapping("/courier/{id}")
    public Courier getCourierById(@PathVariable Long id) {
        return courierService.findById(id);
    }

    @PutMapping("/courier/{id}")
    public Courier update(@PathVariable Long id, @RequestBody Courier updatedcourier) {
        return courierService.update(id, updatedcourier);
    }

    @DeleteMapping("/courier/{id}")
    public void delete(@PathVariable Long id) {
        courierService.delete(id);
    }

    @GetMapping("/courier/{id}/packages")
    public List<Package> getPackagesForCourier(@PathVariable Long id) {
        return courierService.getPackagesForCourier(id);
    }

    @GetMapping("/couriers/withoutPendingPackages")
    public List<Courier> getAllCouriersWithoutPendingPackages() {
        return courierService.getAllCouriersWithoutPendingPackages();
    }
}
