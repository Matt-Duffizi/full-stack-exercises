package it.unikey.uniapp.PL.mapper.impl;

import it.unikey.uniapp.BLL.DTO.EmployeeDTO;
import it.unikey.uniapp.PL.mapper.general.GeneralRestMapper;
import it.unikey.uniapp.PL.rest.EmployeeRest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeRestMapper extends GeneralRestMapper<EmployeeDTO, EmployeeRest> {
}
