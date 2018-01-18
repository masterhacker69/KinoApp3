import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;

public class Liste {

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();

    public ArrayList<Filmeintrag> getGesamtEinträge() {
        return gesamtEinträge;
    }

    public void setGesamtEinträge(ArrayList<Filmeintrag> gesamtEinträge) {
        this.gesamtEinträge = gesamtEinträge;
    }

    public static void main (String[] args) throws IOException {
            Liste liste = new Liste();
        }

    public Liste() throws IOException {

        String zeile = null;

        Filter kategorien = new Filter();
        String eingabe = kategorien.suchparameter();
        String eingabe1 = kategorien.suchparameter1();
        String eingabe2 = kategorien.suchparameter2();
        String eingabe3 = kategorien.suchparameter3();
        String eingabe4 = kategorien.suchparameter4();

        BufferedReader brx = new BufferedReader(new FileReader("filmdaten.txt"));
        while(brx.ready()) {
            if((zeile = brx.readLine()) != null) {
                suche1(zeile, eingabe, eingabe1, eingabe2, eingabe3, eingabe4);
            }
        }
        for (Filmeintrag f : gesamtEinträge) {
            System.out.println("Name: " + f.name + " Genre: " + f.genre + " Kino" + f.kino + " Zeit:" + f.zeit + " Preis:" + f.preis);
        }
    }

    public void suche1 (String zeile, String eingabe, String eingabe1, String eingabe2, String eingabe3, String eingabe4) {
        String searchChar = ";";

        //-->neue variable anlegen. die variable ist = zeile .wir arbeiten nicht mehr mit ; sondern mit einem anderen zeichen (taste gedrückt ohne caps)
        String[] teile = zeile.split(searchChar);
            //suchfelder stehen von anfang an dort, und erscheinen nicht erst bei eingabe des vorherigen suchfeldes
        if (teile[0].toLowerCase().contains(eingabe.toLowerCase()) && teile[1].toLowerCase().contains(eingabe1.toLowerCase()) && teile[2].toLowerCase().contains(eingabe2.toLowerCase()) && teile[3].toLowerCase().contains(eingabe3.toLowerCase()) && teile[4].toLowerCase().contains(eingabe4.toLowerCase())) {
            zeileerstellen(zeile);
        }

    }

    public void zeileerstellen (String zeile) {

        String[] filmeintragAttribute = zeile.split(";");

                Filmeintrag neuerFilmeintrag = new Filmeintrag();


        neuerFilmeintrag.name= filmeintragAttribute[0];
        neuerFilmeintrag.genre= filmeintragAttribute[1];
        neuerFilmeintrag.kino= filmeintragAttribute[2];
        filmeintragAttribute[3] = filmeintragAttribute[3].substring(filmeintragAttribute[3].indexOf("§") +1, filmeintragAttribute[3].indexOf("$"));
        neuerFilmeintrag.zeit= filmeintragAttribute[3];
        neuerFilmeintrag.preis= filmeintragAttribute[4];

        gesamtEinträge.add(neuerFilmeintrag);

    }
}
