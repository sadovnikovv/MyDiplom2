package com.example.dellinspironn5110.mydiplom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Activity5 extends AppCompatActivity {

    EditText znun1;
    Integer rz = 30; //размерность матрицы


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
    }

    public void jButton1ActionPerformed(View v) {//GEN-FIRST:event_jButton1ActionPerformed
        long timestamp1 = System.currentTimeMillis();
        znun1 = (EditText) findViewById(R.id.num1);
        rz = SupportConverterEditText.convertToInt(znun1.getText().toString());
        if (rz <= 1) rz = 2;


        JacobiSolve jacobi = new JacobiSolve();
        //размерность матрицы(для начала берем n=4)
        int n = rz - 1;
        //кол-во итераций
        int itcount;
        //матрицa A - действительная часть исходной матрицы
        double[][] A = new double[rz][rz];
        //матрицa Z - мнимая часть исходной матрицы
        double[][] Z = new double[rz][rz];
        //матрицы собственных векторов
        double[][] T_R = new double[rz][rz];
        double[][] U_R = new double[rz][rz];
        double[][] T_L = new double[rz][rz];
        double[][] U_L = new double[rz][rz];
        //кол-во итераций
        itcount = 30;
        //формируем матрицу A - действительную часть исходной матрицы
        createMatrixA(A);
        //формируем матрицу Z - мнимую часть исходной матрицы
        createMatrixZ(Z);
        jacobi.comeig(n, itcount, A, Z, T_R, U_R, T_L, U_L);

        //  printDoubleMatrix(A, "A");
        long timestamp2 = System.currentTimeMillis();

        System.out.println("time elapsed: " + (timestamp2 - timestamp1));
        TextView resText6 = (TextView) findViewById(R.id.Result6);
        resText6.setText("Время подсчёта: " + (timestamp2 - timestamp1));
    }

 /*   void printDoubleMatrix(double matrix[][], String name) {
        TextView resText6 = (TextView) findViewById(R.id.Result62);
        for (int i = 1; i <= rz - 1; i++) {
            for (int j = 1; j <= rz - 1; j++) {
                resText6.append("\nA[" + Integer.toString(i) + "][" + Integer.toString(j) + "] = ");
      //          resText6.setText("Значения матрицы:\n");
            }
        }
    }*/


    void createMatrixA(double[][] A) {


        for (int i = 1; i <= rz - 1; i++) {
            for (int j = 1; j <= rz - 1; j++) {
                A[i][j] = Math.random() * 3;
  //              System.out.println("A[" + i + "][" + j + "] = " + A[i][j] + ";");
            }
        }
    }

    void createMatrixZ(double[][] Z) {
        for (int i = 1; i <= rz - 1; i++) {
            for (int j = 1; j <= rz - 1; j++) {
                Z[i][j] = Math.random() * 3;
  //              System.out.println("Z[" + i + "][" + j + "] = " + Z[i][j] + ";");
            }
        }
    }
}




