import java.util.Scanner;

public class Modificateur {
    public static void modificateur(CalculDistance args) {
            System.out.println("Voulez-vous modifier votre choix ? -2 pour non, 2 pour oui : ");
            Scanner scan = new Scanner(System.in);
            int choix = scan.nextInt();

            switch (choix) {
                case -2:
                    System.out.println("Merci et au revoir :)");
                    System.exit(0);
                    break;
                case 2:
                    VillesLatLon result = args.ChoixVille();
                    System.out.println(args.distanceTotale(result.getLatlon()));
                    break;
                default:
                    System.out.println("Veuillez choisir entre -2 et 2");
            }
        }
    }

