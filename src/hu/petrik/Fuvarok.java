package hu.petrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Fuvarok {
    private List<Fuvar> fuvarLista;

    public Fuvarok(String filename) {
        fuvarLista = new LinkedList<>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                fuvarLista.add(new Fuvar(sor));
                sor = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public long getFuvarszam() {
        return fuvarLista.stream()
                .count();
    }



    public double getMerfold() {
        return  fuvarLista.stream()
                .mapToDouble(m -> m.getTavolsag())
                .sum();
    }

}
