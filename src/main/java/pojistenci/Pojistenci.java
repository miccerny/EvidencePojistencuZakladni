package pojistenci;

public class Pojistenci {



    // Přiřazení proměnné pojištěnce
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    //Konstruktor
    public Pojistenci (String jmeno, String prijmeni, int vek, String telefon){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    public String getJmeno(){
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }


    @Override
    public String toString(){
        return String.format("%s     %s,  Věk: %d let, Telefon: %s", jmeno, prijmeni, vek, telefon);
    }


}
