package com.example.dellinspironn5110.mydiplom;

import org.junit.Test;

import static com.example.dellinspironn5110.mydiplom.JacobiSolve3.printArray;

public class JacobiSolve3Test {

    @Test
    public void swap() {
        Integer[][] a1 = new Integer[][]{
                {1, 2},
                {3, 4}
        };

        printArray(a1);

        JacobiSolve3.swap(a1, 0, 0, a1, 1, 1);

        printArray(a1);
    }
}