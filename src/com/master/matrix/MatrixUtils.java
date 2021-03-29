package com.master.matrix;

import java.math.BigDecimal;

import com.liuzhen.app.util.BigDecimalUtils;
import com.liuzhen.app.util.StringUtils;

/**
 * @class: MatrixUtils
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/22 13:28
 */
public class MatrixUtils {

	public static MatrixModel create(String name, int row, int col, CellModel... cells) {
		if (StringUtils.isBlank(name)) {
			int code = (int) (Math.random()*26) + 65;
			name = ((char) code) + "";
		}
		MatrixModel matrixModel = new MatrixModel(name, row, col);
		CellModel[][] matrix = matrixModel.getMatrix();
		String x = name.toLowerCase();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = new CellModel(i, j, x + (i + 1) + "," + (j + 1 ), null);
			}
		}
		if (cells != null) {
			// todo
		}
		return matrixModel;
	}
	
	public static void print(MatrixModel matrix) {
		print(matrix, 0);
	}
	
	public static void print(MatrixModel matrix, int mode) {
		if (matrix == null) {
			System.out.println("该矩阵为空");
		}
		System.out.println("矩阵【" + matrix.getName() + "】有" + matrix.getRow() + "行," + matrix.getCol() + "列");
		for (int i = 0; i < matrix.getMatrix().length; i++) {
			for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
				switch (mode) {
					case 1:
						System.out.print(matrix.getMatrix()[i][j].getExpression());
						break;
					default:
						System.out.print(matrix.getMatrix()[i][j].getName());
						break;
				}
				if (j < matrix.getMatrix()[i].length - 1) {
					System.out.print("\t\t");
				}
			}
			System.out.println();
		}
	}
	
	public static MatrixModel transpose(MatrixModel matrix) {
		MatrixModel r = create(matrix.getName() + "T", matrix.getCol(), matrix.getRow());
		for (int i = 0; i < matrix.getMatrix().length; i++) {
			for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
				r.getMatrix()[j][i] = matrix.getMatrix()[i][j];
			}
		}
		return r;
	}
	
	public static MatrixModel multi(MatrixModel... a) {
		if (a == null || a.length == 0) {
			System.out.println("空数组乘个毛线啊");
			return null;
		}
		MatrixModel result = a[0];
		for (int i = 1; i < a.length; i++) {
			result = multi(result, a[i]);
		}
		return result;
	}

	public static MatrixModel multi(MatrixModel a, MatrixModel b) {
		if (a.getCol() != b.getRow()) {
			System.out.println("【error】第一个矩阵" + a.getName() + "的列数(" + a.getCol() + ")不等于第二个矩阵" + b.getName() + "的行数(" + b.getRow() + ")");
			return null;
		}
		MatrixModel result = create(null, a.getRow(), b.getCol());
		CellModel[][] aArr = a.getMatrix();
		CellModel[][] bArr = b.getMatrix();
		CellModel[][] rArr = result.getMatrix();
		
		for (int i = 0; i < a.getRow(); i++) {
			for (int j = 0; j < b.getCol(); j++) {
				StringBuilder expression = new StringBuilder();
				BigDecimal value = BigDecimal.ZERO;
				for (int k = 0; k < a.getCol(); k++) {
					CellModel aCell = aArr[i][k];
					CellModel bTCell = bArr[k][j];
					value = BigDecimalUtils.add(value, aCell.getValue(), bTCell.getValue());
					if (k > 0) {
						expression.append(" + ");
					}
					expression.append(getExpression(aCell)).append("*").append(getExpression(bTCell));
				}
				rArr[i][j].setValue(value);
				rArr[i][j].setExpression(expression.toString());
			}
		}
		return result;
	}
	
	
	
	private static String getExpression(CellModel c) {
		return StringUtils.isNotBlank(c.getExpression()) ? "(" + c.getExpression() + ")" : c.getName();
	}
}
