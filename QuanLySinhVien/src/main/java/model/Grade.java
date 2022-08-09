/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int Id;
    @ManyToOne
    @JoinColumn(name = "masv",nullable = true)
    private Students students;
    @Column(name = "tienganh",nullable = true)
    private int English_Score;
    @Column(name = "tinhoc",nullable = true)
    private int IT_Score;
    @Column(name = "gdtc",nullable = true)
    private int PE_Score;

    public Grade(int Id, Students students, int English_Score, int IT_Score, int PE_Score) {
        this.Id = Id;
        this.students = students;
        this.English_Score = English_Score;
        this.IT_Score = IT_Score;
        this.PE_Score = PE_Score;
    }

    public Grade(Students students, int English_Score, int IT_Score, int PE_Score) {
        this.students = students;
        this.English_Score = English_Score;
        this.IT_Score = IT_Score;
        this.PE_Score = PE_Score;
    }

    public Grade() {
    }

    public Grade(Students students) {
        this.students = students;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public int getEnglish_Score() {
        return English_Score;
    }

    public void setEnglish_Score(int English_Score) {
        this.English_Score = English_Score;
    }

    public int getIT_Score() {
        return IT_Score;
    }

    public void setIT_Score(int IT_Score) {
        this.IT_Score = IT_Score;
    }

    public int getPE_Score() {
        return PE_Score;
    }

    public void setPE_Score(int PE_Score) {
        this.PE_Score = PE_Score;
    }
    
   
    public double getMedium_Score(){
        double score = (this.English_Score+this.IT_Score+this.PE_Score)/3;
        return score;
    }

    @Override
    public String toString() {
        return "Grade{" + "Id=" + Id + ", students=" + students + ", English_Score=" + English_Score + ", IT_Score=" + IT_Score + ", PE_Score=" + PE_Score + '}';
    }
    public Object[] getObj(){
        return new Object[]{
          students.getStudentID(),students.getStudentName(),English_Score,IT_Score,PE_Score,getMedium_Score()
        };
    }
    
   
    
    
}
