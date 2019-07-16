package org.dimigo.oxygen;

public class Atom {
    public int number;
    public String symbol;

    public Atom(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public String toString() {
        return symbol + " " + number + "개";
    }
}
