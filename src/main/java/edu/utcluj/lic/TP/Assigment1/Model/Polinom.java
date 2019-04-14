package edu.utcluj.lic.TP.Assigment1.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polinom {

	private List<Monom> terms;

	public Polinom() {
		terms = new ArrayList<Monom>();

	}
	
	public Polinom(String s) {

		terms = new ArrayList<Monom>();
		Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
		Matcher m = p.matcher(s);
		while (m.find()) {
			Monom mon = new Monom(Double.parseDouble(m.group(1)), Integer.parseInt(m.group(2)));
			addMonom(mon);

		}

	}

	
	public Polinom(List<Monom> terms) {	
		this.terms = new ArrayList<Monom>();
		this.terms.addAll(terms);
	}

	public List<Monom> getMonom() {

		return this.terms;
	}
	


	public void setMonom(List<Monom> terms) {
		this.terms.addAll(terms);
	}

	public void addMonom(Monom m) {
		boolean ok = false;
		if (m != null && m.getCoeff() != 0.0) {
			if (terms != null) {
				for (Monom n : terms) {
					if (n.getGrad() == m.getGrad()) {
							n.add(m);
							ok = true;
					}
				}
				if (!ok) {
					terms.add(m);
					Collections.sort(terms);
				}
				for (Iterator<Monom> iterator = terms.iterator(); iterator.hasNext();) {
					Monom n = iterator.next();
					if (n.getCoeff() == 0.0) {
						iterator.remove();
					}
				}
			}
		}
	}


	public boolean isZero() {
		boolean ok = true;

		for (Monom m : terms) {
			if (m.getCoeff() != 0.0) {
				ok = false;
			}
		}
		return ok;
	}

	public Monom max() {
		Monom maxx = new Monom(0, 0);

		for (Monom m : terms) {
			if (maxx.getGrad() < m.getGrad())
				maxx = m;
		}
		return maxx;
	}
	


	public String toStringg() {

		StringBuilder sb = new StringBuilder();
		for (Monom m : terms) {
			if (m.getCoeff() > 0 && m.getGrad() < max().getGrad()) {
				sb.append("+");
			}
			sb.append(m.getCoeff());
			if (m.getGrad() > 0) {
				sb.append("x^");
				sb.append(m.getGrad());
			}
		}
		String s = sb.toString();
		return s;
	}
	
	public String concatRezDiv(Polinom[] rez) {
		StringBuilder sb = new StringBuilder();
		sb.append(rez[0].toStringg());
		if (rez[0].isZero() == false) {
			sb.append("+(");
			sb.append(rez[1].toStringg());
			sb.append(")/(");
			sb.append(toStringg());
			sb.append(")");
		}

		return sb.toString();
		
	}

}
