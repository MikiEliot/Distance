// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CalculDistance nouveau = new CalculDistance();
        VillesLatLon a = nouveau.ChoixVille();
        System.out.println(nouveau.distanceTotale(a.getLatlon()));
        System.out.print("Villes: ");
        for (String ville : a.getChoixVillesFinal()) {
            System.out.print(ville + " ");
        }
        System.out.println();


    }

}