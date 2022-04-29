package LR4;

// TODO: Auto-generated Javadoc
/**
 * The Class Calculate.
 */
public class Calculate extends ForData{
	
	/** The first side. */
	private double first_side;
	
	/** The second side. */
	private double second_side;
	
	/** The third side. */
	private double third_side;
	
	/** The fourth side. */
	private double fourth_side;
	
	/** The result. */
	private double result;

	/**
	 * Sets the sides.
	 *
	 * @param first_side the first side
	 * @param second_side the second side
	 * @param third_side the third side
	 * @param fourth_side the fourth side
	 */
	public void setSides(double first_side, double second_side, double third_side, double fourth_side) {
		this.first_side = first_side;
		this.second_side = second_side;
		this.third_side = third_side;
		this.fourth_side = fourth_side;
	}
	
	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public double getFirst() {
		return first_side;
	}
	
	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public double getSecond() {
		return second_side;
	}
	
	/**
	 * Gets the third.
	 *
	 * @return the third
	 */
	public double getThird() {
		return third_side;
	}
	
	/**
	 * Gets the fourth.
	 *
	 * @return the fourth
	 */
	public double getFourth() {
		return fourth_side;
	}
	
	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public double getResult() {
		return first_side + second_side + third_side + fourth_side;
	}
}
