package com.master.matrix;

/**
 * @class: MatrixTest
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/22 13:28
 */
public class MatrixTest {
	
	public static void main(String[] args) {
//		MatrixModel matrixA = MatrixUtils.create(null, 2, 3);
//		MatrixUtils.print(matrixA);
//		MatrixModel matrixB = MatrixUtils.create(null, 3, 2);
//		MatrixUtils.print(matrixB);
//		MatrixModel matrixT = MatrixUtils.transpose(matrixB);
////		MatrixUtils.print(matrixT);
//		MatrixModel matrixC = MatrixUtils.multi(matrixA, matrixB);
//		MatrixUtils.print(matrixC, 1);
//		MatrixModel matrixD = MatrixUtils.multi(matrixB, matrixC);
//		MatrixUtils.print(matrixD, 1);
		
		MatrixModel matrixX = MatrixUtils.create(null, 4, 4);
		MatrixModel result = MatrixUtils.multi(matrixX, matrixX, matrixX);
		MatrixUtils.print(result, 1);
	}
}

