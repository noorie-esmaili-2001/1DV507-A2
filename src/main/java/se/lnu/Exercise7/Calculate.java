package se.lnu.Exercise7;

public class Calculate {
	private double startAmount;
	private double interest;
	private int years;

	public Calculate(double startAmount, double interest, int years) {
		setStartAmount(startAmount);
		setInterest(interest);
		setYears(years);
	}

	public double getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(double startAmount) {
		this.startAmount = startAmount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public int total() {
		double newInterest = getInterest()/100;
		newInterest++;
		double finalAmount = Math.pow(newInterest, getYears());
		finalAmount *= getStartAmount();
		finalAmount = Math.round(finalAmount);
		return (int)finalAmount;
	}

	public String toString() {
		return "In total that will be " + total();
	}

}
