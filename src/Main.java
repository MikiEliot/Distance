
public class Main {
    public static void main(String[] args) {
        //instanciation de la variable nouveau
        CalculDistance nouveau = new CalculDistance();

        // Instanciation de la variable 'a' de type VillesLatLon
        // Elle renvoie un résultat constitué d'un tableau de chaînes de caractères 'villes'
        // et d'un tableau bidimensionnel de nombres à virgule 'coordinates'

        VillesLatLon a = nouveau.ChoixVille();
        System.out.println(nouveau.distanceTotale(a.getLatlon()));

        // Mise à jour des tableaux 'villes' et 'coordinates'
        // en fonction du choix précédent de l'utilisateur
        // et reset de la distance
        nouveau.villes = a.getChoixVillesFinal();
        nouveau.distance = 0;
        nouveau.coordinates = a.getLatlon();
        Modificateur.modificateur(nouveau);




        /*for (String ville : a.getChoixVillesFinal()) {
            System.out.print(ville + " ");
        }
        System.out.println();


         for (double[] coordinate : nouveau.coordinates) {
            System.out.println(coordinate[0] + "  " +  coordinate[1]);
        }

        System.out.println();

        for (String city : nouveau.villes) {
            System.out.println(city);
        }*/


    }

}