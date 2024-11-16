package com.management.school.service;

import java.util.List;
import com.management.school.entity.SubjectBO;

public interface SubjectService {
    SubjectBO addSubject(SubjectBO subject);
    SubjectBO updateSubject(SubjectBO subject);
    void deleteSubject(Integer id);
    SubjectBO getSubjectById(Integer id);
    List<SubjectBO> getAllSubjects();
    void assignTeacherToSubject(Integer subjectId, Integer teacherId);
    void enrollStudentInSubject(Integer subjectId, Integer studentId);
}
