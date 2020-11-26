package es.springframework.springrestmvc.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    public Long id;
    public String name;
    public String vendorUrl;

    public VendorDTO(String name, String vendorUrl) {
        this.name = name;
        this.vendorUrl = vendorUrl;
    }
}
