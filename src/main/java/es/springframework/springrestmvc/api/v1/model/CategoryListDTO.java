package es.springframework.springrestmvc.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    List<CategoryDTO> categories;
}
