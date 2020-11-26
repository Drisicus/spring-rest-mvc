package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.controllers.VendorController;
import es.springframework.springrestmvc.domain.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class VendorMapperDecorator implements VendorMapper {
    @Autowired
    @Qualifier("delegate")
    private VendorMapper delegate;

    @Override
    public VendorDTO vendorToVendorDTO(Vendor vendor) {
        VendorDTO vendorDTO = delegate.vendorToVendorDTO(vendor);
        vendorDTO.setVendorUrl(VendorController.BASE_URL + "/" + vendor.getId());
        return vendorDTO;
    }

}
