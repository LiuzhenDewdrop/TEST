package com.liuzhen.algorithm.liyanzhang;

import java.util.HashSet;
import java.util.Set;

/*
 * @class: ChangeUtil
 * @description: 交换工具类
 * @author: L.zhen
 * @date: 2018/4/13 18:00
 */
public class ChangeUtil {
	//	设计一个算法,change(*h,s,t), 将一个广义表中所有原子s 替换成t.
	//	例如,change((a,(a)), a, b) 返回结果为(b, (b)).
	// 表A = ( ( ( 1 ) , 2 ) , ( 3 ) )
	//         ( ( 1 ) , 2 )   ( 3 )
	//           ( 1 )   2       3
	//             1
	
	
	public static void main(String[] args) {
		GLNode g = create(3);
		System.out.println(g.print());
		change(g, new ElemType(1), new ElemType(4));
		System.out.println(g.print());
	}
	
	// nodeSet 用于记录已处理的广义表,防止深度为∞的递归广义表影响运算
	private static Set<GLNode> nodeSet = new HashSet<>();
	
	/*
	 * @title:  change
	 * @description: 交换
	 * @param g		待处理广义表g
	 * @param a		待交换原子a
	 * @param b		交换成原子b
	 * @author: L.zhen
	 * @date:   2018/4/16 16:44
	 */
	private static void change(GLNode g, ElemType a, ElemType b) {
		if (g.elements != null && g.elements.length > 0) {
			for (int i = 0; i < g.elements.length; i++) {
				Element element = g.elements[i];
				if (element instanceof GLNode && nodeSet.add(g)) {
					change((GLNode) element, a, b);
				} else {
					if (element.equals(a)) {
						g.elements[i] = b;
					}
				}
			}
		}
	}
	
	/*
	 * @title:  create
	 * @description: 创建一个广义表
	 * @param i
	 * @return
	 * @author: L.zhen
	 * @date:   2018/4/16 16:41
	 */
	private static GLNode create(int i) {
		switch (i) {
			case 1:
				return create_001();
			case 2:
				return create_002();
			case 3:
				return create_003();
			case 4:
				return create_004();
			default:
				return create_001();
		}
	}
	
	/*
	 * @title:  create_001
	 * @description: 创建方法001
	 * @return
	 * @author: L.zhen
	 * @date:   2018/4/16 16:46
	 */
	private static GLNode create_001() {
		ElemType e1 = new ElemType(1);
		GLNode g1 = new GLNode(1);
		g1.elements[0] = e1;
		ElemType e2 = new ElemType(2);
		GLNode g2 = new GLNode(2);
		g2.elements[0] = g1;
		g2.elements[1] = e2;
		ElemType e3 = new ElemType(3);
		GLNode g3 = new GLNode(1);
		g3.elements[0] = e3;
		GLNode result = new GLNode(2);
		result.elements[0] = g2;
		result.elements[1] = g3;
		return result;
	}
	
	/*
	 * @title:  create_002
	 * @description: 创建方法002
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/4/16 16:46
	 */
	private static GLNode create_002() {
		ElemType e1 = new ElemType(1);
		GLNode g1 = new GLNode(2);
		g1.elements[0] = e1;
		g1.elements[1] = g1;
		return g1;
	}
	
	/*
	 * @title:  create_003
	 * @description: 创建方法003
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/4/16 16:46
	 */
	private static GLNode create_003() {
		ElemType e1 = new ElemType(1);
		GLNode g1 = new GLNode(5);
		g1.elements[0] = e1;
		g1.elements[1] = e1;
		g1.elements[2] = e1;
		g1.elements[3] = e1;
		g1.elements[4] = g1;
		return g1;
	}
	
	/*
	 * @title:  create_004
	 * @description: 创建方法004
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/4/16 16:47
	 */
	private static GLNode create_004() {
		ElemType e1 = new ElemType(1);
		GLNode g1 = new GLNode(1);
		g1.elements[0] = e1;
		ElemType e2 = new ElemType(2);
		GLNode g2 = new GLNode(2);
		g2.elements[0] = g1;
		g2.elements[1] = e2;
		ElemType e3 = new ElemType(3);
		GLNode g3 = new GLNode(1);
		g3.elements[0] = e3;
		GLNode result = new GLNode(3);
		result.elements[0] = g2;
		result.elements[1] = g3;
		result.elements[2] = g1;
		return result;
	}
	
	
}