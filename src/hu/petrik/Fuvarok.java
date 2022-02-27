package hu.petrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Fuvarok {
    private List<Fuvar> fuvarLista;

    public Fuvarok(String filename) {
        fuvarLista = new LinkedList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));

            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                fuvarLista.add(new Fuvar(sor));
                sor = br.readLine();
            }

            br.close();

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

    public double getTaxiBevetel(int id){
        return fuvarLista.stream()
                .filter(m -> m.getTaxi_id() == id)
                .mapToDouble(m -> m.getViteldij() + m.getBorravalo())
                .sum();
    }

    public long getTaxiUt(int id) {
        return fuvarLista.stream()
                .filter(m -> m.getTaxi_id() == id)
                .count();
    }


    public double getOsszMerfold() {
        return  fuvarLista.stream()
                .mapToDouble(m -> m.getTavolsag())
                .sum();
    }

    public Fuvar getMaxMerfold() {
        return fuvarLista. stream()
                .max(Comparator.comparingDouble(Fuvar::getTavolsag))
                .get();
    }

    public Fuvar getLegBokezubb() {
        return fuvarLista.stream()
                .max(Comparator.comparingDouble(m -> m.getBorravalo()/m.getViteldij()))
                .get();
    }

    public double getTavolsagKmben(int id) {
        return fuvarLista.stream()
                .filter(m -> m.getTaxi_id() == id)
                .mapToDouble(m -> m.getTavolsag()*1.6)
                .sum();
    }

    public int getHiba() {
        return fuvarLista.stream()
                .filter(futar -> futar.getViteldij() > 0 && futar.getIdotartam() > 0 && futar.getTavolsag() == 0)
                .toList()
                .size();
    }

    public int getIdoHiba() {
        return fuvarLista.stream()
                .filter(futar -> futar.getViteldij() > 0 && futar.getIdotartam() > 0 && futar.getTavolsag() == 0)
                .mapToInt(Fuvar::getIdotartam)
                .sum();
    }

    public double getBevetelHiba(){
        return fuvarLista.stream()
                .filter(futar -> futar.getViteldij() > 0 && futar.getIdotartam() > 0 && futar.getTavolsag() == 0)
                .mapToDouble(f -> f.getViteldij()+f.getBorravalo())
                .sum();
    }

    public Fuvar Bennevan(int id){
        try{
            return fuvarLista.stream()
                    .filter(f -> f.getTaxi_id() == id)
                    .findAny().
                    get();
        }catch (Exception e){
            return null;
        }
    }

    public List<Fuvar> getLegrovidebbUt(int dbszam) {
        return fuvarLista.stream()
                .filter(futar -> futar.getIdotartam() > 0)
                .sorted(Comparator.comparingInt(Fuvar::getIdotartam))
                .distinct()
                .limit(dbszam).toList();
    }

    public long getDec24Fuvar() {
        LocalDateTime dec24Eleje =  LocalDateTime.of(2016,12,24 , 0,0);
        LocalDateTime dec24Vege = LocalDateTime.of(2016,12,24 , 23,59);
        return fuvarLista.stream()
                .filter(f -> f.getIndulas().isBefore(dec24Vege) && f.getIndulas().isAfter(dec24Eleje))
                .count();
    }

    public double getBorravaloDec31() {
        LocalDateTime dec31Eleje =  LocalDateTime.of(2016,12,31 , 0,0);
        LocalDateTime dec31Vege = LocalDateTime.of(2016,12,31 , 23,59);
        return fuvarLista.stream()
                .filter(f -> f.getIndulas().isBefore(dec31Vege) && f.getIndulas().isAfter(dec31Eleje))
                .count();
    }



}
