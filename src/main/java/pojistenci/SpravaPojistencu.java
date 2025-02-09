package pojistenci;

import java.util.ArrayList;

public class SpravaPojistencu{

    /**
     Deklarace Kolekce Arraylist
     */
    private ArrayList<Pojistenci> seznamPojistencu = new ArrayList<>();

    /**
     Metoda pro přidání pojištěného
     * @param pojistenec
     */
    public void pridaniPojistence(Pojistenci pojistenec) {
        seznamPojistencu.add(pojistenec);
    }

    /**
     Metoda pro vyhledání pojištěného v ArrayList
     * @param jmeno
     * @param prijmeni
     * @return
     */
    public ArrayList<Pojistenci> vyhledatPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenci> nalezeny = new ArrayList<>();

        /**
         Cyklus iterující v ArrayList a hledání vstupních údajů v kolekci
         */
        for (Pojistenci p: seznamPojistencu) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezeny.add(p);
            }
        }
        return nalezeny;
    }

    /**
     Metoda pro výpis všech pojištěnců
     */
    public void vypisSeznamuPojistencu(){
        /**
         Kontrola zda je Kolekce prázdná nebo zda obsahuje pojištěnce a jejich vypsání
         */
        if(seznamPojistencu.isEmpty()){
            System.out.println("Seznam je prázdný");
        }else {
            System.out.println("Seznam všech pojištěnců\n");
            for (Pojistenci pojistenec: seznamPojistencu){
                System.out.println(pojistenec);
            }
        }
    }



}
