package com.management.school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.school.dao.DepartmentDao;
import com.management.school.dao.TeacherDao;
import com.management.school.entity.DepartmentBO;
import com.management.school.entity.TeacherBO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public DepartmentBO addDepartment(DepartmentBO department) {
        return departmentDao.save(department);
    }

    @Override
    public DepartmentBO updateDepartment(DepartmentBO department) {
        return departmentDao.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentDao.deleteById(id.longValue());
    }

    @Override
    public DepartmentBO getDepartmentById(Integer id) {
        return departmentDao.findById(id.longValue()).orElse(null);
    }

    @Override
    public List<DepartmentBO> getAllDepartments() {
        return departmentDao.findAll();
    }

    @Override
    public void assignHeadToDepartment(Integer departmentId, Integer teacherId) {
        DepartmentBO department = departmentDao.findById(departmentId.longValue()).orElseThrow();
        TeacherBO teacher = teacherDao.findById(teacherId.longValue()).orElseThrow();

        department.setHead(teacher);
        departmentDao.save(department);
    }
}
