package com.enuygun.enuyguncookieemployeeapi.mapper;

import com.enuygun.enuyguncookieemployeeapi.dto.request.EmployeeRequest;
import com.enuygun.enuyguncookieemployeeapi.dto.response.EmployeeResponse;
import com.enuygun.enuyguncookieemployeeapi.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    IEmployeeMapper MAP = Mappers.getMapper(IEmployeeMapper.class);
    EmployeeResponse entityToDto(Employee employee);
    Employee dtoToEntity(EmployeeRequest request);
    void updateDtoToEntity(EmployeeRequest request, @MappingTarget Employee employee);
}


