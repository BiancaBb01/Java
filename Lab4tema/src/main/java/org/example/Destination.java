package org.example;

import com.github.javafaker.Faker;

// Clasa pentru o destinație
class Destinatie {
    private String nume;

    public Destinatie(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
}

// Clasa pentru a genera nume aleatoare pentru destinații
class GeneratorNumeDestinatie {
    private final Faker faker;

    public GeneratorNumeDestinatie() {
        this.faker = new Faker();
    }

    public String genereazaNumeDestinatie() {
        return faker.address().city();
    }
}

