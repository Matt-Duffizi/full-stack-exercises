package it.unikey.uniapp.BLL.mapper.impl;

import it.unikey.uniapp.BLL.DTO.EmployeeDTO;
import it.unikey.uniapp.BLL.mapper.general.GeneralMapper;
import it.unikey.uniapp.DAL.Entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GeneralMapper<EmployeeEntity, EmployeeDTO> {
}

