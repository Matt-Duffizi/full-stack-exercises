package it.unikey.uniapp.BLL.service.general;

import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import it.unikey.uniapp.BLL.DTO.EmployeeDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface EmployeeService extends CrudService<EmployeeDTO>{

    List<EmployeeDTO> getListByDepartmentId(Integer id) throws EntityNotFoundException;
}
