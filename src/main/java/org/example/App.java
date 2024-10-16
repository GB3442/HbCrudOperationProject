package org.example;

import org.example.CURD.CrudOperations;
import org.example.model.Student;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
 static Scanner sc=new Scanner(System.in);
 static CrudOperations obj=new CrudOperations();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1 . Insert Student");
            System.out.println("2 . Update Student");
            System.out.println("3 . Delete Student");
            System.out.println("4 . Display Students");
            System.out.println("5 . Exit \n");

            System.out.println("Enter choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                Student s = new Student();
                System.out.println("Enter Name : ");
                String name = sc.next();
                System.out.println("Enter marks : ");
                Double marks = sc.nextDouble();
                s.setSname(name);
                s.setMarks(marks);
                String message = obj.addStudent(s);
                System.out.println(message);
            } else if (choice == 2) {
                System.out.println("Enter Student ID :");
                int id = sc.nextInt();
                String message = obj.updateStudent(id);
                System.out.println(message);
            } else if (choice == 3) {
                System.out.println("Enter Student ID :");
                int id = sc.nextInt();
                String message = obj.DeleteStudent(id);
                System.out.println(message);
            }
            else if(choice==4){
                obj.getAllStudents().stream().forEach(System.out::println);
                System.out.println();

            }
            else {
                System.out.println("Thank You !!!!!");
                System.exit(0);
            }
        }
    }

    }

