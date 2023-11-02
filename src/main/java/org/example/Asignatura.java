package org.example;

import java.util.ArrayList;

public class Asignatura {
    private ArrayList<String> LlistaAssignatures = new ArrayList<>();

    public Asignatura(ArrayList<String> llistaAssignatures) {
        LlistaAssignatures = llistaAssignatures;
    }

    public ArrayList<String> getLlistaAssignatures() {
        return LlistaAssignatures;
    }

    public void setLlistaAssignatures(ArrayList<String> llistaAssignatures) {
        LlistaAssignatures = llistaAssignatures;
    }
}