package it.unikey.uniapp.BLL.DTO;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DepartmentDTO {

    private Integer id;
    private String name;
    private String tel;
    private String address;

}
