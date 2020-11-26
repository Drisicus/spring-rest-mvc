package es.springframework.springrestmvc.services;

import es.springframework.springrestmvc.api.v1.mapper.VendorMapper;
import es.springframework.springrestmvc.api.v1.model.VendorDTO;
import es.springframework.springrestmvc.api.v1.model.VendorListDTO;
import es.springframework.springrestmvc.domain.Vendor;
import es.springframework.springrestmvc.repositories.VendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VendorServiceImplTest {

    public static final String NAME_1 = "My Vendor";
    public static final long ID_1 = 1L;
    public static final String NAME_2 = "My Vendor";
    public static final long ID_2 = 1L;

    @Mock
    VendorRepository vendorRepository;

    @Autowired
    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    VendorService vendorService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(vendorMapper, vendorRepository);
    }

    @Test
    public void getVendorById() throws Exception {
        //given
        Vendor vendor = getVendor1();

        //mockito BDD syntax
        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());

        //JUnit Assert that with matchers
        assertEquals(vendorDTO.getName(), NAME_1);
    }


    @Test
    public void getVendorByIdNotFound() throws Exception {
        //given
        //mockito BBD syntax since mockito 1.10.0
        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());

        //when
        assertThrows(ResourceNotFoundException.class, () -> vendorService.getVendorById(1L));

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
    }

    @Test
    public void getAllVendors() throws Exception {
        //given
        List<Vendor> vendors = Arrays.asList(getVendor1(), getVendor2());
        given(vendorRepository.findAll()).willReturn(vendors);

        //when
        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        //then
        then(vendorRepository).should(times(1)).findAll();
        assertEquals(vendorListDTO.getVendors().size(), 2);
    }

    @Test
    public void createNewVendor() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when
        VendorDTO savedVendorDTO = vendorService.createNewVendor(vendorDTO);

        //then
        // 'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        assertTrue(savedVendorDTO.getVendorUrl().contains("1"));

    }

    @Test
    public void saveVendorByDTO() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when
        VendorDTO savedVendorDTO = vendorService.saveVendorByDTO(ID_1, vendorDTO);

        //then
        // 'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        assertTrue(savedVendorDTO.getVendorUrl().contains("1"));
    }

    @Test
    public void patchVendor() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));
        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when

        VendorDTO savedVendorDTO = vendorService.patchVendor(ID_1, vendorDTO);

        //then
        // 'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        then(vendorRepository).should(times(1)).findById(anyLong());
        assertTrue(savedVendorDTO.getVendorUrl().contains("1"));
    }

    @Test
    public void deleteVendorById() throws Exception {

        //when
        vendorService.deleteVendorById(1L);

        //then
        then(vendorRepository).should().deleteById(anyLong());
    }

    private Vendor getVendor1() {
        Vendor vendor = new Vendor();
        vendor.setName(NAME_1);
        vendor.setId(ID_1);
        return vendor;
    }

    private Vendor getVendor2() {
        Vendor vendor = new Vendor();
        vendor.setName(NAME_2);
        vendor.setId(ID_2);
        return vendor;
    }

}