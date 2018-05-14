package com.example.dellinspironn5110.mydiplom;

public class TComplexD {

    protected double Re, Im;
    JacobiConst jacobiconst;
    //final double epsPrecisionD = 1.0E-15;

    public TComplexD() {
        Re = 0;
        Im = 0;
        jacobiconst = new JacobiConst();
    }

    public TComplexD(double x, double y) {
        Re = x;
        Im = y;
        jacobiconst = new JacobiConst();
    }

    public void setTComplexD(double x, double y) {
        Re = x;
        Im = y;
    }

    public void Show() {
        System.out.print("(" + Re + ", " + Im + ")");
    }

    public double getRe() {
        return Re;
    }

    public void setRe(double x) {
        Re = x;
    }

    public double getIm() {
        return Im;
    }

    public void setIm(double y) {
        Re = y;
    }


    /*
     * 	setValue - операция присваивания
     *
     *
     */
    public void setValue(TComplexD z) {
        Re = z.getRe();
        Im = z.getIm();
    }

    /*
     *  function CDABS(C: TComplexD): Extended;
     *	CDABS - модуль комплексного числа.
     *
     */
    public double CDABS() {
        double v, w;

        v = Math.max(Math.abs(getRe()), Math.abs(getIm()));
        w = Math.min(Math.abs(getRe()), Math.abs(getIm()));

        if (Math.abs(v) > jacobiconst.epsPrecisionD)
            return v * (Math.sqrt(1.0 + (w / v) * (w / v)));
        else
            return v * (Math.sqrt(1.0 +
                    (w * v / (v * v + jacobiconst.epsPrecisionD)) * (w * v / (v * v + jacobiconst.epsPrecisionD))));
    }

    /*
     *	CDMinus - вычитание комплексных чисел.
     *	результат умножения запис-ся в вызываемое комплексное число.
     *
     */
    public void CDMinus(TComplexD z) {
        double x, y;
        x = Re - z.getRe();
        y = Im - z.getIm();
        Re = x;
        Im = y;
    }

    /*
     *	CDMult  - умножение комплексных чисел.
     * 	результат умножения запис-ся в вызываемое комплексное число.
     *
     */
    public void CDMult(TComplexD z) {
        double x, y;
        x = Re * z.getRe() - Im * z.getIm();
        y = Im * z.getRe() + Re * z.getIm();
        Re = x;
        Im = y;
    }

    /*
     *	CDDivision  - деление комплексных чисел.
     * 	результат деления запис-ся в вызываемое комплексное число.
     *
     *  делим : z1 / z2 = (a + bi) / (c + di)
     *
     *  получим:
     * 	Re = (ac + bd) / (c*c + d*d)
     *  Im = (bc - ad) / (c*c + d*d)
     */
    public void CDDivision(TComplexD z) {
        double x, y;
        x = (Re * z.getRe() + Im * z.getIm()) / (z.getRe() * z.getRe() + z.getIm() * z.getIm());
        y = (Im * z.getRe() - Re * z.getIm()) / (z.getRe() * z.getRe() + z.getIm() * z.getIm());
        Re = x;
        Im = y;
    }

    /*
     *  CDSwap - меняет местами значение 2х комплексных чисел
     *
     *
     *
     */
    public void CDSwap(TComplexD z) {
        TComplexD temp = new TComplexD();

        temp.setValue(this);
        setValue(z);
        z.setValue(temp);
    }

}
