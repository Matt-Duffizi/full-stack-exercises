package it.unikey.uniapp.BLL.DTO;

import it.unikey.uniapp.DAL.Entity.DepartmentEntity;
import lombok.Data;
import java.util.Date;

@Data
public class EmployeeDTO {

    private Integer id;
    private String name;
    private String surname;
    private Date date;
    private DepartmentDTO department;
}
