package com.management.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.management.school.entity.SubjectBO;
import com.management.school.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectBO> addSubject(@RequestBody SubjectBO subject) {
        SubjectBO newSubject = subjectService.addSubject(subject);
        return ResponseEntity.ok(newSubject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectBO> updateSubject(@PathVariable Integer id, @RequestBody SubjectBO subject) {
        subject.setId(id);
        SubjectBO updatedSubject = subjectService.updateSubject(subject);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectBO> getSubjectById(@PathVariable Integer id) {
        SubjectBO subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping
    public ResponseEntity<List<SubjectBO>> getAllSubjects() {
        List<SubjectBO> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @PostMapping("/{subjectId}/assign-teacher/{teacherId}")
    public ResponseEntity<Void> assignTeacherToSubject(@PathVariable Integer subjectId, @PathVariable Integer teacherId) {
        subjectService.assignTeacherToSubject(subjectId, teacherId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{subjectId}/enroll-student/{studentId}")
    public ResponseEntity<Void> enrollStudentInSubject(@PathVariable Integer subjectId, @PathVariable Integer studentId) {
        subjectService.enrollStudentInSubject(subjectId, studentId);
        return ResponseEntity.ok().build();
    }
}
