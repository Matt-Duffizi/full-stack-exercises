package it.unikey.uniapp.PL.mapper.impl;

import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import it.unikey.uniapp.PL.mapper.general.GeneralRestMapper;
import it.unikey.uniapp.PL.rest.DepartmentRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DepartmentRestMapper extends GeneralRestMapper<DepartmentDTO, DepartmentRest> {
}

