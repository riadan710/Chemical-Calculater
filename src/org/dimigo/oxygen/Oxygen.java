package org.dimigo.oxygen;

import java.util.*;

public class Oxygen {
    public static void main(String[] args) {
        String[] elmentsSymbol = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ag", "Sn", "Ba", "Pt", "Au", "Hg", "Pb"};
        Map<String, Integer> exceptionElements = new HashMap<>();
        exceptionElements.put("Ag", 47); //은
        exceptionElements.put("Sn", 50); //주석
        exceptionElements.put("Ba", 56); //바륨
        exceptionElements.put("Pt", 78); //백금
        exceptionElements.put("Au", 79); //금
        exceptionElements.put("Hg", 80); //수은
        exceptionElements.put("Pb", 82); //납

        String[][] reactant = new String[][]{              // 반응물
                {"MnO4", "-1"}, {"H", "1"}, {"Sn", "2"}
        };
        String[] array_reactant;       // 반응물 한글자씩 분리하여 임시저장
        int[] arrayNumReactant = new int[reactant.length];        // 반응물들의 산화수 저장

        for (int i = 0; i < reactant.length; i++) {     //반응물의 길이만큼
            array_reactant = reactant[i][0].split("");      // 한글자씩 배열에 분리저장
            String tempReactant = "";       // 원소 한개 임시저장
            int temp = 0;
            boolean cnt = true;
            boolean printCheck = false;     // true이면 출력할 준비가 됨
            String tempt = "";
            for (int j = 0; j < reactant[i][0].length(); j++) { // 글자수만큼
                if (reactant[i][0].length() == 1) {         // H 처럼 한글자인 경우
                    tempReactant = reactant[i][0];
                }

                char c = array_reactant[j].charAt(0);
                int a = (int) c;
                if (a > 'A' && a < 'Z') {
                    if (!cnt) {
                        tempReactant = array_reactant[j - 1];
                        printCheck = true;
                    } else if (reactant[i][0].length() - 1 == j) {
                        tempReactant = array_reactant[j];
                        printCheck = true;
                    }
                    cnt = false;
                } else {
                    if (a >= 50 && a <= 52) {
                        tempReactant = array_reactant[j - 1];
                        temp = Integer.parseInt(array_reactant[j]);
                        printCheck = true;
                    } else {
                        tempReactant = array_reactant[j - 1] + array_reactant[j];
                        printCheck = true;
                    }
                    cnt = true;
                }
                if (printCheck) {          //산화수 계산


                    System.out.println(tempReactant);
                    System.out.println(arrayNumReactant[i]);
                    printCheck = false;
                    System.out.println();
                }
            }
        }
    }
}