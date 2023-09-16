public class VillesLatLon {
    private String[] choixVillesFinal;
    private double[][] latlon;


    //constructeur de la classe VilleLatLon
    public VillesLatLon (String[] choixVillesFinal, double[][] latlon) {
        this.choixVillesFinal = choixVillesFinal;
        this.latlon = latlon;
    }
    public String[] getChoixVillesFinal() {
        return choixVillesFinal;
    }

    public double[][] getLatlon() {
        return latlon;
    }

}
