package com.management.school.service;

import java.util.List;
import com.management.school.entity.TeacherBO;

public interface TeacherService {
    TeacherBO addTeacher(TeacherBO teacher);
    TeacherBO updateTeacher(TeacherBO teacher);
    void deleteTeacher(Integer id);
    TeacherBO getTeacherById(Integer id);
    List<TeacherBO> getAllTeachers();
    void assignSubjectToTeacher(Integer teacherId, Integer subjectId);
}
