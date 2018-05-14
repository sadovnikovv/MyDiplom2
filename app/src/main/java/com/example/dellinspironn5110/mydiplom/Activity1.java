package com.example.dellinspironn5110.mydiplom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


//public class Activity3 extends AppCompatActivity {
public class Activity1 extends AppCompatActivity {

    EditText znun1;
    EditText znun2;
    EditText znun3;
    EditText znun4;
    EditText znun5;
    EditText znun6;
    EditText znun7;
    EditText znun8;
    EditText znun9;
    EditText znun10;
    EditText znun11;
    EditText znun12;
    EditText znun13;
    EditText znun14;
    EditText znun15;
    EditText znun16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void jButton1ActionPerformed(View v) {//GEN-FIRST:event_jButton1ActionPerformed
        long timestamp1 = System.currentTimeMillis();
        znun1 = (EditText) findViewById(R.id.num1);
        znun2 = (EditText) findViewById(R.id.num2);
        znun3 = (EditText) findViewById(R.id.num3);
        znun4 = (EditText) findViewById(R.id.num4);
        znun5 = (EditText) findViewById(R.id.num5);
        znun6 = (EditText) findViewById(R.id.num6);
        znun7 = (EditText) findViewById(R.id.num7);
        znun8 = (EditText) findViewById(R.id.num8);
        znun9 = (EditText) findViewById(R.id.num9);
        znun10 = (EditText) findViewById(R.id.num10);
        znun11 = (EditText) findViewById(R.id.num11);
        znun12 = (EditText) findViewById(R.id.num12);
        znun13 = (EditText) findViewById(R.id.num13);
        znun14 = (EditText) findViewById(R.id.num14);
        znun15 = (EditText) findViewById(R.id.num15);
        znun16 = (EditText) findViewById(R.id.num16);

        JacobiSolve jacobi = new JacobiSolve();
        //размерность матрицы(для начала берем n=4)
        int n = 4;
        //кол-во итераций
        int itcount;
        //матрицa A - действительная часть исходной матрицы
        double A[][] = new double[5][5];
        //матрицa Z - мнимая часть исходной матрицы
        double Z[][] = new double[5][5];
        //матрицы собственных векторов
        double T_R[][] = new double[5][5];
        double U_R[][] = new double[5][5];
        double T_L[][] = new double[5][5];
        double U_L[][] = new double[5][5];
        //кол-во итераций
        itcount = 30;
        //формируем матрицу A - действительную часть исходной матрицы
        createMatrixA(A);
        jacobi.comeig(n, itcount, A, Z, T_R, U_R, T_L, U_L);

        printDoubleMatrix(A, "A");
        long timestamp2 = System.currentTimeMillis();

        System.out.println("time elapsed: " + (timestamp2 - timestamp1));
        TextView resText2 = (TextView) findViewById(R.id.Result2);
        resText2.setText("Время подсчёта: " + (timestamp2 - timestamp1));
    }

    void printDoubleMatrix(double matrix[][], String name) {
        TextView resText = (TextView) findViewById(R.id.Result);
        resText.setText("Собственные значения:\n" +
                Double.toString(matrix[1][1]) + "  " + Double.toString(matrix[1][2]) + "  " +
                Double.toString(matrix[1][3]) + "  " + Double.toString(matrix[1][4]) + "\n\n" +
                Double.toString(matrix[2][1]) + "  " + Double.toString(matrix[2][2]) + "  " +
                Double.toString(matrix[2][3]) + "  " + Double.toString(matrix[2][4]) + "\n\n" +
                Double.toString(matrix[3][1]) + "  " + Double.toString(matrix[3][2]) + "  " +
                Double.toString(matrix[3][3]) + "  " + Double.toString(matrix[3][4]) + "\n\n" +
                Double.toString(matrix[4][1]) + "  " + Double.toString(matrix[4][2]) + "  " +
                Double.toString(matrix[4][3]) + "  " + Double.toString(matrix[4][4]));
    }


    void createMatrixA(double A[][]) {
        A[1][1] = SupportConverterEditText.convertToInt(znun1.getText().toString());
        A[1][2] = SupportConverterEditText.convertToInt(znun2.getText().toString());
        A[1][3] = SupportConverterEditText.convertToInt(znun3.getText().toString());
        A[1][4] = SupportConverterEditText.convertToInt(znun4.getText().toString());

        A[2][1] = SupportConverterEditText.convertToInt(znun5.getText().toString());
        A[2][2] = SupportConverterEditText.convertToInt(znun6.getText().toString());
        A[2][3] = SupportConverterEditText.convertToInt(znun7.getText().toString());
        A[2][4] = SupportConverterEditText.convertToInt(znun8.getText().toString());

        A[3][1] = SupportConverterEditText.convertToInt(znun9.getText().toString());
        A[3][2] = SupportConverterEditText.convertToInt(znun10.getText().toString());
        A[3][3] = SupportConverterEditText.convertToInt(znun11.getText().toString());
        A[3][4] = SupportConverterEditText.convertToInt(znun12.getText().toString());

        A[4][1] = SupportConverterEditText.convertToInt(znun13.getText().toString());
        A[4][2] = SupportConverterEditText.convertToInt(znun14.getText().toString());
        A[4][3] = SupportConverterEditText.convertToInt(znun15.getText().toString());
        A[4][4] = SupportConverterEditText.convertToInt(znun16.getText().toString());
    }

    void createMatrixZ(double Z[][]) {
        Z[1][1] = 0;
        Z[1][2] = 0;
        Z[1][3] = 0;
        Z[1][4] = 0;

        Z[2][1] = 0;
        Z[2][2] = 0;
        Z[2][3] = 0;
        Z[2][4] = 0;

        Z[3][1] = 0;
        Z[3][2] = 0;
        Z[3][3] = 0;
        Z[3][4] = 0;

        Z[4][1] = 0;
        Z[4][2] = 0;
        Z[4][3] = 0;
        Z[4][4] = 0;

    }
}




