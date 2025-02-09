package pojistenci;


import java.util.Scanner;
import java.util.*;

public class Hlavni {

    public static void main(String[] args) {
        Hlavni aplikace = new Hlavni();
        aplikace.spustit();
    }

    /*
     Deklarování metody vstupu a třídy SpravaPojištěnců
     */
    private Scanner vstup = new Scanner(System.in);
    private SpravaPojistencu pojistenec = new SpravaPojistencu();

    /*
     Metoda pro vytvoření menu na základě vstupních hodnot uživatele 1-4
     */
    public void spustit(){
        int volba = 0;


        /**
         * Cyklus menu pojištěnců
          */
        while (volba != 4) {



            zobrazitMenu();
            volba = Integer.parseInt(vstup.nextLine());

            /*
            Switch pro MENU volby 1-4 na základě volby0 vstupu od uživatele
            1 - přidání pojištěnce
            2 - vyhledání pojištěnce
            3 - vyhledání všech pojištěnců
            4 - Konec
             */
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


    /*
        Metoda pro zobrazení MENU volby 1-4
     */
    private void zobrazitMenu(){
        System.out.println("------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné ");
        System.out.println("3 - Vyhledat Pojištěného");
        System.out.println("4 - Konec");
    }

    /*
     Metoda pro vytvoření pojištěnce s kontrolou vstupu
     */
    private void pridatPopjistence() {

        String jmeno = kontrolaJmena("Zadejte jméno:");
        String prijmeni = kontrolaJmena("Zadejte příjmení:");
        int vek = kontrolaCiselnehoVstupu("Zadejte věk: ");
        String telefon = kontrolaTelCisla("Zadejte telefonní číslo:");
        Pojistenci novyPopjistenec = new Pojistenci(jmeno, prijmeni, vek, telefon);
        pojistenec.pridaniPojistence(novyPopjistenec);
        System.out.println("Data byla uložena");
    }

    /*
    Výpis všech pojištěnců z Arraylistu
     */
    private void zobrazitVsechny(){
       pojistenec.vypisSeznamuPojistencu();
    }

    /*
     Vyhledání jednotlivých pojištěnců na základě Jména a Příjmení,
    včetně validace zda se pojištěný nachází v databázi
     */

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

    /**
     Validace Jmená a Příjmení při vytvoření pojištěnce.
     Metoda kontroluje prázdné jméno a méně než 3 znaky ve jméně
     * @param udaje
     * @return
     */
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

    /**
     Validace Telefoního čísla.
     Kontroluje velikost telefonního čísla aby splňovalo formát ČR a doplňuje předvolbu ČR
     * @param telCislo
     * @return
     */
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

    /**
     Validace věku
     Kontroluje věk aby pojištěný nezadal záporné číslo a aby nezadal něco jiného než číslo
     * @param vek
     * @return
     */
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