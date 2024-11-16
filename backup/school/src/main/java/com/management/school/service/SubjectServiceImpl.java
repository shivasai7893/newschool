package com.management.school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.school.dao.SubjectDao;
import com.management.school.dao.TeacherDao;
import com.management.school.dao.StudentDao;
import com.management.school.entity.SubjectBO;
import com.management.school.entity.TeacherBO;
import com.management.school.entity.StudentBO;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public SubjectBO addSubject(SubjectBO subject) {
        return subjectDao.save(subject);
    }

    @Override
    public SubjectBO updateSubject(SubjectBO subject) {
        return subjectDao.save(subject);
    }

    @Override
    public void deleteSubject(Integer id) {
        subjectDao.deleteById(id.longValue());
    }

    @Override
    public SubjectBO getSubjectById(Integer id) {
        return subjectDao.findById(id.longValue()).orElse(null);
    }

    @Override
    public List<SubjectBO> getAllSubjects() {
        return subjectDao.findAll();
    }

    @Override
    public void assignTeacherToSubject(Integer subjectId, Integer teacherId) {
        SubjectBO subject = subjectDao.findById(subjectId.longValue()).orElseThrow();
        TeacherBO teacher = teacherDao.findById(teacherId.longValue()).orElseThrow();

        subject.setTeacher(teacher);
        subjectDao.save(subject);
    }

    @Override
    public void enrollStudentInSubject(Integer subjectId, Integer studentId) {
        SubjectBO subject = subjectDao.findById(subjectId.longValue()).orElseThrow();
        StudentBO student = studentDao.findById(studentId.longValue()).orElseThrow();

        subject.getStudents().add(student);
        subjectDao.save(subject);
    }
}
