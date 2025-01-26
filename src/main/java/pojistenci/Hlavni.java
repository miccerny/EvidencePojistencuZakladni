package pojistenci;


import java.util.Scanner;
import java.util.*;

public class Hlavni {

    public static void main(String[] args) {
        Hlavni aplikace = new Hlavni();
        aplikace.spustit();
    }

    private Scanner vstup = new Scanner(System.in);
    private SpravaPojistencu pojistenec = new SpravaPojistencu();

    public void spustit(){
        int volba = 0;


        // Cyklus menu pojištěnců
        while (volba != 4) {

            // Metoa
            zobrazitMenu();
            volba = Integer.parseInt(vstup.nextLine());

            switch (volba) {

                case 1:
                    pridatPopjistence();
                    break;

                case 2:
                    zobrazitVsechny();
                    break;

                case 3:
                    vyhledatPojistence();
                    break;
                case 4:
                    System.out.println("Konec programu.\n");
                    break;

                default:
                    System.out.println("neplatná volba!\n");
            }
            System.out.println("\nPokračujte stisknutím libovolné klávesy...\n");
        }

    }
    private void zobrazitMenu(){
        System.out.println("------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("------------------------\n");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné ");
        System.out.println("3 - Vyhledat Pojištěného");
        System.out.println("4 - Konec");
    }

    private void pridatPopjistence() {

        String jmeno = kontrolaJmena("Zadejte jméno:");
        String prijmeni = kontrolaJmena("Zadejte příjmení:");
        int vek = kontrolaCiselnehoVstupu("Zadejte věk: ");
        String telefon = kontrolaTelCisla("Zadejte telefonní číslo:");
        Pojistenci novyPopjistenec = new Pojistenci(jmeno, prijmeni, vek, telefon);
        pojistenec.pridaniPojistence(novyPopjistenec);
        System.out.println("Data byla uložena");
    }

    private void zobrazitVsechny(){
       pojistenec.vypisSeznamuPojistencu();
    }

    private void vyhledatPojistence() {
        String jmeno = kontrolaJmena("Zadejte jméno");
        String prijmeni = kontrolaJmena("Zadejte příjmení");
        ArrayList<Pojistenci> vyhledani = pojistenec.vyhledatPojistence(jmeno, prijmeni);

        if (vyhledani.isEmpty()) {
            System.out.println("Pojištěnec není v databázi");
        } else {
            System.out.println("Nalezený pojištěnec:");
            for (Pojistenci p : vyhledani) {
                System.out.println(p);
            }
        }
    }

    private String kontrolaJmena(String udaje) {
        String scanner;
        do {
            System.out.println(udaje);
            scanner = vstup.nextLine();
            if (scanner.isBlank()) {
                System.out.println("Údaje nesmí být prázdné");

            } else if (scanner.length() < 3) {
                System.out.println("Jméno je příliš krátké");

            }
        } while (scanner.isBlank() || scanner.length() < 3);
        return scanner;
    }

    private String kontrolaTelCisla(String telCislo){
        String scanner;
        do {
            System.out.print(telCislo+"\n+420");
            scanner = vstup.nextLine();
            if(scanner.isBlank()){
                System.out.println("Údaje nesmí být prázdné");
            } else if (scanner.length()< 9 && scanner.length() > 9){
                System.out.println("Telefonní číslo je příliš krátké nebo dlouhé");
            }
        }while (scanner.isBlank() && scanner.length()!=9);
            return "+420"+ scanner;
    }


    private int kontrolaCiselnehoVstupu(String vek){
       int cislo;
       while (true){
           System.out.println(vek);
           if (vstup.hasNextInt()){
               cislo = vstup.nextInt();
               vstup.nextLine();
                if (cislo >= 0) {
                    return cislo;
                }else {
                    System.out.println("Věk nemůže být záporný");
                }
           } else {
               System.out.println("Věk musí být číslo");
               vstup.nextLine();
           }
       }
    }
}