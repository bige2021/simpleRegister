package com.bige.simpleregister;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleRegister extends JFrame {
	String information;
	JLabel genderLabel, placeLabel, hobbyLabel;
	JRadioButton radio1, radio2; // ���嵥ѡ��ť
	ButtonGroup group; // ���尴ť��
	String placeName[] = { "��ѡ��", "����", "����", "�Ϻ�", "����", "����", "�������У�������" };
	JComboBox placeBox; // ������Ͽ�
	String hobbyName[] = { "������Ϣ", "������Ϣ", "������Ϣ", "��������" };
	JCheckBox hobbyBox[]; // ���帴ѡ��
	String gender = "", place = "", hobby = "";
	JButton confirmBtn, cancelBtn; // ����ȷ����ť��ȡ����ť

	public SimpleRegister() {
		super("����ͶƱҳ��"); // �趨�������
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		genderLabel = new JLabel("�Ա�");
		radio1 = new JRadioButton("��");
		radio2 = new JRadioButton("Ů");
		radio1.addItemListener(new RadioListener()); // ע��ѡ�������
		radio2.addItemListener(new RadioListener()); // ע��ѡ�������
		group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		container.add(genderLabel);
		container.add(radio1);
		container.add(radio2);
		placeLabel = new JLabel("���ڵ�");
		placeBox = new JComboBox(placeName);
		placeBox.addItemListener(new ComboListener()); // ע��ѡ�������
		container.add(placeLabel);
		container.add(placeBox);
		hobbyLabel = new JLabel("��ע");
		container.add(hobbyLabel);
		hobbyBox = new JCheckBox[hobbyName.length];
		
		for (int i = 0; i < hobbyName.length; i++) {
			hobbyBox[i] = new JCheckBox(hobbyName[i]);
			hobbyBox[i].addItemListener(new CheckBoxListener());
			container.add(hobbyBox[i]);
		}
		
		confirmBtn = new JButton("ȷ��");
		cancelBtn = new JButton("ȡ��");
		confirmBtn.addActionListener(new NewActionListener()); // �����¼�������
		cancelBtn.addActionListener(new NewActionListener()); // �����¼�������
		container.add(confirmBtn);
		container.add(cancelBtn);
		setSize(480, 140); // ���崰���С
		setVisible(true);
	}

	class RadioListener implements ItemListener {
		// ��Ե�ѡ��ť��RadioListener�������ࣨ�Ա�
		public void itemStateChanged(ItemEvent e) {
			Object item = e.getItemSelectable();
			if (item == radio1)
				gender = radio1.getLabel();
			else if (item == radio2)
				gender = radio2.getLabel();
		}
	}

	class ComboListener implements ItemListener {
		// �����Ͽ��ComboListener�������ࣨ���У�
		@Override
		public void itemStateChanged(ItemEvent e) {
			place = (String) e.getItem();
		}
	}

	class CheckBoxListener implements ItemListener {
		// ������Ը�ѡ��CheckBoxListener�������ࣨ��Ȥ��
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
		// ����NewActionListener��������
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == confirmBtn) {
				information = "\n �Ա�" + gender + "\n ���ڵأ�" + place + "\n ��ע" + hobby;
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