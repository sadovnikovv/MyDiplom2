package com.example.dellinspironn5110.mydiplom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


//public class Activity3 extends AppCompatActivity {
public class Activity4 extends AppCompatActivity {

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
    EditText znun17;
    EditText znun18;
    EditText znun19;
    EditText znun20;
    EditText znun21;
    EditText znun22;
    EditText znun23;
    EditText znun24;
    EditText znun25;
    EditText znun26;
    EditText znun27;
    EditText znun28;
    EditText znun29;
    EditText znun30;
    EditText znun31;
    EditText znun32;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

    }

    public void jButton1ActionPerformed(View v) {//GEN-FIRST:event_jButton1ActionPerformed
        long timestamp1 = System.currentTimeMillis();
        znun1 = (EditText) findViewById(R.id.editText1);
        znun2 = (EditText) findViewById(R.id.editText2);
        znun3 = (EditText) findViewById(R.id.editText3);
        znun4 = (EditText) findViewById(R.id.editText4);
        znun5 = (EditText) findViewById(R.id.editText5);
        znun6 = (EditText) findViewById(R.id.editText6);
        znun7 = (EditText) findViewById(R.id.editText7);
        znun8 = (EditText) findViewById(R.id.editText8);
        znun9 = (EditText) findViewById(R.id.editText9);
        znun10 = (EditText) findViewById(R.id.editText10);
        znun11 = (EditText) findViewById(R.id.editText11);
        znun12 = (EditText) findViewById(R.id.editText12);
        znun13 = (EditText) findViewById(R.id.editText13);
        znun14 = (EditText) findViewById(R.id.editText14);
        znun15 = (EditText) findViewById(R.id.editText15);
        znun16 = (EditText) findViewById(R.id.editText16);
        znun17 = (EditText) findViewById(R.id.editText17);
        znun18 = (EditText) findViewById(R.id.editText18);
        znun19 = (EditText) findViewById(R.id.editText19);
        znun20 = (EditText) findViewById(R.id.editText20);
        znun21 = (EditText) findViewById(R.id.editText21);
        znun22 = (EditText) findViewById(R.id.editText22);
        znun23 = (EditText) findViewById(R.id.editText23);
        znun24 = (EditText) findViewById(R.id.editText24);
        znun25 = (EditText) findViewById(R.id.editText25);
        znun26 = (EditText) findViewById(R.id.editText26);
        znun27 = (EditText) findViewById(R.id.editText27);
        znun28 = (EditText) findViewById(R.id.editText28);
        znun29 = (EditText) findViewById(R.id.editText29);
        znun30 = (EditText) findViewById(R.id.editText30);
        znun31 = (EditText) findViewById(R.id.editText31);
        znun32 = (EditText) findViewById(R.id.editText32);

        JacobiSolve2 jacobi = new JacobiSolve2();
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
        //формируем матрицу Z - мнимую часть исходной матрицы
        createMatrixZ(Z);
        jacobi.comeig(n, itcount, A, Z, T_R, U_R, T_L, U_L);

        printDoubleMatrix1(A, "A");
        printDoubleMatrix2(Z, "Z");
        long timestamp2 = System.currentTimeMillis();

        System.out.println("time elapsed: " + (timestamp2 - timestamp1));
        TextView resText2 = (TextView) findViewById(R.id.result2);
        resText2.setText("Время подсчёта: " + (timestamp2 - timestamp1));
    }

    void printDoubleMatrix1(double matrix[][], String name) {
        TextView resText = (TextView) findViewById(R.id.Result3);
        resText.setText("Собственные значения\n" + "Матрица А: \n" +
                Double.toString(matrix[1][1]) + "  " + Double.toString(matrix[1][2]) + "  " +
                Double.toString(matrix[1][3]) + "  " + Double.toString(matrix[1][4]) + "\n\n" +
                Double.toString(matrix[2][1]) + "  " + Double.toString(matrix[2][2]) + "  " +
                Double.toString(matrix[2][3]) + "  " + Double.toString(matrix[2][4]) + "\n\n" +
                Double.toString(matrix[3][1]) + "  " + Double.toString(matrix[3][2]) + "  " +
                Double.toString(matrix[3][3]) + "  " + Double.toString(matrix[3][4]) + "\n\n" +
                Double.toString(matrix[4][1]) + "  " + Double.toString(matrix[4][2]) + "  " +
                Double.toString(matrix[4][3]) + "  " + Double.toString(matrix[4][4]));
    }

    void printDoubleMatrix2(double matrix[][], String name) {
        TextView resText = (TextView) findViewById(R.id.Result4);
        resText.setText("Собственные значения\n" + "Матрица Z: \n" +
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
        A[1][2] = SupportConverterEditText.convertToInt(znun3.getText().toString());
        A[1][3] = SupportConverterEditText.convertToInt(znun5.getText().toString());
        A[1][4] = SupportConverterEditText.convertToInt(znun7.getText().toString());

        A[2][1] = SupportConverterEditText.convertToInt(znun9.getText().toString());
        A[2][2] = SupportConverterEditText.convertToInt(znun11.getText().toString());
        A[2][3] = SupportConverterEditText.convertToInt(znun13.getText().toString());
        A[2][4] = SupportConverterEditText.convertToInt(znun15.getText().toString());

        A[3][1] = SupportConverterEditText.convertToInt(znun17.getText().toString());
        A[3][2] = SupportConverterEditText.convertToInt(znun19.getText().toString());
        A[3][3] = SupportConverterEditText.convertToInt(znun21.getText().toString());
        A[3][4] = SupportConverterEditText.convertToInt(znun23.getText().toString());

        A[4][1] = SupportConverterEditText.convertToInt(znun25.getText().toString());
        A[4][2] = SupportConverterEditText.convertToInt(znun27.getText().toString());
        A[4][3] = SupportConverterEditText.convertToInt(znun29.getText().toString());
        A[4][4] = SupportConverterEditText.convertToInt(znun31.getText().toString());
    }

    void createMatrixZ(double Z[][]) {
        Z[1][1] = SupportConverterEditText.convertToInt(znun2.getText().toString());
        Z[1][2] = SupportConverterEditText.convertToInt(znun4.getText().toString());
        Z[1][3] = SupportConverterEditText.convertToInt(znun6.getText().toString());
        Z[1][4] = SupportConverterEditText.convertToInt(znun8.getText().toString());

        Z[2][1] = SupportConverterEditText.convertToInt(znun10.getText().toString());
        Z[2][2] = SupportConverterEditText.convertToInt(znun12.getText().toString());
        Z[2][3] = SupportConverterEditText.convertToInt(znun14.getText().toString());
        Z[2][4] = SupportConverterEditText.convertToInt(znun16.getText().toString());

        Z[3][1] = SupportConverterEditText.convertToInt(znun18.getText().toString());
        Z[3][2] = SupportConverterEditText.convertToInt(znun20.getText().toString());
        Z[3][3] = SupportConverterEditText.convertToInt(znun22.getText().toString());
        Z[3][4] = SupportConverterEditText.convertToInt(znun24.getText().toString());

        Z[4][1] = SupportConverterEditText.convertToInt(znun26.getText().toString());
        Z[4][2] = SupportConverterEditText.convertToInt(znun28.getText().toString());
        Z[4][3] = SupportConverterEditText.convertToInt(znun30.getText().toString());
        Z[4][4] = SupportConverterEditText.convertToInt(znun32.getText().toString());
    }
}




