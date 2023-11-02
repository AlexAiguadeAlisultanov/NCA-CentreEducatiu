package org.example;

import java.util.ArrayList;

public class Alumno {
    private String nomAlumne, DNI, adreça, correu;
    private ArrayList<String> LlistaProfessors = new ArrayList<>();
    private ArrayList<String> LlistaAssignatura = new ArrayList<>();
    private ArrayList<String> LlistaNotes = new ArrayList<>();

    public Alumno(String nomAlumne, String DNI, String adreça, String correu, ArrayList<String> llistaProfessors, ArrayList<String> llistaAssignatura, ArrayList<String> llistaNotes) {
        this.nomAlumne = nomAlumne;
        this.DNI = DNI;
        this.adreça = adreça;
        this.correu = correu;
        LlistaProfessors = llistaProfessors;
        LlistaAssignatura = llistaAssignatura;
        LlistaNotes = llistaNotes;
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