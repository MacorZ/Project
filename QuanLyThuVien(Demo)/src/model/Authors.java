/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Authors {
    private String au_ID;
    private String au_Name;
    private String au_Address;

    public Authors() {
    }

    public Authors(String au_ID, String au_Name, String au_Address) {
        this.au_ID = au_ID;
        this.au_Name = au_Name;
        this.au_Address = au_Address;
    }

    public String getAu_ID() {
        return au_ID;
    }

    public void setAu_ID(String au_ID) {
        this.au_ID = au_ID;
    }

    public String getAu_Name() {
        return au_Name;
    }

    public void setAu_Name(String au_Name) {
        this.au_Name = au_Name;
    }

    public String getAu_Address() {
        return au_Address;
    }

    public void setAu_Address(String au_Address) {
        this.au_Address = au_Address;
    }

    @Override
    public String toString() {
        return "Authors{" + "au_ID=" + au_ID + ", au_Name=" + au_Name + ", au_Address=" + au_Address + '}';
    }
    
}
