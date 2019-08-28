package ru.job4j.profession;

import java.awt.*;

public class Doctor extends Profession {

    public Diagnose heal(Pacient pacient) {

        return null;
    }

    private static class Pacient {
        String namePacient;
    }

    private class Diagnose {
    }
}
