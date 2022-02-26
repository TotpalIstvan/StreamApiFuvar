package hu.petrik;

public class Main {

    public static void main(String[] args) {
        Fuvarok f = new Fuvarok("fuvar.csv");
        System.out.println(f.getFuvarszam() + " db");
        System.out.println(f.getMerfold() + " mérföldet tettek meg.");
        System.out.println(f.getLeghosszabb() + " mp volt leghosszabb út.");
    }
}
