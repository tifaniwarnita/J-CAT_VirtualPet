public class Player {
	private String id;
	private int coins;
	private String name;
	private Animal pet;
	//private Inventory inv;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getPet() {
		return pet;
	}

	public void setPet(Animal pet) {
		this.pet = pet;
	}

/*	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}*/

	void adoptPet (String _name, String _type) {
		setName(_name);
		getPet().setType(_type);
		getPet().setAllNew();
	}
	
	void performAction() {
		
	}
}
