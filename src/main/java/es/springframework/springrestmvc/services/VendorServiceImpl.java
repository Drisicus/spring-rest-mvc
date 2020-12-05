package es.springframework.springrestmvc.services;

import es.springframework.springrestmvc.api.v1.mapper.VendorMapper;
import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.api.v1.model.VendorListDTO;
import es.springframework.springrestmvc.domain.Vendor;
import es.springframework.springrestmvc.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    VendorMapper vendorMapper;
    VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorRepository.findAll().stream().map(vendorMapper::vendorToVendorDTO).collect(Collectors.toList()));
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id).map(vendorMapper::vendorToVendorDTO).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);
        return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            Optional.ofNullable(vendorDTO.getName()).ifPresent(vendor::setName);
            return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }
}
