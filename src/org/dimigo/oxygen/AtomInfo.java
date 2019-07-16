package org.dimigo.oxygen;
import java.util.HashMap;
import java.util.Map;

public class AtomInfo {
    private int number;
    private double mass;

    private static Map<String, AtomInfo> atoms;

    private AtomInfo(int number, double mass) {
        this.number = number;
        this.mass = mass;
    }

    public AtomInfo() {
    }

    public static double getMassDouble(String name) {
        return atoms.get(name).getMass();
    }

    public static int getMassInt(String name) {
        return (int)Math.round(atoms.get(name).getMass());
    }

    public static int getNumber(String symbol) {
        try {
            return atoms.get(symbol).number;
        }
        catch (Throwable t) {
            t.printStackTrace();
            return 0;
        }
    }

    static {
        atoms = new HashMap<>();
        atoms.put(null, new AtomInfo(0, 0));
        atoms.put("H", new AtomInfo(1, 1.008));
        atoms.put("He", new AtomInfo(2, 4.002602));
        atoms.put("Li", new AtomInfo(3, 6.94));
        atoms.put("Be", new AtomInfo(4, 9.0121831));
        atoms.put("B", new AtomInfo(5, 10.81));
        atoms.put("C", new AtomInfo(6, 12.011));
        atoms.put("N", new AtomInfo(7, 14.007));
        atoms.put("O", new AtomInfo(8, 15.999));
        atoms.put("F", new AtomInfo(9, 18.998403163));
        atoms.put("Ne", new AtomInfo(10, 20.1797));
        atoms.put("Na", new AtomInfo(11, 22.98976928));
        atoms.put("Mg", new AtomInfo(12, 24.305));
        atoms.put("Al", new AtomInfo(13, 26.9815385));
        atoms.put("Si", new AtomInfo(14, 28.085));
        atoms.put("P", new AtomInfo(15, 30.973761998));
        atoms.put("S", new AtomInfo(16, 32.06));
        atoms.put("Cl", new AtomInfo(17, 35.45));
        atoms.put("Ar", new AtomInfo(18, 39.948));
        atoms.put("K", new AtomInfo(19, 39.0983));
        atoms.put("Ca", new AtomInfo(20, 40.078));
        atoms.put("Sc", new AtomInfo(21, 44.955908));
        atoms.put("Ti", new AtomInfo(22, 47.867));
        atoms.put("V", new AtomInfo(23, 50.9415));
        atoms.put("Cr", new AtomInfo(24, 51.9961));
        atoms.put("Mn", new AtomInfo(25, 54.938044));
        atoms.put("Fe", new AtomInfo(26, 55.845));
        atoms.put("Co", new AtomInfo(27, 58.933194));
        atoms.put("Ni", new AtomInfo(28, 58.6934));
        atoms.put("Cu", new AtomInfo(29, 63.546));
        atoms.put("Zn", new AtomInfo(30, 65.38));
        atoms.put("Ga", new AtomInfo(31, 69.723));
        atoms.put("Ge", new AtomInfo(32, 72.630));
        atoms.put("As", new AtomInfo(33, 74.921595));
        atoms.put("Se", new AtomInfo(34, 78.971));
        atoms.put("Br", new AtomInfo(35, 79.904));
        atoms.put("Kr", new AtomInfo(36, 83.798));
        atoms.put("Rb", new AtomInfo(37, 85.4678));
        atoms.put("Sr", new AtomInfo(38, 87.62));
        atoms.put("Y", new AtomInfo(39, 88.90584));
        atoms.put("Zr", new AtomInfo(40, 91.224));
        atoms.put("Nb", new AtomInfo(41, 92.90637));
        atoms.put("Mo", new AtomInfo(42, 95.95));
        atoms.put("Tc", new AtomInfo(43, 98));
        atoms.put("Ru", new AtomInfo(44, 101.07));
        atoms.put("Rh", new AtomInfo(45, 102.90550));
        atoms.put("Pd", new AtomInfo(46, 106.42));
        atoms.put("Ag", new AtomInfo(47, 107.8862));
        atoms.put("Cd", new AtomInfo(48, 112.414));
        atoms.put("In", new AtomInfo(49, 114.818));
        atoms.put("Sn", new AtomInfo(50, 118.710));
        atoms.put("Sb", new AtomInfo(51, 121.760));
        atoms.put("Te", new AtomInfo(52, 127.60));
        atoms.put("I", new AtomInfo(53, 126.90447));
        atoms.put("Xe", new AtomInfo(54, 131.293));
        atoms.put("Cs", new AtomInfo(55, 132.90545196));
        atoms.put("Ba", new AtomInfo(56, 137.327));
        atoms.put("La", new AtomInfo(57, 138.90547));
        atoms.put("Ce", new AtomInfo(58, 140.116));
        atoms.put("Pr", new AtomInfo(59, 140.90766));
        atoms.put("Nd", new AtomInfo(60, 144.242));
        atoms.put("Pm", new AtomInfo(61, 145));
        atoms.put("Sm", new AtomInfo(62, 150.36));
        atoms.put("Eu", new AtomInfo(63, 151.964));
        atoms.put("Gd", new AtomInfo(64, 157.25));
        atoms.put("Tb", new AtomInfo(65, 158.92535));
        atoms.put("Dy", new AtomInfo(66, 162.500));
        atoms.put("Ho", new AtomInfo(67, 164.93033));
        atoms.put("Er", new AtomInfo(68, 167.259));
        atoms.put("Tm", new AtomInfo(69, 168.93422));
        atoms.put("Yb", new AtomInfo(70, 173.045));
        atoms.put("Lu", new AtomInfo(71, 174.9668));
        atoms.put("Hf", new AtomInfo(72, 178.49));
        atoms.put("Ta", new AtomInfo(73, 180.94788));
        atoms.put("W", new AtomInfo(74, 183.84));
        atoms.put("Re", new AtomInfo(75, 186.207));
        atoms.put("Os", new AtomInfo(76, 190.23));
        atoms.put("Ir", new AtomInfo(77, 192.217));
        atoms.put("Pt", new AtomInfo(78, 195.084));
        atoms.put("Au", new AtomInfo(79, 196.966569));
        atoms.put("Hg", new AtomInfo(80, 200.592));
        atoms.put("Tl", new AtomInfo(81, 204.38));
        atoms.put("Pb", new AtomInfo(82, 207.2));
        atoms.put("Bi", new AtomInfo(83, 208.98040));
        atoms.put("Po", new AtomInfo(84, 209));
        atoms.put("At", new AtomInfo(85, 210));
        atoms.put("Rn", new AtomInfo(86, 222));
        atoms.put("Fr", new AtomInfo(87, 223));
        atoms.put("Ra", new AtomInfo(88, 226));
        atoms.put("Ac", new AtomInfo(89, 227));
        atoms.put("Th", new AtomInfo(90, 232.0377));
        atoms.put("Pa", new AtomInfo(91, 231.03588));
        atoms.put("U", new AtomInfo(92, 238.02891));
        atoms.put("Np", new AtomInfo(93, 237));
        atoms.put("Pu", new AtomInfo(94, 244));
        atoms.put("Am", new AtomInfo(95, 243));
        atoms.put("Cm", new AtomInfo(96, 247));
        atoms.put("Bk", new AtomInfo(97, 247));
        atoms.put("Cf", new AtomInfo(98, 251));
        atoms.put("Es", new AtomInfo(99, 252));
        atoms.put("Fm", new AtomInfo(100, 257));
        atoms.put("Md", new AtomInfo(101, 258));
        atoms.put("No", new AtomInfo(102, 259));
        atoms.put("Lr", new AtomInfo(103, 266));
        atoms.put("Rf", new AtomInfo(104, 267));
        atoms.put("Db", new AtomInfo(105, 268));
        atoms.put("Sg", new AtomInfo(106, 269));
        atoms.put("Bh", new AtomInfo(107, 270));
        atoms.put("Hs", new AtomInfo(108, 277));
        atoms.put("Mt", new AtomInfo(109, 278));
        atoms.put("Ds", new AtomInfo(110, 281));
        atoms.put("Rg", new AtomInfo(111, 282));
        atoms.put("Cn", new AtomInfo(112, 285));
        atoms.put("Nh", new AtomInfo(113, 286));
        atoms.put("Fl", new AtomInfo(114, 289));
        atoms.put("Mc", new AtomInfo(115, 290));
        atoms.put("Lv", new AtomInfo(116, 293));
        atoms.put("Ts", new AtomInfo(117, 294));
        atoms.put("Og", new AtomInfo(118, 294));
    }

    public static Map<String, AtomInfo> getAtoms() {
        return atoms;
    }

    public int getNumber() {
        return number;
    }

    public double getMass() {
        return mass;
    }

}