package org.example;

import com.github.javafaker.Faker;

// Clasa pentru o persoană
class Persoana {
    private String nume;

    public Persoana(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
}

// Clasa pentru a genera nume aleatoare pentru persoane
class GeneratorNumePersoana {
    private final Faker faker;

    public GeneratorNumePersoana() {
        this.faker = new Faker();
    }

    public String genereazaNumePersoana() {
        return faker.name().fullName();
    }
}

