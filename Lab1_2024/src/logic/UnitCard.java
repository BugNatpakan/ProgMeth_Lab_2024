package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {

		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
	}

	public void setName(String name) {

		if (name.isBlank())
			name = "Creature";
		this.name = name;
	}

	public void setBloodCost(int bloodCost) {
		bloodCost = Math.max(bloodCost, 0);
		this.bloodCost = bloodCost;
	}

	public void setPower(int power) {
		power = Math.max(power, 0);
		this.power = power;
	}

	public void setHealth(int health) {
		health = Math.max(health, 1);
		this.health = health;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public boolean equals(UnitCard other) {
		return this.name.equals(other.getName());
	}

}
