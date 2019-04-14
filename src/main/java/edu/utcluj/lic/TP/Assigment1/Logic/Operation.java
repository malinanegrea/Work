package edu.utcluj.lic.TP.Assigment1.Logic;

import edu.utcluj.lic.TP.Assigment1.Model.Monom;
import edu.utcluj.lic.TP.Assigment1.Model.Polinom;

public class Operation {

	public static Polinom add(Polinom p1, Polinom p2) {
		Polinom p = new Polinom(p1.getMonom());

		for (Monom n : p2.getMonom()) {
			p.addMonom(n);
		}
		return p;
	}

	public static Polinom sub(Polinom p1, Polinom p2) {
		Polinom p = new Polinom(p1.getMonom());

		for (Monom n : p2.getMonom()) {
			Monom s = new Monom(n.getCoeff() * (-1.0), n.getGrad());
			p.addMonom(s);
		}
		return p;
	}

	public static Polinom deriv(Polinom p1) {
		Polinom p2 = new Polinom();
		for (Monom n : p1.getMonom()) {
			Monom s = new Monom(n.getCoeff() * n.getGrad(), n.getGrad() - 1);
			if (s.getGrad() >= 0) {
				p2.addMonom(s);
			}
		}
		return p2;
	}

	public static Polinom integ(Polinom p1) {
		Polinom p2 = new Polinom();
		for (Monom n : p1.getMonom()) {
			Monom s = new Monom(n.getCoeff() / (n.getGrad() + 1), n.getGrad() + 1);
			p2.addMonom(s);
		}
		return p2;
	}

	public static Polinom mul(Polinom p1, Polinom p2) {
		Polinom p = new Polinom();
		for (Monom r : p1.getMonom()) {
			for (Monom q : p2.getMonom()) {
				Monom s = new Monom(r.getCoeff() * q.getCoeff(), r.getGrad() + q.getGrad());
				p.addMonom(s);
			}
		}

		return p;
	}

	public static Polinom[] div(Polinom p1, Polinom p2) {
		Polinom rest = new Polinom(p1.getMonom());
		 Polinom cat = new Polinom();
		if (p2.isZero() == false) {
			while (rest.isZero() == false && rest.max().getGrad() >= p2.max().getGrad()) {
				Monom s = rest.max().divide(p2.max());
				Polinom t = new Polinom();
				t.addMonom(s);
				cat = add(cat, t);
				t = mul(t, p2);
				rest = sub(rest, t);
			}
		}
		Polinom[] pol = new Polinom[2];
		pol[0]=cat;
		pol[1]=rest;
		return pol;

	}

}
