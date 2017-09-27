//package com.liuzhen.game;
//
//
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.eclipse.jface.dialogs.InputDialog;
//import org.eclipse.jface.window.Window;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.MessageBox;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.widgets.Text;
//
//public class FindTheSame {
//
//	private static final String TEXT = "请选择";		// 显示内容
//	private static final Long WAITINGTIME = 800l;	// 等待时间
//
//	private static Display display;					// 显示器
//	private static Shell shell;						// 界面
//	private static Text chanceText;					// 记录剩余次数
//	private static int a;							// 横坐标
//	private static int b;							// 纵坐标
//	private static Button resetBtn;					// 重置按钮
//	private static Button setBtn;					// 设置按钮
//	private Button[] button;						// 主要按钮
//	private static int choosen = -1;				// 选中值
//	private static Button btn = null;				// 选中的按钮
//	private static int remainder;					// 剩余个数
//	private static int chance;						// 剩余次数
//
//	public FindTheSame() {
//		remainder = a*b;
//		chance = (int) (a*b*2);
//		display = new Display();
//
//		shell = new Shell(display, SWT.DIALOG_TRIM);
//		shell.setText("找相同");
//		shell.setSize(100*a + 6, 100*b + 60);
//
//		chanceText = new Text(shell, SWT.READ_ONLY);
//		chanceText.setText("剩余次数:" + chance);
//		chanceText.setLocation(5, 5);
//		chanceText.setSize(80, 20);
//		chanceText.setEditable(false);
//
//		resetBtn = new Button(shell, SWT.PUSH);
//		resetBtn.setText("重置");
//		resetBtn.setSize(40, 20);
//		resetBtn.setLocation(100*a - 90, 5);
//		resetBtn.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				display.dispose();
//				new FindTheSame();
//			}
//		});
//
//		setBtn = new Button(shell, SWT.PUSH);
//		setBtn.setText("设置");
//		setBtn.setSize(40, 20);
//		setBtn.setLocation(100*a - 45, 5);
//		setBtn.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				InputDialog input = new InputDialog(shell, "设置", "请输入两个数字", "0", null);
//				if (input.open() == Window.OK && input.getValue().matches("\\d+[ ,#$-*xX]+\\d+")) {
//					String[] arr = input.getValue().split("[ ,#$-*xX]+");
//					int x = Integer.parseInt(arr[0]);
//					int y = Integer.parseInt(arr[1]);
//					if (x < 2) {
//						alertMsg(shell, "宽度过低(第一个数字要大于1)");
//						return ;
//					}
//					if (y < 1) {
//						alertMsg(shell, "高度过低(第二个数字要大于0)");
//						return ;
//					}
//					Map<Integer, Double> map = getScreenSize();
//					if (map.get(0)/100 < x || map.get(1)/100 < y) {
//						alertMsg(shell, "根据您的显示器,建议您的宽度不大于" + map.get(0)/100 + ",高度不大于" + map.get(1)/100);
//						return ;
//					}
//					a = x;
//					b = y;
//					display.dispose();
//					new FindTheSame();
//				} else {
//					alertMsg(shell, "输入错误");
//				}
//			}
//		});
//
//		button = new Button[a*b];
//		int[] question = createQuestion(a*b);
//		for (int i = 0; i < b; i++) {
//			for (int j = 0; j < a; j++) {
//				button[i*a + j] = new Button(shell, SWT.PUSH);
//				button[i*a + j].setText(TEXT);
//				button[i*a + j].setSize(100, 100);
//				button[i*a + j].setLocation(j*100, i*100 + 30);
//				button[i*a + j].setData(question[i*a + j]);
//				button[i*a + j].addSelectionListener(new SelectionAdapter() {
//					public void widgetSelected(SelectionEvent e) {
//						chanceText.setText("剩余次数:" + --chance);
//						if (choosen == -1) {
//							btn = (Button) e.getSource();
//							choosen = Integer.parseInt(String.valueOf(btn.getData()));
//							btn.setText(choosen + "");
//							if (chance == 0) {
//								alertMsg(shell, "很遗憾,您的机会用尽了!");
//								for (int k = 0; k < button.length; k++) {
//									if(button[k].isEnabled()) {
//										button[k].setEnabled(false);
//									}
//								}
//							}
//						} else {
//							Button tempBtn = (Button)e.getSource();
//							tempBtn.setText(String.valueOf(tempBtn.getData()));
//							if (tempBtn != btn && choosen == Integer.parseInt(((Button)e.getSource()).getData().toString())) {
//								btn.setEnabled(false);
//								tempBtn.setEnabled(false);
//								choosen = -1;
//								remainder -= 2;
//								if (remainder == 0) {
//									alertMsg(shell, "恭喜您,完成啦~！");
//								} else if (chance == 0) {
//									alertMsg(shell, "很遗憾,您的机会用尽了!");
//									for (int k = 0; k < button.length; k++) {
//										if(button[k].isEnabled()) {
//											button[k].setEnabled(false);
//										}
//									}
//								}
//							} else {
//								try {
//									Thread.currentThread();
//									Thread.sleep(WAITINGTIME);
//								} catch (InterruptedException e1) {
//									e1.printStackTrace();
//								}
//								btn.setText(TEXT);
//								tempBtn.setText(TEXT);
//								choosen = -1;
//								if (chance == 0) {
//									alertMsg(shell, "很遗憾,您的机会用尽了!");
//									for (int k = 0; k < button.length; k++) {
//										if(button[k].isEnabled()) {
//											button[k].setEnabled(false);
//										}
//									}
//								}
//							}
//						}
//					}
//				});
//			} // for.j.
//		} // for.i.
//
//		shell.open();
//		while(!shell.isDisposed()) {
//			if(!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
//		display.dispose();
//	}
//
//	public static void main(String[] args) {
//		a = 4;
//		b = 3;
//		new FindTheSame();
//		System.exit(0);
//	}
//
//	private int[] createQuestion(int a) {
//		int[] num = new int[a];
//		List<Integer> temp = new ArrayList<Integer>(a);
//		for (int i = 0; i < a/2; i++) {
//			int b = (int)(Math.random()*100);
//			temp.add(b);
//			temp.add(b);
//		}
//		for (int i = 0; i < num.length; i++) {
//			int index = (int)(Math.random()*(a - i));
//			num[i] = temp.remove(index);
//		}
//		return num;
//	}
//
//	public void alertMsg(Shell shell,String msg) {
//		MessageBox alertBox = new MessageBox(shell);
//		alertBox.setMessage(msg);
//		alertBox.setText("信息");
//		alertBox.open();
//	}
//
//	public Map<Integer, Double> getScreenSize() {
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Dimension scrnsize = tk.getScreenSize();
//		Map<Integer, Double> map = new HashMap<Integer, Double>();
//		map.put(0, scrnsize.getWidth());
//		map.put(1, scrnsize.getHeight());
//		return map;
//	}
//}
//
//
