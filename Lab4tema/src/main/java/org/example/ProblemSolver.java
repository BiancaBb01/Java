package org.example;

import java.util.*;
import java.util.stream.Collectors;

// Clasa care descrie problema
class Problema {
    private List<Destinatie> destinatii;
    private Map<Destinatie, List<Persoana>> persoaneDestinatii;

    public Problema(List<Destinatie> destinatii, Map<Destinatie, List<Persoana>> persoaneDestinatii) {
        this.destinatii = destinatii;
        this.persoaneDestinatii = persoaneDestinatii;
    }

    public List<Destinatie> calculeazaDestinatiiTrecute(List<Persoana> soferi) {
        return soferi.stream()
                .flatMap(sofer -> persoaneDestinatii.entrySet().stream()
                        .filter(entry -> entry.getValue().contains(sofer))
                        .map(Map.Entry::getKey))
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<Destinatie, List<Persoana>> calculeazaPersoaneDestinatii(List<Persoana> pasageri) {
        Map<Destinatie, List<Persoana>> rezultat = new HashMap<>();
        for (Destinatie destinatie : destinatii) {
            rezultat.put(destinatie, new ArrayList<>());
        }
        for (Map.Entry<Destinatie, List<Persoana>> entry : persoaneDestinatii.entrySet()) {
            Destinatie destinatie = entry.getKey();
            List<Persoana> persoane = entry.getValue();
            for (Persoana pasager : pasageri) {
                if (persoane.contains(pasager)) {
                    rezultat.get(destinatie).add(pasager);
                }
            }
        }
        return rezultat;
    }

    // Algoritmul greedy pentru a asigna un șofer la fiecare destinație
    public Map<Destinatie, Persoana> rezolvaCuGreedy(List<Persoana> soferi) {
        Map<Destinatie, Persoana> asignari = new HashMap<>();
        List<Destinatie> destinatiiNeacoperite = new ArrayList<>(destinatii);

        for (Persoana sofer : soferi) {
            if (destinatiiNeacoperite.isEmpty()) break;

            Destinatie ceaMaiApropiata = null;
            int ceaMaiMicaDistanta = Integer.MAX_VALUE;

            for (Destinatie destinatie : destinatiiNeacoperite) {
                int distanta = calculeazaDistanta(sofer, destinatie);
                if (distanta < ceaMaiMicaDistanta) {
                    ceaMaiMicaDistanta = distanta;
                    ceaMaiApropiata = destinatie;
                }
            }

            asignari.put(ceaMaiApropiata, sofer);
            destinatiiNeacoperite.remove(ceaMaiApropiata);
        }

        return asignari;
    }

    // Simulare a unei funcții de calcul al distanței între șofer și destinație
    private int calculeazaDistanta(Persoana sofer, Destinatie destinatie) {
        // Aici puteți adăuga o logică pentru a calcula distanța reală între șofer și destinație
        // pentru un algoritm de asignare mai precis
        return new Random().nextInt(100); // În acest exemplu, vom folosi distanțe aleatoare
    }
}

