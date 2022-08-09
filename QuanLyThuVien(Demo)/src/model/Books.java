/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Books {
    private String book_ID;
    private String Title;
    private String Publishers;
    private String Authors;
    private String Notes;
    private String userName;

    public Books(String book_ID, String Title, String pub_ID, String au_ID, String Notes, String userName) {
        this.book_ID = book_ID;
        this.Title = Title;
        this.Publishers = pub_ID;
        this.Authors = au_ID;
        this.Notes = Notes;
        this.userName = userName;
    }

    public Books() {
    }

    public String getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(String book_ID) {
        this.book_ID = book_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPublishers() {
        return Publishers;
    }

    public void setPublishers(String Publishers) {
        this.Publishers = Publishers;
    }

    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String Authors) {
        this.Authors = Authors;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
}
