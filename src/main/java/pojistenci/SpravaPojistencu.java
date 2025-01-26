package pojistenci;

import java.util.ArrayList;

public class SpravaPojistencu{

    private ArrayList<Pojistenci> seznamPojistencu = new ArrayList<>();

    public void pridaniPojistence(Pojistenci pojistenec) {
        seznamPojistencu.add(pojistenec);
    }

    public ArrayList<Pojistenci> vyhledatPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenci> nalezeny = new ArrayList<>();
        for (Pojistenci p: seznamPojistencu) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezeny.add(p);
            }
        }
        return nalezeny;
    }

    public void vypisSeznamuPojistencu(){
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
