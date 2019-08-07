package com.liuzhen.algorithm.liyanzhang;

import java.util.HashMap;
import java.util.Map;

/*
 * @class: GLNode
 * @description: 广义表
 * @author: L.zhen
 * @date: 2018/4/13 18:01
 */
public class GLNode implements Element {
	
	public GLNode(int length) {
		this.elements = new Element[length];
	}
	
	/*
	 * 广义表的元素列表，每一个元素都“可能是广义表，也可能是原子”
	 */
	public Element[] elements;
	
	/*
	 * @title:  print
	 * @description: 打印该广义表（简单处理了一下递归的广义表）
	 * @return
	 * @author: L.zhen
	 * @date:   2018/4/16 16:51
	 */
	public String print() {
		return print(this, new HashMap<GLNode, Detail>());
	}
	
	private String print(Element[] elements, Map<GLNode, Detail> map) {
		if (elements != null && elements.length > 0) {
			StringBuilder result = new StringBuilder("");
			for (int i = 0; i < elements.length; i++) {
				Element element = elements[i];
				if (element instanceof GLNode) {
					for (Map.Entry entry : map.entrySet()) {
						Detail d = map.get((GLNode) entry.getKey());
						d.sign4Round = false;
						map.put((GLNode) entry.getKey(), d);
					}
					result.append(print((GLNode) element, map));
				} else {
					result.append(((ElemType) element).value);
				}
				if (i != elements.length - 1) {
					result.append(",");
				}
			}
			return result.toString();
		} else {
			return "";
		}
	}
	
	private String print(GLNode g, Map<GLNode, Detail> map) {
		if (g != null && g.elements != null && g.elements.length > 0) {
			for (Element element : elements) {
				if (element == g) {
					if (map.get(g) != null) {
						if (map.get(g).count == 2)  {
							return "(...)";
						} else {
							Detail d = map.get(g);
							d.count += 1;
						}
					} else {
						map.put(g, new Detail(1, true));
					}
				}
			}
			return "(" + print(g.elements, map) + ")";
		} else {
			return "";
		}
	}
	
	class Detail {
		
		Detail(int count, boolean sign4Round) {
			this.count = count;
			this.sign4Round = sign4Round;
		}
		
		int count;
		boolean sign4Round;
	}
}
