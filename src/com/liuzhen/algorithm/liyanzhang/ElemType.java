package com.liuzhen.algorithm.liyanzhang;
/*
 * @class: ElemType
 * @description: 原子
 * @author: L.zhen
 * @date: 2018/4/13 18:01
 */
public class ElemType implements Element {
	
	public ElemType(int value) {
		this.value = value;
	}
	
	/*
	 * 原子的数值
	 */
	public int value;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ElemType) {
			return this.value == ((ElemType) obj).value;
		}
		return super.equals(obj);
	}
}
