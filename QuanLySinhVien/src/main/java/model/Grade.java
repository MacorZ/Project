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
    private int englishScore;
    @Column(name = "tinhoc",nullable = true)
    private int itScore;
    @Column(name = "gdtc",nullable = true)
    private int peScore;

    public Grade(int Id, Students students, int englishScore, int itScore, int peScore) {
        this.Id = Id;
        this.students = students;
        this.englishScore = englishScore;
        this.itScore = itScore;
        this.peScore = peScore;
    }

    public Grade(Students students, int englishScore, int itScore, int peScore) {
        this.students = students;
        this.englishScore = englishScore;
        this.itScore = itScore;
        this.peScore = peScore;
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

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getItScore() {
        return itScore;
    }

    public void setItScore(int itScore) {
        this.itScore = itScore;
    }

    public int getPeScore() {
        return peScore;
    }

    public void setPeScore(int peScore) {
        this.peScore = peScore;
    }

    
   
    public double getMediumScore(){
        double score = (this.englishScore+this.itScore+this.peScore)/3;
        return score;
    }

    @Override
    public String toString() {
        return "Grade{" + "Id=" + Id + ", students=" + students + ", English_Score=" + englishScore + ", IT_Score=" + itScore + ", PE_Score=" + peScore + '}';
    }
    public Object[] getObj(){
        return new Object[]{
          students.getStudentID(),students.getStudentName(),englishScore,itScore,peScore,getMediumScore()
        };
    }
    
   
    
    
}
