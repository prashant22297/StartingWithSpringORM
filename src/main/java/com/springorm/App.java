package com.springorm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(78,"Prashant","Mau");
//        int r = studentDao.insert(student);
//        System.out.println("Inserted row: "+r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go) {
            System.out.println("PRESS 1 to add new student.");
            System.out.println("PRESS 2 to display all student.");
            System.out.println("PRESS 3 to get details of single student.");
            System.out.println("PRESS 4 to delete one student.");
            System.out.println("PRESS 5 to delete all student.");
            System.out.println("PRESS 6 to update student.");
            System.out.println("PRESS 7 to exit.");

            try {
                int input = Integer.parseInt(br.readLine());
                switch (input) {
                    case 1: {
//                        Add a new student
                        System.out.println("Enter Student ID: ");
                        int s_id = Integer.parseInt(br.readLine());
                        System.out.println("Enter Student Name:");
                        String s_name = br.readLine();
                        System.out.println("Enter Student Address:");
                        String s_add = br.readLine();
                        Student student = new Student(s_id, s_name, s_add);
                        System.out.println(studentDao.insert(student));
                        break;
                    }
                    case 2:
//                        Display all student
                        for (Student s : studentDao.getAllStudents()) {
                            System.out.println(s.getStudentId() + " " + s.getStudentName() + " " + s.getStudentCity());
                        }
                        break;
                    case 3: {
//                        get single student
                        System.out.println("Enter Student ID to display the details: ");
                        int s_id = Integer.parseInt(br.readLine());
                        Student s = studentDao.getStudent(s_id);
                        System.out.println(s.getStudentId() + " " + s.getStudentName() + " " + s.getStudentCity());
                        break;
                    }
                    case 4: {
//                        delete one student
                        System.out.println("Enter Student ID to delete: ");
                        int s_id = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(s_id);
                        System.out.println("Student Delete Success for "+s_id);
                        break;
                    }
                    case 5: {
//                        delete all student
                        studentDao.deleteAllStudents();
                        System.out.println("All Students are deleted.");
                        break;
                    }
                    case 6: {
//                        update student

                        break;
                    }
                    case 7:
//                        exit
                        go = false;
                        System.out.println("Bye! Thank You!!");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Invalid Input: Try with another one!!!");
                System.out.println(e.getMessage());
            }
        }
    }
}
