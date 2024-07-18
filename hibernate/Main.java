package com.working_with_hibernate.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo cấu hình Hibernate và xây dựng SessionFactory
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Mở phiên làm việc
        Session session = sessionFactory.openSession();

        // Bắt đầu giao dịch
        session.beginTransaction();

        // Truy vấn HQL để lấy tất cả sinh viên
        String hql = "FROM Student";
        Query<Student> query = session.createQuery(hql, Student.class);
        List<Student> students = query.list();

        // In ra danh sách các sinh viên
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
        }

        // Truy vấn HQL để lấy sinh viên đăng ký vào khóa học cụ thể
        hql = "SELECT s FROM Student s JOIN s.courses c WHERE c.title = :courseTitle";
        query = session.createQuery(hql, Student.class);
        query.setParameter("courseTitle", "Mathematics");
        students = query.list();

        // In ra danh sách sinh viên đăng ký khóa học "Mathematics"
        for (Student student : students) {
            System.out.println("Student in Mathematics: " + student.getName());
        }

        // Hoàn tất giao dịch
        session.getTransaction().commit();

        // Đóng phiên làm việc
        session.close();
    }
}

