package org.example;

public class Secretaria {
    private String Usuari,Contraseña,nomSecretaria,DNI,adreça,correu;
    private int telefon;

    public Secretaria(String usuari, String contraseña, String nomSecretaria, String DNI, String adreça, String correu, int telefon) {
        Usuari = usuari;
        Contraseña = contraseña;
        this.nomSecretaria = nomSecretaria;
        this.DNI = DNI;
        this.adreça = adreça;
        this.correu = correu;
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

    public String getNomSecretaria() {
        return nomSecretaria;
    }

    public void setNomSecretaria(String nomSecretaria) {
        this.nomSecretaria = nomSecretaria;
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

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
