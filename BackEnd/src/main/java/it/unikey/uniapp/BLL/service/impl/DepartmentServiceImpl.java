package it.unikey.uniapp.BLL.service.impl;

import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import it.unikey.uniapp.BLL.mapper.impl.DepartmentMapper;
import it.unikey.uniapp.BLL.service.general.DepartmentService;
import it.unikey.uniapp.DAL.Entity.DepartmentEntity;
import it.unikey.uniapp.DAL.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDTO insert(DepartmentDTO dto) {
        DepartmentEntity departmentToSave= mapper.fromDtoToEntity(dto);
        DepartmentEntity departmentSaved= repository.save(departmentToSave);
        return mapper.fromEntityToDto(departmentSaved);
    }

    @Override
    public DepartmentDTO getById(Integer id) throws EntityNotFoundException {
        DepartmentEntity departmentEntity= repository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        return mapper.fromEntityToDto(departmentEntity);
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<DepartmentEntity> departmentEntityList= repository.findAll();
        return mapper.fromEntityListToDtoList(departmentEntityList);
    }

    @Override
    public DepartmentDTO update(DepartmentDTO dto) throws EntityNotFoundException {
        DepartmentEntity departmentEntity= repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(departmentEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!repository.existsById(id))
            throw new EntityNotFoundException();
        repository.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> getByName(String name) throws EntityNotFoundException {
        if(!repository.existsDepartmentEntityByName(name))
            throw new EntityNotFoundException("Entity DEPARTMENT not found in DB");
        return mapper.fromEntityListToDtoList(repository.findDepartmentEntityByName(name));
    }


}

