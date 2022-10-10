package it.unikey.uniapp.PL.rest;

import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRest {
    private Integer id;
    private String name;
    private String surname;
    private Date date;
    private DepartmentDTO department;
}
