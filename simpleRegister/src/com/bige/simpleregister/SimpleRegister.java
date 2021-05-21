package com.bige.simpleregister;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleRegister extends JFrame {
	String information;
	JLabel genderLabel, placeLabel, hobbyLabel;
	JRadioButton radio1, radio2; // 定义单选按钮
	ButtonGroup group; // 定义按钮组
	String placeName[] = { "请选择", "广州", "北京", "上海", "杭州", "深圳", "其它城市（地区）" };
	JComboBox placeBox; // 定义组合框
	String hobbyName[] = { "网购信息", "旅游信息", "新书信息", "娱乐明星" };
	JCheckBox hobbyBox[]; // 定义复选框
	String gender = "", place = "", hobby = "";
	JButton confirmBtn, cancelBtn; // 定义确定按钮及取消按钮

	public SimpleRegister() {
		super("简易投票页面"); // 设定窗体标题
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		genderLabel = new JLabel("性别");
		radio1 = new JRadioButton("男");
		radio2 = new JRadioButton("女");
		radio1.addItemListener(new RadioListener()); // 注册选项监听器
		radio2.addItemListener(new RadioListener()); // 注册选项监听器
		group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		container.add(genderLabel);
		container.add(radio1);
		container.add(radio2);
		placeLabel = new JLabel("所在地");
		placeBox = new JComboBox(placeName);
		placeBox.addItemListener(new ComboListener()); // 注册选项监听器
		container.add(placeLabel);
		container.add(placeBox);
		hobbyLabel = new JLabel("关注");
		container.add(hobbyLabel);
		hobbyBox = new JCheckBox[hobbyName.length];
		
		for (int i = 0; i < hobbyName.length; i++) {
			hobbyBox[i] = new JCheckBox(hobbyName[i]);
			hobbyBox[i].addItemListener(new CheckBoxListener());
			container.add(hobbyBox[i]);
		}
		
		confirmBtn = new JButton("确定");
		cancelBtn = new JButton("取消");
		confirmBtn.addActionListener(new NewActionListener()); // 定义事件监听器
		cancelBtn.addActionListener(new NewActionListener()); // 定义事件监听器
		container.add(confirmBtn);
		container.add(cancelBtn);
		setSize(480, 140); // 定义窗体大小
		setVisible(true);
	}

	class RadioListener implements ItemListener {
		// 针对单选按钮的RadioListener监听器类（性别）
		public void itemStateChanged(ItemEvent e) {
			Object item = e.getItemSelectable();
			if (item == radio1)
				gender = radio1.getLabel();
			else if (item == radio2)
				gender = radio2.getLabel();
		}
	}

	class ComboListener implements ItemListener {
		// 针对组合框的ComboListener监听器类（城市）
		@Override
		public void itemStateChanged(ItemEvent e) {
			place = (String) e.getItem();
		}
	}

	class CheckBoxListener implements ItemListener {
		// 定义针对复选框CheckBoxListener监听器类（兴趣）
		@Override
		public void itemStateChanged(ItemEvent e) {
			Object item = e.getItemSelectable();
			if (e.getSource() == hobbyBox[0] && e.getStateChange() == e.SELECTED)
				hobby += " " + hobbyBox[0].getLabel();
			else if (e.getSource() == hobbyBox[1] && e.getStateChange() == e.SELECTED)
				hobby += " " + hobbyBox[1].getLabel();
			else if (e.getSource() == hobbyBox[2] && e.getStateChange() == e.SELECTED)
				hobby += " " + hobbyBox[2].getLabel();
			else if (e.getSource() == hobbyBox[3] && e.getStateChange() == e.SELECTED)
				hobby += " " + hobbyBox[3].getLabel();
		}
	}

	class NewActionListener implements ActionListener {
		// 定义NewActionListener监听器类
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == confirmBtn) {
				information = "\n 性别：" + gender + "\n 所在地：" + place + "\n 关注" + hobby;
				JOptionPane.showMessageDialog(null, information);
			} else if (e.getSource() == cancelBtn) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		SimpleRegister reg = new SimpleRegister();
		reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}