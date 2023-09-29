package dk.tec.jaj;

public class Frugt 
{
	int id;
	String name;
	String descr;
	int weight;
	String country;
	
	public Frugt() {}
	
	public Frugt(int id, String name, String descr, int weight, String country) {
		super();
		this.name = name;
		this.descr = descr;
		this.weight = weight;
		this.country = country;
		
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
