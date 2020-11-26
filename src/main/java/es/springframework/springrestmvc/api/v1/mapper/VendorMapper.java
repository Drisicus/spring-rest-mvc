package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.domain.Vendor;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(VendorMapperDecorator.class)
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDtoToVendor(VendorDTO vendorDTO);
}
