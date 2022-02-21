package hu.petrik;

public class Main {

    public static void main(String[] args) {
        Fuvarok f = new Fuvarok("fuvar.csv");
        System.out.println(f.getFuvarszam() + " db");
    }
}
