package com.management.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.management.school.entity.TeacherBO;
import com.management.school.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherBO> addTeacher(@RequestBody TeacherBO teacher) {
        TeacherBO newTeacher = teacherService.addTeacher(teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherBO> updateTeacher(@PathVariable Integer id, @RequestBody TeacherBO teacher) {
        teacher.setId(id);
        TeacherBO updatedTeacher = teacherService.updateTeacher(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherBO> getTeacherById(@PathVariable Integer id) {
        TeacherBO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<TeacherBO>> getAllTeachers() {
        List<TeacherBO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping("/{teacherId}/assign/{subjectId}")
    public ResponseEntity<Void> assignSubjectToTeacher(@PathVariable Integer teacherId, @PathVariable Integer subjectId) {
        teacherService.assignSubjectToTeacher(teacherId, subjectId);
        return ResponseEntity.ok().build();
    }
}
