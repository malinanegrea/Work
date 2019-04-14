package edu.utcluj.lic.TP.Assigment1.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.utcluj.lic.TP.Assigment1.Logic.Operation;
import edu.utcluj.lic.TP.Assigment1.Model.Polinom;

public class Controler {

	private View view;
	private Polinom p1;
	private Polinom p2;
	private Polinom rez;

	public Controler(View view) {
		this.view = view;

		view.addBtnAddListener(new AddActionListener());
		view.addBtnCloseListener(new CloseActionListener());
		view.addBtnDerListener(new DerActionListener());
		view.addBtnImpListener(new ImpActionListener());
		view.addBtnInmListener(new InmActionListener());
		view.addBtnIntListener(new IntActionListener());
		view.addBtnSubListener(new SubActionListener());
		view.addBtnClearListener(new ClearActionListener());
		

	}

	private void getPol() {
		view.errorInvisible();
		p1 = new Polinom(view.getTextP1());
		p2 = new Polinom(view.getTextP2());

	}
	
	public void setVisible() {
		view.setVisible();
	}

	public class AddActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			rez = Operation.add(p1, p2);
			view.setRez(rez.toStringg());
		}

	}

	public class SubActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			rez = Operation.sub(p1, p2);
			view.setRez(rez.toStringg());
		}

	}

	public class DerActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			rez = Operation.deriv(p1);
			view.setRez(rez.toStringg());
		}

	}

	public class IntActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			rez = Operation.integ(p1);
			view.setRez(rez.toStringg());
		}

	}

	public class InmActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			rez = Operation.mul(p1, p2);
			view.setRez(rez.toStringg());
		}

	}

	public class ImpActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getPol();
			if (p1.max().getGrad() > p2.max().getGrad()) {
				Polinom[] rez = Operation.div(p1, p2);
				view.setRez(p2.concatRezDiv(rez));

			} else {
				view.setRez(null);
				view.errorVisible();
			}

		}
	}

	public class CloseActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			view.setInvisible();

		}

	}

	public class ClearActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			view.reset();

		}

	}

}
