package com.management.school.service;

import java.util.List;
import com.management.school.entity.DepartmentBO;

public interface DepartmentService {
    DepartmentBO addDepartment(DepartmentBO department);
    DepartmentBO updateDepartment(DepartmentBO department);
    void deleteDepartment(Integer id);
    DepartmentBO getDepartmentById(Integer id);
    List<DepartmentBO> getAllDepartments();
    void assignHeadToDepartment(Integer departmentId, Integer teacherId);
}
