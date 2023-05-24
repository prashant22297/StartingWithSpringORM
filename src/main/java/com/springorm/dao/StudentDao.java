package com.springorm.dao;

import com.springorm.entities.Student;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class StudentDao {


    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student){
//        Insert
        return (int) this.hibernateTemplate.save(student);
    }

//    get a single object
    public Student getStudent(int studentId){
        return this.hibernateTemplate.get(Student.class,studentId);
    }

//    get multiple / ALL data
    public List<Student> getAllStudents(){
        return this.hibernateTemplate.loadAll(Student.class);
    }

//    Deleting one student
    @Transactional
    public void deleteStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }

//    deleting all student
    @Transactional
    public void deleteAllStudents(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        this.hibernateTemplate.deleteAll(students);
    }
    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
