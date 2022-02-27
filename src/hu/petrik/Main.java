package hu.petrik;

public class Main {

    public static void main(String[] args) {
        Fuvarok f = new Fuvarok("fuvar.csv");
        System.out.println(f.getFuvarszam() + " db");
        System.out.println("A bevétel: " +f.getTaxiBevetel(6185) + " Az utak száma: "+f.getTaxiUt(6185));
        System.out.println(f.getOsszMerfold() + " mérföldet tettek meg.");
        System.out.println(f.getMaxMerfold());
        System.out.println(f.getLegBokezubb());
        System.out.println(f.getTavolsagKmben(4261));
        System.out.println(f.getHiba());
        System.out.println(f.getIdoHiba());
        System.out.println(f.getBevetelHiba());
        System.out.println(f.Bennevan(1452) != null ? "Benne van": "Nem található");
        System.out.println(f.getLegrovidebbUt(3));
        System.out.println(f.getDec24Fuvar());
        System.out.println(f.getBorravaloDec31());
    }
}
