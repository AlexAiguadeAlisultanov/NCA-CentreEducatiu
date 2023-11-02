package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main gestio = new Main(); // Crea un objecte de la classe Main
        gestio.Principal();
    }
    private void Principal() throws IOException, ClassNotFoundException {
        Scanner lector = new Scanner(System.in);
        ArrayList<Alumno> LlistaAlumnes = new ArrayList<>();
        ArrayList<Profesor> LlistaProfessors = new ArrayList<>();
        ArrayList<Asignatura> LlistaAssignatura = new ArrayList<>();
        ArrayList<Secretaria> LlistaSecretaria = new ArrayList<>();
        int valorTaula1 = 0;
        File Alumnos = new File("Alumnos.dat");
        File Profesores = new File("Profesores.dat");
        File Asignaturas = new File("Asignaturas.dat");
        File Secretaria = new File("Secretaria.dat");
        // Bucle principal que executa el programa fins que l'usuari selecciona l'opció de sortir
        while (valorTaula1 != 2) {
            // Mostra un menú d'opcions a l'usuari
            System.out.println("Que vols fer?");
            System.out.println("1- Log-In");
            System.out.println("2- Sortir del Centre Educatiu");
            valorTaula1 = IntroduirInt(); // Llegeix la opció de l'usuari
            // Comprova que la opció sigui vàlida (entre 1 i 3)
            while (valorTaula1 < 1 || valorTaula1 > 2) {
                System.out.println("Introdueix un numero del 1 al 2");
                valorTaula1 = IntroduirInt();
            }
            if (Alumnos.exists()) {
                FileInputStream fis = new FileInputStream("Alumnos.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available() > 0) {
                    Alumno Alumno1 = (Alumno) ois.readObject();
                    LlistaAlumnes.add(Alumno1);
                }
                ois.close();
                fis.close();
            }
            if (Profesores.exists()) {
                FileInputStream fis = new FileInputStream("Profesores.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available() > 0) {
                    Profesor Profesor1 = (Profesor) ois.readObject();
                    LlistaProfessors.add(Profesor1);
                }
                ois.close();
                fis.close();
            }
            if (Asignaturas.exists()) {
                FileInputStream fis = new FileInputStream("Asignaturas.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available() > 0) {
                    Asignatura Asignaturas1 = (Asignatura) ois.readObject();
                    LlistaAssignatura.add(Asignaturas1);
                }
                ois.close();
                fis.close();
            }
            if (Secretaria.exists()) {
                FileInputStream fis = new FileInputStream("Secretaria.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available() > 0) {
                    Secretaria Secretaria1 = (Secretaria) ois.readObject();
                    LlistaSecretaria.add(Secretaria1);
                }
                ois.close();
                fis.close();
            }else {
                String Usuari,Contrasenya,nomSecretaria,DNI,adreça,correu = "";
                int telefon = 0;
                System.out.println("Inserta un usuari Secretaria");
                System.out.print("Introdueix el nom d'usuari: ");
                Usuari = lector.nextLine();
                System.out.print("Introdueix la contrasenya: ");
                Contrasenya = lector.nextLine();
                System.out.print("Introdueix el nom de la secretària: ");
                nomSecretaria = lector.nextLine();
                System.out.print("Introdueix el DNI: ");
                DNI = lector.nextLine();
                System.out.print("Introdueix l'adreça: ");
                adreça = lector.nextLine();
                System.out.print("Introdueix el correu electrònic: ");
                correu = lector.nextLine();
                System.out.print("Introdueix el número de telèfon: ");
                telefon = IntroduirInt();
                Secretaria Secretaria1 = new Secretaria(Usuari,Contrasenya,nomSecretaria,DNI,adreça,correu,telefon);
                LlistaSecretaria.add(Secretaria1);
                guardarSecretaris(LlistaSecretaria);
            }
            if (valorTaula1 == 1) {
                System.out.print("Introdueix el nom d'usuari: ");
                String usuari = lector.nextLine();
                System.out.print("Introdueix la contrasenya: ");
                String contrasenya = lector.nextLine();
                boolean esProfesor = verificarProfessor(usuari, contrasenya, LlistaProfessors);
                boolean esSecretaria = verificarSecretaria(usuari, contrasenya, LlistaSecretaria);
                if (!esProfesor && !esSecretaria) {
                    System.out.println("Inici de sesió erroni. Usuari o contrasenya incorrectes.");
                }
                while (esProfesor || esSecretaria) {
                    if (esProfesor) {
                        int valortaula = 0;
                        while (valortaula != 3) {
                            System.out.println("Inici de sessió exitos com professor.");
                            System.out.println("1- Mostrar Notes");
                            System.out.println("2- Actualitzar Notes");
                            System.out.println("3- Tanca Sessió");
                            valortaula = IntroduirInt();
                            if (valortaula == 1) {
                                mostrarNotesAlumne(LlistaAlumnes, LlistaProfessors, usuari);
                            } else if (valortaula == 2) {
                                System.out.print("Introdueix el nom de l'alumne: ");
                                String nomAlumne = lector.nextLine();

                                // Buscar el alumno en la lista de alumnos
                                Alumno alumneSeleccionat = null;
                                for (Alumno alumno : LlistaAlumnes) {
                                    if (alumno.getNomAlumne().equals(nomAlumne)) {
                                        alumneSeleccionat = alumno;
                                        break;
                                    }
                                }
                                // Actualizar notas del alumno si se encontró
                                if (alumneSeleccionat != null) {
                                    System.out.print("Introdueix la nova nota: ");
                                    double novaNota = lector.nextDouble();
                                    lector.nextLine(); // Limpiar el buffer del scanner

                                    // Actualizar la nota del alumno directamente
                                    //alumneSeleccionat.setLlistaNotes(novaNota); me dona error
                                    System.out.println("Nota actualitzada amb èxit.");
                                } else {
                                    System.out.println("L'alumne no existeix en la llista.");
                                }
                            } else if (valortaula == 3) {
                                esProfesor = false;
                                System.out.println("Tancant Sessió...");
                            }
                        }
                    }
                    int valortaula = 0;
                    while(valortaula!=13){
                        if (esSecretaria) {
                            System.out.println("Inici de sesió exitos com secretari/a.");
                            System.out.println("1- Mostrar Alumnes");
                            System.out.println("2- Mostrar Professors");
                            System.out.println("3- Mostrar Assignatures");
                            System.out.println("4- Mostrar Secretaris");
                            System.out.println("5- Insertar Alumnes");
                            System.out.println("6- Insertar Professors");
                            System.out.println("7- Insertar Assignatures");
                            System.out.println("8- Insertar Secretaris");
                            System.out.println("9- Actualitzar Alumnes");
                            System.out.println("10- Actualitzar Professors");
                            System.out.println("11- Actualitzar Assignatures");
                            System.out.println("12- Actualitzar Secretaris");
                            System.out.println("13- Tanca Sessió");
                            valortaula = IntroduirInt();
                            if (valortaula == 1) {
                                mostrarAlumnes(LlistaAlumnes);
                            } else if (valortaula == 2) {
                                mostrarProfessors(LlistaProfessors);
                            }else if (valortaula == 3) {
                                mostrarAssignatures(LlistaAssignatura);
                            }else if (valortaula == 4) {
                                mostrarSecretaries(LlistaSecretaria);
                            }else if (valortaula == 5) {
                                InsertarAlumnes(LlistaAlumnes,lector);
                            }else if (valortaula == 6) {
                                InsertarProfessors(LlistaProfessors,lector);
                            }else if (valortaula == 7) {
                                InsertarAssignatures(LlistaAssignatura,lector);
                            }else if (valortaula == 8) {
                                InsertarSecretaris(LlistaSecretaria,lector);
                            }else if (valortaula == 9) {
                                ActualitzarAlumnes(LlistaAlumnes,lector);
                            }else if (valortaula == 10) {
                                ActualitzarProfessors(LlistaProfessors,lector);
                            }else if (valortaula == 11) {
                                ActualitzarAssignatures(LlistaAlumnes, LlistaProfessors,lector);
                            }else if (valortaula == 12) {
                                ActualitzarSecretaris(LlistaSecretaria,lector);
                            }
                        }
                    }if (valortaula == 13) {
                        esSecretaria = false;
                        System.out.println("Tancant Sessió...");
                    }
                }
            }
        }
        if (valorTaula1 == 2){
            System.out.println("Sortint del Centre Educatiu ...");
        }
    }
    private void mostrarAlumnes(ArrayList<Alumno> LlistaAlumnes) {
        if (LlistaAlumnes.isEmpty()) {
            System.out.println("No hi ha Alumnes disponibles.");
        } else {
            System.out.println("Llista de Alumnes:");
            for (int i = 0; i < LlistaAlumnes.size(); i++) {
                Alumno Alumne = LlistaAlumnes.get(i);
                System.out.println("Nom Alumne: " + Alumne.getNomAlumne());
                System.out.println("DNI: " + Alumne.getDNI());
                System.out.println("Adreça: " + Alumne.getAdreça());
                System.out.println("Correu: " + Alumne.getCorreu());
                System.out.println("Professors que te el alumne " + Alumne.getNomAlumne() + " :" + Alumne.getLlistaProfessors());
                System.out.println("Assignatures que te el alumne: " + Alumne.getNomAlumne() + " :" + Alumne.getLlistaAssignatura());
                System.out.println("Notes que te el alumne : " + Alumne.getNomAlumne() + " :" + Alumne.getLlistaNotes());
                System.out.println("------------------------------------");
            }
        }
    }
    private void InsertarAlumnes(ArrayList<Alumno> LlistaAlumnes,Scanner lector) throws IOException {
        ArrayList<String> LlistaProfessors1 = new ArrayList<>();
        ArrayList<String> LlistaAssignatura1 = new ArrayList<>();
        ArrayList<String> LlistaNotes1 = new ArrayList<>();
        System.out.print("Introdueix el nom de l'alumne: ");
        String nomAlumne = lector.nextLine();
        // Introduir el DNI de l'alumne
        System.out.print("Introdueix el DNI de l'alumne: ");
        String DNI = lector.nextLine();
        // Introduir l'adreça de l'alumne
        System.out.print("Introdueix l'adreça de l'alumne: ");
        String adreça = lector.nextLine();
        // Introduir el correu electrònic de l'alumne
        System.out.print("Introdueix el correu electrònic de l'alumne: ");
        String correu = lector.nextLine();
        // Introduir quantitat de professors i afegir-los a LlistaProfessors
        System.out.print("Quantitat de professors que te l'alumne: ");
        int quantitatProfessors = IntroduirInt();
        for (int i = 0; i < quantitatProfessors; i++) {
            System.out.print("Introdueix el professor " + (i + 1) + ": ");
            LlistaProfessors1.add(lector.nextLine());
        }
        // Introduir quantitat d'assignatures i afegir-les a LlistaAssignatura
        System.out.print("Quantitat d'assignatures que te l'alumne: ");
        int quantitatAssignatures = IntroduirInt();
        for (int i = 0; i < quantitatAssignatures; i++) {
            System.out.print("Introdueix l'assignatura " + (i + 1) + ": ");
            LlistaAssignatura1.add(lector.nextLine());
        }
        // Introduir quantitat de notes i afegir-les a LlistaNotes
        System.out.print("Quantitat de notes que te l'alumne: ");
        int quantitatNotes = IntroduirInt();
        for (int i = 0; i < quantitatNotes; i++) {
            System.out.print("Introdueix la nota " + (i + 1) + ": ");
            LlistaNotes1.add(lector.nextLine());
        }
        Alumno Alumne = new Alumno(nomAlumne,DNI,adreça,correu,LlistaProfessors1,LlistaAssignatura1,LlistaNotes1);
        LlistaAlumnes.add(Alumne);
        guardarAlumnes(LlistaAlumnes);
    }
    private void ActualitzarAlumnes(ArrayList<Alumno> LlistaAlumnes, Scanner lector) throws IOException {
        System.out.print("Introdueix el DNI de l'alumne que vols actualitzar: ");
        String DNI = lector.nextLine();
        for (Alumno alumne : LlistaAlumnes) {
            if (alumne.getDNI().equals(DNI)) {
                System.out.print("Introdueix el nou nom de l'alumne: ");
                alumne.setNomAlumne(lector.nextLine());
                guardarAlumnes(LlistaAlumnes);
                System.out.println("Dades de l'alumne actualitzades amb èxit.");
                return;
            }
        }
        System.out.println("No s'ha trobat cap alumne amb aquest DNI.");
    }
    private void guardarAlumnes(ArrayList<Alumno> LlistaAlumnes) throws IOException {
        FileOutputStream fos = new FileOutputStream("Alumnos.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Alumno alumnos : LlistaAlumnes) {
            oos.writeObject(alumnos);
        }
        oos.close();
        fos.close();
    }
    private void mostrarProfessors(ArrayList<Profesor> LlistaProfessors) {
        if (LlistaProfessors.isEmpty()) {
            System.out.println("No hi ha Professors disponibles.");
        } else {
            System.out.println("Llista de Professors:");
            for (int i = 0; i < LlistaProfessors.size(); i++) {
                Profesor Profe1 = LlistaProfessors.get(i);
                System.out.println("Nom Professor: " + Profe1.getNomProfesor());
                System.out.println("DNI: " + Profe1.getDNI());
                System.out.println("Adreça: " + Profe1.getAdreça());
                System.out.println("Correu: " + Profe1.getCorreu());
                System.out.println("Assignatures que te el professor " + Profe1.getNomProfesor() + " :" + Profe1.getLlistaAssignatures());
                System.out.println("Alumnes que te el professor " + Profe1.getNomProfesor() + " :" + Profe1.getLlistaAlumnes());
                System.out.println("Notes que te cada alumne del professor " + Profe1.getNomProfesor() + " :" + Profe1.getLlistaNotes());
                System.out.println("------------------------------------");
            }
        }
    }
    private void InsertarProfessors(ArrayList<Profesor> LlistaProfessors,Scanner lector) throws IOException {
        String Usuari, Contraseña, nomProfesor, DNI, adreça, correu;
        ArrayList<String> LlistaAlumnes = new ArrayList<>();
        ArrayList<String> LlistaAssignatures = new ArrayList<>();
        ArrayList<String> LlistaNotes = new ArrayList<>();
        int telefon;
        // Introduir el nom d'usuari
        System.out.print("Introdueix el nom d'usuari: ");
        Usuari = lector.nextLine();
        // Introduir la contrasenya
        System.out.print("Introdueix la contrasenya: ");
        Contraseña = lector.nextLine();
        // Introduir el nom del professor
        System.out.print("Introdueix el nom del professor: ");
        nomProfesor = lector.nextLine();
        // Introduir el DNI del professor
        System.out.print("Introdueix el DNI del professor: ");
        DNI = lector.nextLine();
        // Introduir l'adreça del professor
        System.out.print("Introdueix l'adreça del professor: ");
        adreça = lector.nextLine();
        // Introduir el correu electrònic del professor
        System.out.print("Introdueix el correu electrònic del professor: ");
        correu = lector.nextLine();
        // Introduir el número de telèfon del professor
        System.out.print("Introdueix el número de telèfon del professor: ");
        telefon = Integer.parseInt(lector.nextLine());
        // Introduir quantitat d'alumnes i afegir-los a LlistaAlumnes
        System.out.print("Quantitat d'alumnes que vols introduir: ");
        int quantitatAlumnes = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < quantitatAlumnes; i++) {
            System.out.print("Introdueix l'alumne " + (i + 1) + ": ");
            LlistaAlumnes.add(lector.nextLine());
        }
        // Introduir quantitat d'assignatures i afegir-les a LlistaAssignatures
        System.out.print("Quantitat d'assignatures que vols introduir: ");
        int quantitatAssignatures = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < quantitatAssignatures; i++) {
            System.out.print("Introdueix l'assignatura " + (i + 1) + ": ");
            LlistaAssignatures.add(lector.nextLine());
        }
        // Introduir quantitat de notes i afegir-les a LlistaNotes
        System.out.print("Quantitat de notes que vols introduir: ");
        int quantitatNotes = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < quantitatNotes; i++) {
            System.out.print("Introdueix la nota " + (i + 1) + ": ");
            LlistaNotes.add(lector.nextLine());
        }
        Profesor Profe1 = new Profesor(Usuari,Contraseña,nomProfesor,DNI,adreça,correu,LlistaAlumnes,LlistaAssignatures,LlistaNotes,telefon);
        LlistaProfessors.add(Profe1);
        guardarProfessors(LlistaProfessors);
    }
    private void ActualitzarProfessors(ArrayList<Profesor> LlistaProfessors, Scanner lector) throws IOException {
        System.out.print("Introdueix el DNI del professor que vols actualitzar: ");
        String DNI = lector.nextLine();
        for (Profesor profesor : LlistaProfessors) {
            if (profesor.getDNI().equals(DNI)) {
                System.out.print("Introdueix el nou nom del professor: ");
                profesor.setNomProfesor(lector.nextLine());
                // Aquí puedes actualizar otros atributos del profesor si es necesario
                guardarProfessors(LlistaProfessors); // Guardar los cambios en el archivo
                System.out.println("Dades del professor actualitzades amb èxit.");
                return;
            }
        }
        System.out.println("No s'ha trobat cap professor amb aquest DNI.");
    }
    private void guardarProfessors(ArrayList<Profesor> LlistaProfessors) throws IOException {
        FileOutputStream fos = new FileOutputStream("Profesores.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Profesor profesor1 : LlistaProfessors) {
            oos.writeObject(profesor1);
        }
        oos.close();
        fos.close();
    }
    private void mostrarAssignatures(ArrayList<Asignatura> LlistaAssignatura) {
        if (LlistaAssignatura.isEmpty()) {
            System.out.println("No hi ha Assignatures disponibles.");
        } else {
            System.out.println("Llista de Assignatures:");
            for (int i = 0; i < LlistaAssignatura.size(); i++) {
                Asignatura Assignatura1 = LlistaAssignatura.get(i);
                System.out.println("La Assignatura es : " + Assignatura1.getLlistaAssignatures());
                System.out.println("------------------------------------");
            }
        }
    }
    private void InsertarAssignatures(ArrayList<Asignatura> LlistaAssignatura,Scanner lector) throws IOException {
        ArrayList<String> LlistaAssignatures = new ArrayList<>();
        // Introduir quantitat d'assignatures i afegir-les a LlistaAssignatures
        System.out.print("Quantitat d'assignatures que vols introduir: ");
        int quantitatAssignatures = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < quantitatAssignatures; i++) {
            System.out.print("Introdueix l'assignatura " + (i + 1) + ": ");
            LlistaAssignatures.add(lector.nextLine());
        }
        Asignatura Assignatura1 = new Asignatura(LlistaAssignatures);
        LlistaAssignatura.add(Assignatura1);
        guardarAssignatures(LlistaAssignatura);
    }
    private void ActualitzarAssignatures(ArrayList<Alumno> LlistaAlumnes, ArrayList<Profesor> LlistaProfessors, Scanner lector) throws IOException {
        System.out.println("Què vols actualitzar en la llista d'assignatures?");
        System.out.println("1- Actualitzar Llista d'Alumnes");
        System.out.println("2- Actualitzar Llista de Professors");
        int opcio = IntroduirInt();

        if (opcio == 1) {
            // Actualizar Llista d'Alumnes
            System.out.print("Introdueix la nova llista d'alumnes (separats per comes): ");
            String novaLlistaAlumnes = lector.nextLine();
            String[] alumnesArray = novaLlistaAlumnes.split(",");
            ArrayList<String> novaLlistaAlumnesArray = new ArrayList<>(Arrays.asList(alumnesArray));
            for (Alumno alumne : LlistaAlumnes) {
                if (novaLlistaAlumnesArray.contains(alumne.getNomAlumne())) {
                    alumne.setLlistaAssignatura(novaLlistaAlumnesArray);
                }
            }
            System.out.println("Llista d'alumnes actualitzada amb èxit.");
            // Guardar los cambios en el archivo LlistaAlumnes
            guardarAlumnes(LlistaAlumnes);
        } else if (opcio == 2) {
            // Actualizar Llista de Professors
            System.out.print("Introdueix la nova llista de professors (separats per comes): ");
            String novaLlistaProfessors = lector.nextLine();
            String[] professorsArray = novaLlistaProfessors.split(",");
            ArrayList<String> novaLlistaProfessorsArray = new ArrayList<>(Arrays.asList(professorsArray));

            for (Profesor profesor : LlistaProfessors) {
                if (novaLlistaProfessorsArray.contains(profesor.getNomProfesor())) {
                    profesor.setLlistaAssignatures(novaLlistaProfessorsArray);
                }
            }

            System.out.println("Llista de professors actualitzada amb èxit.");
            // Guardar los cambios en el archivo LlistaProfessors
            guardarProfessors(LlistaProfessors);
        } else {
            System.out.println("Opció no vàlida.");
        }
    }
    private void guardarAssignatures(ArrayList<Asignatura> LlistaAssignatura) throws IOException {
        FileOutputStream fos = new FileOutputStream("Asignaturas.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Asignatura asignatura1 : LlistaAssignatura) {
            oos.writeObject(asignatura1);
        }
        oos.close();
        fos.close();
    }
    private void mostrarSecretaries(ArrayList<Secretaria> LlistaSecretaria) {
        if (LlistaSecretaria.isEmpty()) {
            System.out.println("No hi ha Secretaries disponibles.");
        } else {
            System.out.println("Llista de Secretaries:");
            for (int i = 0; i < LlistaSecretaria.size(); i++) {
                Secretaria Secretaria1 = LlistaSecretaria.get(i);
                System.out.println("Nom Secretaria: " + Secretaria1.getNomSecretaria());
                System.out.println("DNI: " + Secretaria1.getDNI());
                System.out.println("Adreça: " + Secretaria1.getAdreça());
                System.out.println("Correu: " + Secretaria1.getCorreu());
                System.out.println("Telefon: " + Secretaria1.getTelefon());
                System.out.println("------------------------------------");
            }
        }
    }
    private void InsertarSecretaris(ArrayList<Secretaria> LlistaSecretaria,Scanner lector) throws IOException {
        if (LlistaSecretaria.isEmpty()) {
            System.out.println("No hi ha Secretaries disponibles.");
        }else {
            String Usuari, Contrasenya, nomSecretaria, DNI, adreça, correu = "";
            int telefon = 0;
            System.out.println("Inserta un usuari Secretaria");
            System.out.print("Introdueix el nom d'usuari: ");
            Usuari = lector.nextLine();
            System.out.print("Introdueix la contrasenya: ");
            Contrasenya = lector.nextLine();
            System.out.print("Introdueix el nom de la secretària: ");
            nomSecretaria = lector.nextLine();
            System.out.print("Introdueix el DNI: ");
            DNI = lector.nextLine();
            System.out.print("Introdueix l'adreça: ");
            adreça = lector.nextLine();
            System.out.print("Introdueix el correu electrònic: ");
            correu = lector.nextLine();
            System.out.print("Introdueix el número de telèfon: ");
            telefon = IntroduirInt();
            Secretaria Secretaria1 = new Secretaria(Usuari, Contrasenya, nomSecretaria, DNI, adreça, correu, telefon);
            LlistaSecretaria.add(Secretaria1);
            guardarSecretaris(LlistaSecretaria);
        }
    }
    private void ActualitzarSecretaris(ArrayList<Secretaria> LlistaSecretaria, Scanner lector) throws IOException {
        System.out.print("Introdueix el DNI de la secretària que vols actualitzar: ");
        String DNI = lector.nextLine();
        for (Secretaria secretaria : LlistaSecretaria) {
            if (secretaria.getDNI().equals(DNI)) {
                System.out.println("Què vols actualitzar?");
                System.out.println("1- Nom");
                System.out.println("2- Adreça");
                System.out.println("3- Correu electrònic");
                System.out.println("4- Número de telèfon");
                int opcio = IntroduirInt();
                if (opcio == 1) {
                    System.out.print("Introdueix el nou nom de la secretària: ");
                    secretaria.setNomSecretaria(lector.nextLine());
                } else if (opcio == 2) {
                    System.out.print("Introdueix la nova adreça de la secretària: ");
                    secretaria.setAdreça(lector.nextLine());
                } else if (opcio == 3) {
                    System.out.print("Introdueix el nou correu electrònic de la secretària: ");
                    secretaria.setCorreu(lector.nextLine());
                } else if (opcio == 4) {
                    System.out.print("Introdueix el nou número de telèfon de la secretària: ");
                    secretaria.setTelefon(IntroduirInt());
                } else {
                    System.out.println("Opció no vàlida.");
                    return;
                }
                guardarSecretaris(LlistaSecretaria); // Guardar los cambios en el archivo
                System.out.println("Dades de la secretària actualitzades amb èxit.");
                return;
            }
        }
        System.out.println("No s'ha trobat cap secretària amb aquest DNI.");
    }
    private void guardarSecretaris(ArrayList<Secretaria> LlistaSecretaria) throws IOException {
        FileOutputStream fos = new FileOutputStream("Secretaria.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Secretaria secretaris : LlistaSecretaria) {
            oos.writeObject(secretaris);
        }
        oos.close();
        fos.close();
    }
    private boolean verificarProfessor(String usuario, String contraseña, ArrayList<Profesor> LlistaProfessors) {
        boolean esprofe = false;
        for (int i = 0; i < LlistaProfessors.size(); i++) {
            Profesor profesor = (Profesor) LlistaProfessors.get(i);
            if (usuario.equals(profesor.getUsuari()) && contraseña.equals(profesor.getContraseña())) {
                esprofe = true;
            }else{
                esprofe= false;
            }
        }
        return esprofe;
    }
    private boolean verificarSecretaria(String usuario, String contraseña, ArrayList<Secretaria> LlistaSecretaria) {
        boolean esSecretaria = false;
        for (int i = 0; i < LlistaSecretaria.size(); i++) {
            Secretaria Secretaria = (Secretaria) LlistaSecretaria.get(i);
            if ((usuario.equals(Secretaria.getUsuari())) && (contraseña.equals(Secretaria.getContraseña()))){
                esSecretaria = true;
            }else{
                esSecretaria = false;
            }
        }
        return esSecretaria;
    }
    public int IntroduirInt() {
        Scanner lector = new Scanner(System.in);
        boolean valorCorrecte = false;
        int numero = 0;
        do {
            valorCorrecte = false;
            while (!valorCorrecte) {
                if (lector.hasNextInt()) {
                    numero = lector.nextInt();
                    lector.nextLine(); // Consumir el caràcter de nova línia
                    if (numero <= 0) {
                        System.out.println("Ha de ser un número enter positiu");
                    } else {
                        valorCorrecte = true;
                    }
                } else {
                    System.out.println("Ha de ser un número enter positiu");
                    lector.nextLine(); // Netegem el buffer de l'scanner
                }
            }
        } while (!valorCorrecte);
        return numero;
    }
    private void mostrarNotesAlumne(ArrayList<Alumno> LlistaAlumnes, ArrayList<Profesor> LlistaProfessors, String usuario) {
        if (LlistaAlumnes.isEmpty()) {
            System.out.println("No hi ha Alumnes disponibles.");
        } else {
            String nomprofealumne = "";
            String nomprofe = "";
            for (int i = 0; i < LlistaProfessors.size(); i++) {
                Profesor profesor = LlistaProfessors.get(i);
                nomprofe = String.valueOf(profesor.getNomProfesor());
                if (nomprofe.equals(usuario)) {
                    i = LlistaProfessors.size();
                }
            }
            for (int i = 0; i < LlistaAlumnes.size(); i++) {
                Alumno Alumne = LlistaAlumnes.get(i);
                nomprofealumne = String.valueOf(Alumne.getLlistaProfessors());
                if (nomprofealumne.equals(nomprofe)) {
                    System.out.println("Llista de Notes de Cada Alumne:");
                    System.out.println("Nom Alumne: " + Alumne.getNomAlumne());
                    System.out.println("Nom Assignatura: " + Alumne.getLlistaAssignatura());
                    System.out.println("Nota: " + Alumne.getLlistaNotes());
                    System.out.println("Adreça: " + Alumne.getAdreça());
                    System.out.println("DNI: " + Alumne.getDNI());
                    System.out.println("------------------------------------");
                }
            }
        }
    }
}