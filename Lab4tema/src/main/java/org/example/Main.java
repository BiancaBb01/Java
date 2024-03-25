package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GeneratorNumePersoana generatorNumePersoana = new GeneratorNumePersoana();
        GeneratorNumeDestinatie generatorNumeDestinatie = new GeneratorNumeDestinatie();

        // Generarea de persoane aleatoare
        List<Persoana> persoane = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persoane.add(new Persoana(generatorNumePersoana.genereazaNumePersoana()));
        }

        // Generarea de destinații aleatoare
        List<Destinatie> destinatii = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            destinatii.add(new Destinatie(generatorNumeDestinatie.genereazaNumeDestinatie()));
        }

        // Mapare destinație -> persoane care vor să ajungă acolo
        Map<Destinatie, List<Persoana>> persoaneDestinatii = new HashMap<>();
        Random random = new Random();
        for (Destinatie destinatie : destinatii) {
            int numarPersoane = random.nextInt(5) + 1;

            List<Persoana> listaPersoane = new ArrayList<>();
            for (int i = 0; i < numarPersoane; i++) {
                listaPersoane.add(persoane.get(random.nextInt(persoane.size())));
            }
            persoaneDestinatii.put(destinatie, listaPersoane);
        }

        // Creare obiect pentru problema dată
        Problema problema = new Problema(destinatii, persoaneDestinatii);

        // Lista de șoferi
        List<Persoana> soferi = persoane.subList(0, 3); // Selecție aleatorie a 3 șoferi

        // Calcularea listei de destinații trecute de șoferi
        List<Destinatie> destinatiiTrecute = problema.calculeazaDestinatiiTrecute(soferi);
        System.out.println("Destinații trecute de șoferi:");
        destinatiiTrecute.forEach(destinatie -> System.out.println(destinatie.getNume()));

        // Calcularea mapării destinatie -> persoane care vor să ajungă acolo
        Map<Destinatie, List<Persoana>> persoaneLaDestinatii = problema.calculeazaPersoaneDestinatii(persoane);
        System.out.println("\nMapare destinatie -> persoane care vor să ajungă acolo:");
        persoaneLaDestinatii.forEach((destinatie, listaPersoane) -> {
            System.out.println(destinatie.getNume() + ":");
            listaPersoane.forEach(persoana -> System.out.println("- " + persoana.getNume()));
        });

        // Rezolvarea problemei cu algoritmul greedy
        Map<Destinatie, Persoana> asignariGreedy = problema.rezolvaCuGreedy(soferi);
        System.out.println("\nAsignări destinație -> șofer cu algoritmul greedy:");
        asignariGreedy.forEach((destinatie, sofer) -> System.out.println(destinatie.getNume() + " -> " + sofer.getNume()));
    }
}
