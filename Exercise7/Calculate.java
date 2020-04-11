package ne222hz_assign2.Exercise7;

public class Calculate {
	private double startAmount;
	private double interest;
	private int years;

	public Calculate() {
	}

	public Calculate(double startAmount, double interest, int years) {
		this.startAmount = startAmount;
		this.interest = interest;
		this.years = years;
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

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public int total() {
		double newInterest = this.interest/100;
		newInterest++;
		double finalAmount = Math.pow(newInterest, this.years);
		finalAmount *= this.startAmount;
		finalAmount = Math.round(finalAmount);
		return (int)finalAmount;
	}

	public String toString() {
		return "In total that will be " + total();
	}

}
