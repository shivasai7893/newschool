package com.management.school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.school.dao.TeacherDao;
import com.management.school.dao.SubjectDao;
import com.management.school.entity.TeacherBO;
import com.management.school.entity.SubjectBO;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public TeacherBO addTeacher(TeacherBO teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public TeacherBO updateTeacher(TeacherBO teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherDao.deleteById(id.longValue());
    }

    @Override
    public TeacherBO getTeacherById(Integer id) {
        return teacherDao.findById(id.longValue()).orElse(null);
    }

    @Override
    public List<TeacherBO> getAllTeachers() {
        return teacherDao.findAll();
    }

    @Override
    public void assignSubjectToTeacher(Integer teacherId, Integer subjectId) {
        TeacherBO teacher = teacherDao.findById(teacherId.longValue()).orElseThrow();
        SubjectBO subject = subjectDao.findById(subjectId.longValue()).orElseThrow();

        teacher.getSubjects().add(subject);
        teacherDao.save(teacher);
    }
}
