package it.unikey.uniapp.BLL.service.impl;

import it.unikey.uniapp.BLL.DTO.EmployeeDTO;
import it.unikey.uniapp.BLL.mapper.impl.EmployeeMapper;
import it.unikey.uniapp.BLL.service.general.EmployeeService;
import it.unikey.uniapp.DAL.Entity.EmployeeEntity;
import it.unikey.uniapp.DAL.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDTO insert(EmployeeDTO dto) {
        EmployeeEntity employeeToSave= mapper.fromDtoToEntity(dto);
        EmployeeEntity employeeSaved= repository.save(employeeToSave);
        return mapper.fromEntityToDto(employeeSaved);
    }

    @Override
    public EmployeeDTO getById(Integer id) throws EntityNotFoundException {
        EmployeeEntity employeeEntity= repository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        return mapper.fromEntityToDto(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeEntity> employeeEntityList= repository.findAll();
        return mapper.fromEntityListToDtoList(employeeEntityList);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO dto) throws EntityNotFoundException {
        EmployeeEntity EmployeeEntity= repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(EmployeeEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!repository.existsById(id))
            throw new EntityNotFoundException();
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getListByDepartmentId(Integer id) throws EntityNotFoundException {
        if(!repository.existsEmployeeEntitiesByDepartmentId(id))
            throw new EntityNotFoundException("Entity Department not valid");
        return mapper.fromEntityListToDtoList(repository.findAllByDepartmentId(id));
    }
}
