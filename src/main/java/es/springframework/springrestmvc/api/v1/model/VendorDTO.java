package es.springframework.springrestmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    public Long id;

    @ApiModelProperty(value = "Name of the vendor", required = true)
    public String name;
    public String vendorUrl;

    public VendorDTO(String name, String vendorUrl) {
        this.name = name;
        this.vendorUrl = vendorUrl;
    }
}
