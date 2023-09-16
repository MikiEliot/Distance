import java.util.Scanner; //importation de l'util scanner pour l'input
import java.lang.Math; // importation de Math pour calculer la formule de Haversine

// Declaration de la classe CalculDistance
public class CalculDistance {

    // Declaration et instanciation des differentes attributes de la classe
    public String[] villes = {"Marseille", "Paris", "Lyon", "Nantes", "Strasbourg", "Clermont-Ferrand", "Brest", "Montpeiller", "Bordeau"};


    public double[][] coordinates = {{43.294633233407446, 5.360762848660331}, {48.8562657050522, 2.358485840370898}, {45.764119854130534, 4.834795304264682}, {47.21812002349995, -1.5524711701104639}, {48.57612198381121, 7.753170681899243}, {45.77985857552555, 3.08506729276061}, {48.38946523452947, -4.497899814507592}, {43.60975845564935, 3.872100917845181}, {44.83834475091774, -0.5798700680235179}};
    public float distance = 0;


    // Déclaration de la méthode ChoixVille avec un objet VillesLatLon comme valeur de retour.
    public VillesLatLon ChoixVille() {

        //instanciation d'une variable scan de type Scanner
        Scanner scan = new Scanner(System.in);
        //Declaration est instanciation d'un tableau de chaînes de caractères choixVille de meme longeur que tableau villes
        String[] choixVilles = new String[villes.length];
        // Déclaration du tableau de chaînes de caractères choixVillesFinal où le programme enregistrera les villes choisies.        String [] choixVillesFinal;
        String[] choixVillesFinal;
        //Déclaration de la variable choix qui va prendre la valeur d'input d'utilisateur
        int choix;
        //Déclaration de la variable nombreVilles qui comptera le nombre des villes choisi
        int nombreVilles = 0;
        System.out.print("Liste des villes disponible : ");
        System.out.println();
        //Affichage de la liste des villes disponible
        for (int i = 0; i < villes.length; i++) {
            System.out.print(i + ". " + villes[i]);
            System.out.println();
        }
        //Boucle do...while pour imposer le choix de deux ville minimum à l'utilisateur

        do {
            System.out.println("Pour calculer la distance entre les villes, veuillez choisir au moins deux villes. ");
            System.out.println("Pour chaque ville, entrez le numéro de l'indice (entre 0 et 8) et appuyez sur Entrée, ou choisissez -1 pour quitter : ");

            choix = scan.nextInt();
            if (choix == -1) {
                if (nombreVilles < 2) {
                    System.out.println("Vous devez choisir au moins deux villes.");
                    choix = 0;
                }
            } else if (choix >= 0 && choix <= 8) {
                choixVilles[nombreVilles] = villes[choix];
                System.out.println("Vous avez choisi : " + villes[choix] + "  , avec indice : " + choix);
                nombreVilles++;
            } else {
                System.out.println("Choix invalide.");
            }
        } while (choix != -1);
        // Instanciation de la variable choixVillesFinal avec la longueur du nombre total de villes choisies.
        choixVillesFinal = new String[nombreVilles];
        // Boucle for pour remplir le tableau avec les noms des villes sans prendre en compte les emplacements null.
        for (int i = 0; i < choixVilles.length; i++) {
            if (choixVilles[i] != null) {
                choixVillesFinal[i] = choixVilles[i];
            }
        }

        //affichage d'ittineraire avec un boucle for
        System.out.print("Votre itinéraire : Vous partez de " + choixVillesFinal[0]);
        if (choixVillesFinal.length == 2) {
            System.out.println(" à " + choixVillesFinal[1]);
        } else if (choixVillesFinal.length > 2) {
            System.out.print(" en passant par ");
            for (int i = 1; i < choixVillesFinal.length - 1; i++) {
                if (i < choixVillesFinal.length - 2) {
                    System.out.print(choixVillesFinal[i] + ", ");
                } else {
                    System.out.print(choixVillesFinal[i] + " ");
                }
            }
        }
        System.out.println();
        System.out.print(" pour enfin arrivée à " + choixVillesFinal[choixVillesFinal.length - 1]);
        System.out.println();



        /* Instanciation de la variable lesIndices en tant que tableau qui enregistre
        les indices (trouvées par methode "getIndex")des villes dans le tableau "villes" pour les utiliser ensuite
        afin de trouver les coordonnées correspondantes dans le tableau "coordinates". */

        int [] lesIndices = new int [choixVillesFinal.length];
        for(int i=0; i<choixVillesFinal.length; i++){
            lesIndices[i] = getIndex(villes, choixVillesFinal[i]);
        }
        /* Déclaration et instanciation d'une variable "latlon" de type tableau
        bidimensionnel double où le programme enregistre les coordonnées des villes choisies. */

        double[][] latlon = new double[lesIndices.length][2];
        int k = 0;

        for (int indice : lesIndices) {
            latlon[k] = coordinates[indice];
            k++;

        }
        // Instanciation d'un objet de type VillesLatLon
        // avec les paramètres choixVillesFinal et latlon.
        VillesLatLon villelatlon = new VillesLatLon(choixVillesFinal, latlon);
        return villelatlon;
    }

    // Définition de la méthode getIndex qui recherche l'indice de la chaîne cible dans le tableau.
    public int getIndex(String[] args, String  target){
        for (int i = 0; i < args.length; i++) {
            // Vérifie si l'élément à l'indice i du tableau est égal à la chaîne cible.
            if (args[i].equals(target)) {
                // Si c'est le cas, renvoie l'indice i.
                return i;
            }

    }
        // Si la chaîne cible n'est pas trouvée, renvoie -1.
        return -1;
    }
    // Cette méthode calcule la distance entre deux points géographiques (latitude et longitude) en utilisant la formule Haversine.
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2){
        // Rayon de la Terre en kilomètres (approximatif).
        final int R = 6371;
        // Conversion des différences de latitude et de longitude en radians.
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Conversion des latitudes en radians.
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        // Retourne la distance calculée en kilomètres.
        return R * c;

    }

    /* Cette méthode calcule la distance totale parcourue en prenant comme argument un tableau bidimensionnel de type double,
     où chaque paire de valeurs (lat1, lon1, lat2, lon2) représente les coordonnées de deux villes consécutives.
     Elle retourne la distance totale en additionnant toutes les étapes du trajet.*/
    public double distanceTotale(double [][] args){
        for (int i = 1; i<args.length; i++){
            distance += calculateDistance(args[i-1][0],args[i-1][1],args[i][0],args[i][1]) ;
        }
        System.out.println("La distance totale de votre trajet est : " + distance + " km. Pensez à faire des pause tout les deux heures. Bonne voyage");
        return distance;
    }



}
