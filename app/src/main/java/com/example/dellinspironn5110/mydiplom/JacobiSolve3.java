package com.example.dellinspironn5110.mydiplom;

public class JacobiSolve3 {

    public static <T> void swap(T a[][], int i, int j, T b[][], int k, int l) {
        T temp;
        temp = a[i][j];
        a[i][j] = b[k][l];
        b[k][l] = temp;
    }

    public static <T> void printArray(T[][] array) {
        for (int i = 1; i < array[1].length; i++) {
            for (int j = 1; j < array.length; j++) {
                System.out.println("v[" + i + "][" + j + "]= " + array[i][j]);
            }
        }
    }


    public void comeig(int n,
                       int itcount,  //кол-во итераций
                       Double[][] A, //действительная часть матрицы A
                       Double[][] Z, //мнимая         часть матрицы A
                       double T_R[][],
                       double U_R[][],
                       double T_L[][],
                       double U_L[][]) {
        // вычисляются и правая, и левая системы собственных векторов


        double Rvec[];
        int i, itlimit, j, k, k1, m, m9, n1;
        double aki, ami, bv, br, bi;
        double c, c1i, c1r, c2i, c2r, ca, cb, ch, cos2a, cot2x, cotx, cx;
        double d, de, di, diag, dr, e, ei, er, eps, eta, g, hi, hj, hr;
        double isw, max, nc, nd, root1, root2, root;
        double s, s1i, s1r, s2i, s2r, sa, sb, sh, sig, sin2a, sx;
        double tanh, tau, te, tee, tem, tep, tse, zki, zmi;
        boolean mark;


        Rvec = new double[n + 1];
        JacobiConst jacobiconst = new JacobiConst();
        //берем eps = epsPrecisionD
        eps = jacobiconst.epsPrecisionD;

        mark = false;
        n1 = n - 1;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (i == j) {
                    T_R[i][i] = 1.0;
                    T_L[i][i] = 1.0;
                    //break;
                    continue;
                }
                T_R[i][j] = 0;
                T_L[i][j] = 0;
                U_R[i][j] = 0;
                U_L[i][j] = 0;
            }
        }

        //printArray(A);

        itlimit = itcount;
        itcount = 0;

        while ((itcount <= itlimit) && (!mark)) {
            itcount = itcount + 1;
            tau = 0.0;
            diag = 0.0;

            for (k = 1; k <= n; k++) {
                tem = 0;
                for (i = 1; i <= n; i++)
                    if (i != k)

                        tem = tem + Math.abs(A[i][k]) + Math.abs(Z[i][k]);
                tau = tau + tem;
                tep = Math.abs(A[k][k]) + Math.abs(Z[k][k]);
                diag = diag + tep;
                Rvec[k] = tem + tep;
            }

            for (k = 1; k <= n1; k++) {
                max = Rvec[k];
                i = k;
                k1 = k + 1;
                for (j = k1; j <= n; j++) {
                    if (max < Rvec[j]) {
                        max = Rvec[j];
                        i = j;
                    }
                }
                if (i != k) {
                    Rvec[i] = Rvec[k];
                    for (j = 1; j <= n; j++) {
                        /*
                        tep = A[k][j];
                        A[k][j] = A[i][j];
                        A[i][j] = tep;
                        */
                        swap(A, k, j, A, i, j);

       /*                 tep = Z[k][j];
                        Z[k][j] = Z[i][j];
                        Z[i][j] = tep;*/
                        swap(Z, k, j, Z, i, j);
                    }
                    for (j = 1; j <= n; j++) {
                        tep = A[j][k];
                        A[j][k] = A[j][i];
                        A[j][i] = tep;
                        tep = Z[j][k];
                        Z[j][k] = Z[j][i];
                        Z[j][i] = tep;
                        //if right then //  для вычисления правых собственных векторов
                        //begin
                        tep = T_R[j][k];
                        T_R[j][k] = T_R[j][i];
                        T_R[j][i] = tep;
                        tep = U_R[j][k];
                        U_R[j][k] = U_R[j][i];
                        U_R[j][i] = tep;
                        //end
                        //else // для вычисления левых собственных векторов
                        //begin
                        tep = T_L[k][j];
                        T_L[k][j] = T_L[i][j];
                        T_L[i][j] = tep;
                        tep = U_L[k][j];
                        U_L[k][j] = U_L[i][j];
                        U_L[i][j] = tep;
                        //end;
                    }
                }
            }
            if (tau >= 100.0 * eps) {

                mark = true;
                for (k = 1; k <= n1; k++) {
                    k1 = k + 1;
                    for (m = k1; m <= n; m++) {
                        hj = 0.0;
                        hr = 0.0;
                        hi = 0.0;
                        g = 0.0;
                        for (i = 1; i <= n; i++) {
                            if ((i != k) && (i != m)) {
                                hr = hr + A[k][i] * A[m][i] + Z[k][i] * Z[m][i];
                                hr = hr - A[i][k] * A[i][m] - Z[i][k] * Z[i][m];
                                hi = hi + Z[k][i] * A[m][i] - A[k][i] * Z[m][i];
                                hi = hi - A[i][k] * Z[i][m] + Z[i][k] * A[i][m];
                                te = A[i][k] * A[i][k] + Z[i][k] * Z[i][k] + A[m][i] * A[m][i] + Z[m][i] * Z[m][i];
                                tee = A[i][m] * A[i][m] + Z[i][m] * Z[i][m] + A[k][i] * A[k][i] + Z[k][i] * Z[k][i];
                                g = g + te + tee;
                                hj = hj - te + tee;
                            }
                        }
                        br = A[k][m] + A[m][k];
                        bi = Z[k][m] + Z[m][k];
                        er = A[k][m] - A[m][k];
                        ei = Z[k][m] - Z[m][k];
                        dr = A[k][k] - A[m][m];
                        di = Z[k][k] - Z[m][m];

                        te = br * br + ei * ei + dr * dr;
                        tee = bi * bi + er * er + di * di;
                        if (te >= tee) {
                            isw = 1.0;
                            c = br;
                            s = ei;
                            d = dr;
                            de = di;
                            root2 = Math.sqrt(te);
                        } else {
                            isw = -1.0;
                            c = bi;
                            s = -er;
                            d = di;
                            de = dr;
                            root2 = Math.sqrt(tee);
                        }
                        root1 = Math.sqrt(s * s + c * c);
                        sig = -1.0;
                        if (d >= 0.0) sig = 1.0;
                        sa = 0.0;
                        ca = -1.0;
                        if (c >= 0.0) ca = 1.0;
                        if (root1 <= eps) {
                            sx = 0.0;
                            sa = 0.0;
                            cx = 1.0;
                            ca = 1.0;
                            if (isw <= 0.0) {
                                e = ei;
                                bv = -br;
                            } else {
                                e = er;
                                bv = bi;
                            }
                            nd = d * d + de * de;
                        } else {
                            if (Math.abs(s) > eps) {
                                ca = c / root1;
                                sa = s / root1;
                            }
                            cot2x = d / root1;
                            cotx = cot2x + (sig * Math.sqrt(1.0 + cot2x * cot2x));
                            sx = sig / Math.sqrt(1.0 + cotx * cotx);
                            cx = sx * cotx;

                            eta = (er * br + ei * bi) / root1;
                            tse = (br * bi - er * ei) / root1;
                            te = sig * (tse * d - de * root1) / root2;
                            tee = (d * de + root1 * tse) / root2;
                            nd = root2 * root2 + tee * tee;
                            tee = hj * cx * sx;
                            cos2a = ca * ca - sa * sa;
                            sin2a = 2.0 * ca * sa;
                            tem = hr * cos2a + hi * sin2a;
                            tep = hi * cos2a - hr * sin2a;
                            hr = hr * cx * cx - tem * sx * sx - ca * tee;
                            hi = hi * cx * cx + tep * sx * sx - sa * tee;
                            bv = isw * te * ca + eta * sa;
                            e = ca * eta - isw * te * sa;
                        }

                        s = hr - sig * root2 * e;
                        c = hi - sig * root2 * bv;
                        root = Math.sqrt(c * c + s * s);
                        if (root < eps) {
                            cb = 1.0;
                            ch = 1.0;
                            sb = 0.0;
                            sh = 0.0;
                        } else {
                            cb = -c / root;
                            sb = s / root;
                            tee = cb * bv - e * sb;
                            nc = tee * tee;
                            tanh = root / (g + 2.0 * (nc + nd));
                            ch = 1.0 / Math.sqrt(1.0 - tanh * tanh);
                            sh = ch * tanh;
                        }
                        tem = sx * sh * (sa * cb - sb * ca);
                        c1r = cx * ch - tem;
                        c2r = cx * ch + tem;
                        c1i = -sx * sh * (ca * cb + sa * sb);
                        c2i = c1i;
                        tep = sx * ch * ca;
                        tem = cx * sh * sb;
                        s1r = tep - tem;
                        s2r = -tep - tem;
                        tep = sx * ch * sa;
                        tem = cx * sh * cb;
                        s1i = tep + tem;
                        s2i = tep - tem;
                        tem = Math.sqrt(s1r * s1r + s1i * s1i);
                        tep = Math.sqrt(s2r * s2r + s2i * s2i);
                        if (tep > eps) mark = false;
                        if ((tep > eps) && (tem > eps)) {
                            for (i = 1; i <= n; i++) {
                                aki = A[k][i];
                                ami = A[m][i];
                                zki = Z[k][i];
                                zmi = Z[m][i];
                                A[k][i] = c1r * aki - c1i * zki + s1r * ami - s1i * zmi;
                                Z[k][i] = c1r * zki + c1i * aki + s1r * zmi + s1i * ami;
                                A[m][i] = s2r * aki - s2i * zki + c2r * ami - c2i * zmi;
                                Z[m][i] = s2r * zki + s2i * aki + c2r * zmi + c2i * ami;
                                //if not right then //  для вычисления левых собственных векторов
                                //begin
                                aki = T_L[k][i];
                                ami = T_L[m][i];
                                zki = U_L[k][i];
                                zmi = U_L[m][i];
                                T_L[k][i] = c1r * aki - c1i * zki + s1r * ami - s1i * zmi;
                                U_L[k][i] = c1r * zki + c1i * aki + s1r * zmi + s1i * ami;
                                T_L[m][i] = s2r * aki - s2i * zki + c2r * ami - c2i * zmi;
                                U_L[m][i] = s2r * zki + s2i * aki + c2r * zmi + c2i * ami;
                                //end;

                            }
                            for (i = 1; i <= n; i++) {
                                aki = A[i][k];
                                ami = A[i][m];
                                zki = Z[i][k];
                                zmi = Z[i][m];
                                A[i][k] = c2r * aki - c2i * zki - s2r * ami + s2i * zmi;
                                Z[i][k] = c2r * zki + c2i * aki - s2r * zmi - s2i * ami;
                                A[i][m] = -s1r * aki + s1i * zki + c1r * ami - c1i * zmi;
                                Z[i][m] = -s1r * zki - s1i * aki + c1r * zmi + c1i * ami;
                                //if right then //  для вычисления правых собственных векторов
                                //begin
                                aki = T_R[i][k];
                                ami = T_R[i][m];
                                zki = U_R[i][k];
                                zmi = U_R[i][m];
                                T_R[i][k] = c2r * aki - c2i * zki - s2r * ami + s2i * zmi;
                                U_R[i][k] = c2r * zki + c2i * aki - s2r * zmi - s2i * ami;
                                T_R[i][m] = -s1r * aki + s1i * zki + c1r * ami - c1i * zmi;
                                U_R[i][m] = -s1r * zki - s1i * aki + c1r * zmi + c1i * ami;
                                //end;
                            }
                        }
                    }
                }
            } else mark = true;

        }
        //Rvec := nil;
        if (itcount > itlimit) itcount = -itcount;
        printArray(A);
    }//OF COMEIG


}//OF CLASS JacobiSolve
