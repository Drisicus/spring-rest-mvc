package es.springframework.springrestmvc.controllers;

import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.api.v1.model.VendorListDTO;
import es.springframework.springrestmvc.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
    public static final String BASE_URL = "/api/v1/vendors";

    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getVendors(){
        return vendorService.getAllVendors();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendor(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO postVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createNewVendor(vendorDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        vendorService.deleteVendorById(id);
    }

}
