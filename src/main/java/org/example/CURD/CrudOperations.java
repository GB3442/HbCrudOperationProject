package org.example.CURD;

import org.example.RequiredResources.Resources;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Scanner;

public class CrudOperations {
    private Resources resource=new Resources();


    // for inserting student object into database
    public String addStudent(Student s){
        String message = "";
        Session session = resource.getSessionObject();
        Transaction tx = session.beginTransaction();

        try {
            if (s != null) {
                if (session.save(s) != null) {
                    tx.commit();
                    message = "Student is saved successfully with id : " + s.getSid();

                    System.out.println(s.getSname() + " " + s.getMarks());
                } else {
                    message = "Problem in insertion!!!";
                }
            } else {
                System.out.println("Student object is null!!!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(session.isOpen()){
                session.close();

            }
            resource.close();
        }
        return message;

    }
    // for Updating student object into database
    public String updateStudent(int id){
        String message = "";

        Session session = resource.getSessionObject();
        Transaction tx = session.beginTransaction();

        try {
             Scanner sc=new Scanner(System.in);
            Student s1=session.get(Student.class,id);
             if(s1!=null) {
                 System.out.println("Enter new Name : ");
                 String name=sc.next();
                 System.out.println("Enter new marks : ");
                 Double marks=sc.nextDouble();
                 s1.setSname(name);
                 s1.setMarks(marks);
                 session.saveOrUpdate(s1);
                 message = "Student is updated successfully with id : " + s1.getSid();
                 tx.commit();
             }
             else {
                 message = "Problem in updating record....!!!";
             }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(session.isOpen()){
                session.close();

            }
            resource.close();
        }
        return message;

    }

    public String DeleteStudent(int id){
        String message = "";

        Session session = resource.getSessionObject();
        Transaction tx = session.beginTransaction();

        try {
            Student s1=session.get(Student.class,id);
            if(s1!=null) {
                session.delete(s1);
                message = "Student is deleted successfully with id : " + s1.getSid();
                tx.commit();
            }
            else {
                message = "Problem in Deleting record....!!!";
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(session.isOpen()){
                session.close();

            }
            resource.close();
        }
        return message;

    }

    public List<Student> getAllStudents(){
        Session session = resource.getSessionObject();
        Transaction tx = session.beginTransaction();
        try{
            String QUERY="SELECT * FROM student";
            Query query=session.createSQLQuery(QUERY).addEntity(Student.class);
            //query.getResultList().stream().forEach(System.out::println);
           return  query.getResultList();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
   return null;
    }
}
