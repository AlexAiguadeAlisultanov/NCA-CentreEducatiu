package org.example;

import java.util.ArrayList;

public class Profesor {
    private String  Usuari,Contraseña,nomProfesor,DNI,adreça,correu;
    private ArrayList<String> LlistaAlumnes = new ArrayList<>();
    private ArrayList<String> LlistaAssignatures = new ArrayList<>();
    private ArrayList<String> LlistaNotes = new ArrayList<>();
    private int telefon;

    public Profesor(String usuari, String contraseña, String nomProfesor, String DNI, String adreça, String correu, ArrayList<String> llistaAlumnes, ArrayList<String> llistaAssignatures, ArrayList<String> llistaNotes, int telefon) {
        Usuari = usuari;
        Contraseña = contraseña;
        this.nomProfesor = nomProfesor;
        this.DNI = DNI;
        this.adreça = adreça;
        this.correu = correu;
        LlistaAlumnes = llistaAlumnes;
        LlistaAssignatures = llistaAssignatures;
        LlistaNotes = llistaNotes;
        this.telefon = telefon;
    }

    public String getUsuari() {
        return Usuari;
    }

    public void setUsuari(String usuari) {
        Usuari = usuari;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }
    public ArrayList<String> getLlistaAlumnes() {
        return LlistaAlumnes;
    }

    public void setLlistaAlumnes(ArrayList<String> llistaAlumnes) {
        LlistaAlumnes = llistaAlumnes;
    }

    public ArrayList<String> getLlistaAssignatures() {
        return LlistaAssignatures;
    }

    public void setLlistaAssignatures(ArrayList<String> llistaAssignatures) {
        LlistaAssignatures = llistaAssignatures;
    }

    public ArrayList<String> getLlistaNotes() {
        return LlistaNotes;
    }

    public void setLlistaNotes(ArrayList<String> llistaNotes) {
        LlistaNotes = llistaNotes;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}