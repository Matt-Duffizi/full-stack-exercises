package it.unikey.uniapp.BLL.mapper.impl;


import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import it.unikey.uniapp.BLL.mapper.general.GeneralMapper;
import it.unikey.uniapp.DAL.Entity.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GeneralMapper<DepartmentEntity, DepartmentDTO> {
}
