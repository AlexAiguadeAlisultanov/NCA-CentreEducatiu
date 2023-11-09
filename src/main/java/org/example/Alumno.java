package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
    private String Usuari, contrasenya, nomAlumne, DNI, adreça, correu;
    private ArrayList<String> LlistaProfessors = new ArrayList<>();
    private ArrayList<String> LlistaAssignatura = new ArrayList<>();
    private ArrayList<String> LlistaNotes = new ArrayList<>();

    public Alumno(String usuari, String contrasenya, String nomAlumne, String DNI, String adreça, String correu, ArrayList<String> llistaProfessors, ArrayList<String> llistaAssignatura, ArrayList<String> llistaNotes) {
        Usuari = usuari;
        this.contrasenya = contrasenya;
        this.nomAlumne = nomAlumne;
        this.DNI = DNI;
        this.adreça = adreça;
        this.correu = correu;
        LlistaProfessors = llistaProfessors;
        LlistaAssignatura = llistaAssignatura;
        LlistaNotes = llistaNotes;
    }

    public String getUsuari() {
        return Usuari;
    }

    public void setUsuari(String usuari) {
        Usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNomAlumne() {
        return nomAlumne;
    }

    public void setNomAlumne(String nomAlumne) {
        this.nomAlumne = nomAlumne;
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

    public ArrayList<String> getLlistaProfessors() {
        return LlistaProfessors;
    }

    public void setLlistaProfessors(ArrayList<String> llistaProfessors) {
        LlistaProfessors = llistaProfessors;
    }

    public ArrayList<String> getLlistaAssignatura() {
        return LlistaAssignatura;
    }

    public void setLlistaAssignatura(ArrayList<String> llistaAssignatura) {
        LlistaAssignatura = llistaAssignatura;
    }

    public ArrayList<String> getLlistaNotes() {
        return LlistaNotes;
    }

    public void setLlistaNotes(ArrayList<String> llistaNotes) {
        LlistaNotes = llistaNotes;
    }
}