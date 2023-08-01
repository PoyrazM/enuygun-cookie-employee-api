package com.enuygun.enuyguncookieemployeeapi.mapper;

import com.enuygun.enuyguncookieemployeeapi.dto.request.EmployeeRequest;
import com.enuygun.enuyguncookieemployeeapi.dto.response.EmployeeResponse;
import com.enuygun.enuyguncookieemployeeapi.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    IEmployeeMapper MAP = Mappers.getMapper(IEmployeeMapper.class);
    EmployeeResponse entityToDto(Employee employee);
    Employee dtoToEntity(EmployeeRequest request);
    List<EmployeeResponse> entityListToDtoList(List<Employee> employees);
    void updateDtoToEntity(EmployeeRequest request, @MappingTarget Employee employee);
}


