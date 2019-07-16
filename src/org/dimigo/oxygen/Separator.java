package org.dimigo.oxygen;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public int CalchargeNum(String str) {
        if (str.length() == 1) {
            if (str.equals("+")) {
                return 1;
            } else if (str.equals("-")) {
                return -1;
            }
        } else if (str.length() == 2) {
            String strstr = str.substring(1);
            String num = str.substring(0, 1);
            if (strstr.equals("+")) {
                return Integer.parseInt(num);
            } else if (strstr.equals("-")) {
                return (Integer.parseInt(num) * -1);
            }
        }
        return 0;
    }

    public static List<Atom> getAtomsByString(String synthetic) {
        List<Atom> inputs = bracket(synthetic);
        List<Atom> results = new ArrayList<>();

        for (Atom atom : inputs) {
            List<Atom> atoms = separate(atom.symbol);
            for (Atom a : atoms) {
                a.number *= atom.number;
                results.add(a);
            }
        }

        return results;
    }

    private static List<Atom> bracket(String synthetic) {
        char[] solute = synthetic.toCharArray();
        List<Atom> results = new ArrayList<>();
        int startIndex = 0;

        for (int i = 0; i < solute.length; ) {

            if (solute[i] == '(') {
                results.add(new Atom(1, String.copyValueOf(solute).substring(startIndex, i)));
                startIndex = ++i;

                while (i < solute.length && solute[i] != ')') {
                    i++;
                }

                if (i + 1 < solute.length && solute[i + 1] >= '0' && solute[i + 1] <= '9') {
                    results.add(new Atom(Integer.parseInt(String.copyValueOf(solute).substring(i + 1, i + 2)), String.copyValueOf(solute).substring(startIndex, i)));
                    i++;
                } else {
                    results.add(new Atom(1, String.copyValueOf(solute).substring(startIndex, i)));
                }

                startIndex = ++i;
            } else {
                i++;
            }

            if (i >= solute.length) {
                results.add(new Atom(1, String.copyValueOf(solute).substring(startIndex, i)));
            }
        }
        return results;
    }

    private static List<Atom> separate(String synthetic) {
        char[] solute = synthetic.toCharArray();
        List<Atom> results = new ArrayList<>();

        for (int i = 0; i < solute.length; ) {
            int startIndex = 0;
            if (solute[i] >= 'A' && solute[i] <= 'Z') {
                startIndex = i;
                i++;

                while (i < solute.length && !(solute[i] >= 'A' && solute[i] <= 'Z')) {
                    i++;
                }

                if (solute[i - 1] >= '0' && solute[i - 1] <= '9' && solute[i - 2] >= '0' && solute[i - 2] <= '9' && solute[i - 3] >= '0' && solute[i - 3] <= '9') {
                    results.add(new Atom(Integer.parseInt(String.copyValueOf(solute).substring(i - 3, i)), String.copyValueOf(solute).substring(startIndex, i - 3)));
                } else if (solute[i - 1] >= '0' && solute[i - 1] <= '9' && solute[i - 2] >= '0' && solute[i - 2] <= '9') {
                    results.add(new Atom(Integer.parseInt(String.copyValueOf(solute).substring(i - 2, i)), String.copyValueOf(solute).substring(startIndex, i - 2)));
                } else if (solute[i - 1] >= '0' && solute[i - 1] <= '9') {
                    results.add(new Atom(Integer.parseInt(String.copyValueOf(solute).substring(i - 1, i)), String.copyValueOf(solute).substring(startIndex, i - 1)));
                } else {
                    results.add(new Atom(1, String.copyValueOf(solute).substring(startIndex, i)));
                }
            } else {
                i++;
            }
        }

        return results;
    }
}
