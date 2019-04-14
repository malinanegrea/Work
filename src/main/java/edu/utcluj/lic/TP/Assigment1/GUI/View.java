package edu.utcluj.lic.TP.Assigment1.GUI;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View {

	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnInt;
	private JButton btnDer;
	private JButton btnInm;
	private JButton btnImp;
	private JButton btnClose;
	private JFrame frame;
	private JTextField pol1;
	private JTextField pol2;
	private JTextField rez;
	private JButton btnClear;
	private JLabel error;
	
	public View() {

		frame = new JFrame("Polinim");
		frame.getContentPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 250);
		frame.setLocationRelativeTo(null);

		JLabel p1 = new JLabel("the first polynomial");
		p1.setBounds(10, 10, 150, 25);
		frame.getContentPane().add(p1);

		JLabel p2 = new JLabel("the second polynomial");
		p2.setBounds(10, 40, 150, 25);
		frame.getContentPane().add(p2);

		pol1 = new JTextField();
		pol1.setBounds(170, 10, 170, 25);
		frame.getContentPane().add(pol1);

		pol2 = new JTextField();
		pol2.setBounds(170, 40, 170, 25);
		frame.getContentPane().add(pol2);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(350, 10, 100, 25);
		frame.getContentPane().add(btnAdd);

		btnSub = new JButton("Subtract");
		btnSub.setBounds(350, 40, 100, 25);
		frame.getContentPane().add(btnSub);

		btnInt = new JButton("Integral");
		btnInt.setBounds(460, 10, 100, 25);
		frame.getContentPane().add(btnInt);

		btnDer = new JButton("Derivation");
		btnDer.setBounds(460, 40, 100, 25);
		frame.getContentPane().add(btnDer);

		btnInm = new JButton("Multiplication");
		btnInm.setBounds(570, 10, 110, 25);
		frame.getContentPane().add(btnInm);

		btnImp = new JButton("Devision");
		btnImp.setBounds(570, 40, 110, 25);
		frame.getContentPane().add(btnImp);
		
		JLabel rezL= new JLabel("Result");
		rezL.setBounds(10, 100, 150, 25);
		frame.getContentPane().add(rezL);
		
		rez= new JTextField("0");
		rez.setBounds(170, 100, 250, 25);
		rez.setEditable(false);
		
		frame.getContentPane().add(rez);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(570, 100, 100, 25);
		frame.getContentPane().add(btnClose);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(460, 100, 100, 25);
		frame.getContentPane().add(btnClear);
	
		error = new JLabel("Degree of the counter must be higher than that of the denominator!");
		error.setBounds(10, 130, 400, 25);
		error.setVisible(false);
		error.setForeground(Color.BLUE);
		frame.getContentPane().add(error);
	}
	public void setVisible() {
		frame.setVisible(true);
	}
	
	public void setInvisible() {
		frame.setVisible(false);
	}
	
	public String getTextP1() {
		return pol1.getText();
	}
	
	public String getTextP2() {
		return pol2.getText();
	}
	
	public void setRez(String rezz) {
		rez.setText(rezz);
	}
	public void addBtnAddListener(ActionListener e) {
		btnAdd.addActionListener(e);
		
	}
	public void addBtnSubListener(ActionListener e) {
		btnSub.addActionListener(e);
		
	}
	public void addBtnIntListener(ActionListener e) {
		btnInt.addActionListener(e);
		
	}
	public void addBtnDerListener(ActionListener e) {
		btnDer.addActionListener(e);
		
	}
	public void addBtnInmListener(ActionListener e) {
		btnInm.addActionListener(e);
		
	}
	public void addBtnImpListener(ActionListener e) {
		btnImp.addActionListener(e);
		
	}
	public void addBtnCloseListener(ActionListener e) {
		btnClose.addActionListener(e);
		
	}
	public void addBtnClearListener(ActionListener e) {
		btnClear.addActionListener(e);
	}
	
	public void reset() {
		pol1.setText(null);
		pol2.setText(null);
		rez.setText(null);
		error.setVisible(false);
	}
	public void errorVisible() {
		error.setVisible(true);
	}
	public void errorInvisible() {
		error.setVisible(false);
	}
}
