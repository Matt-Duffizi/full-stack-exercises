package it.unikey.uniapp.BLL.service.general;



import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import org.webjars.NotFoundException;
import java.util.List;

public interface DepartmentService extends CrudService<DepartmentDTO>{

    List<DepartmentDTO> getByName(String name) throws NotFoundException;
}
