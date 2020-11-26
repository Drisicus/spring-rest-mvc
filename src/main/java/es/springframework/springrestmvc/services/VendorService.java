package es.springframework.springrestmvc.services;

import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.api.v1.model.VendorListDTO;

import java.util.List;

public interface VendorService {
    VendorListDTO getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);
    void deleteVendorById(Long id);
}
