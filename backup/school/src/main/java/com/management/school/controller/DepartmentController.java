package com.management.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.management.school.entity.DepartmentBO;
import com.management.school.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentBO> addDepartment(@RequestBody DepartmentBO department) {
        DepartmentBO newDepartment = departmentService.addDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentBO> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentBO department) {
        department.setId(id);
        DepartmentBO updatedDepartment = departmentService.updateDepartment(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentBO> getDepartmentById(@PathVariable Integer id) {
        DepartmentBO department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentBO>> getAllDepartments() {
        List<DepartmentBO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PostMapping("/{departmentId}/assign-head/{teacherId}")
    public ResponseEntity<Void> assignHeadToDepartment(@PathVariable Integer departmentId, @PathVariable Integer teacherId) {
        departmentService.assignHeadToDepartment(departmentId, teacherId);
        return ResponseEntity.ok().build();
    }
}
