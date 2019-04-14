package edu.utcluj.lic.TP.Assigment1.Model;

public class Monom implements Comparable<Monom> {

	private double coeff;
	private int grad;

	public Monom(double coeff, int grad) {
		this.coeff = coeff;
		this.grad = grad;

	}

	public double getCoeff() {
		return this.coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public int getGrad() {
		return this.grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public void add(Monom m) {
		this.coeff += m.getCoeff();
	}
	
	public Monom divide(Monom m) {
		Monom n = new Monom(this.coeff/m.getCoeff(), this.grad-m.getGrad());
		return n;
	}

	public int compareTo(Monom m) {
		if (this.grad < m.getGrad()) {
			return 1;
		} else if (this.grad > m.getGrad()) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean equals(Monom m) {
		if (m == null) {
			return false;
		} else {
			if (m.getCoeff() == this.coeff) {
				if (m.getGrad() == this.grad) {
					return true;
				} else {
					return false;
				}
			}
			else{
				return false;
			}
		}

	}
	
}
