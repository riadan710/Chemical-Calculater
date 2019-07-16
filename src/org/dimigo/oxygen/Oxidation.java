package org.dimigo.oxygen;

import java.util.Scanner;

public class Oxidation {
    public static void main(String[] args) {
        System.out.println("입력예시 : MnO4(-)");

        System.out.print("화학식을 입력예시대로 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        String chemical;
        chemical = scan.nextLine();

        int start = 0;
        int end = 0;
        int chargeNum = 0;
        String chargeStr;
        Separator separator = new Separator();
        AtomInfo atomInfo = new AtomInfo();

        if (chemical.contains("(")) {       // 전하량이 있는 경우 (이온)
            start = chemical.indexOf("(");
            end = chemical.indexOf(")");

            chargeStr = chemical.substring(start + 1, end);
            chargeNum = separator.CalchargeNum(chargeStr);          // 전하량
            chemical = chemical.substring(0, start);
        }

        int inovation_num = separator.getAtomsByString(chemical).size();       // 원자 갯수
        String inovation;
        int[] oxidation = new int[inovation_num];

        if (inovation_num == 1 && chargeNum == 0) {         // 이온X
            oxidation[0] = 0;
        } else if (inovation_num == 1) {                    // 단원자 이온
            oxidation[0] = chargeNum;
        } else {                                            // 화합물
            for (int i = 0; i < inovation_num; i++) {
                inovation = separator.getAtomsByString(chemical).get(i).symbol;

                String backStr = "";
                String forwardStr = "";
                int backNum = 0;
                int forwardNum = 0;
                if (i != 0) {
                    backStr = separator.getAtomsByString(chemical).get(i - 1).symbol;
                    backNum = atomInfo.getNumber(backStr);
                }
                if (i != inovation_num - 1) {
                    forwardStr = separator.getAtomsByString(chemical).get(i + 1).symbol;
                    forwardNum = atomInfo.getNumber(forwardStr);
                }

                if (inovation.equals("H")) {
                    if ((backNum > 2 && backNum % 8 >= 3 && backNum % 8 <= 4) || (forwardNum > 2 && forwardNum % 8 >= 3 && forwardNum % 8 <= 4)) {      // 금속 수소화물
                        System.out.println("dd");
                        oxidation[i] = -1 * separator.getAtomsByString(chemical).get(i).number;
                    } else {
                        oxidation[i] = 1 * separator.getAtomsByString(chemical).get(i).number;
                    }
                } else if (inovation.equals("O")) {
                    if (backStr.equals("F") || forwardStr.equals("F")) {      // 플루오린 화합물
                        oxidation[i] = 2 * separator.getAtomsByString(chemical).get(i).number;
                    } else if (separator.getAtomsByString(chemical).get(i).number == 2) {        // 과산화물
                        oxidation[i] = -1 * separator.getAtomsByString(chemical).get(i).number;
                    } else {
                        oxidation[i] = -2 * separator.getAtomsByString(chemical).get(i).number;
                    }
                } else {
                    if (inovation_num == 2) {

                    }
                }
            }
        }

        System.out.println("< 결과 >");
        for (int i = 0; i < inovation_num; i++) {
            System.out.println(separator.getAtomsByString(chemical).get(i).symbol + "의 산화수 : " + oxidation[i]);
        }
    }
}
