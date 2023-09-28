package dk.tec.jaj;

public class Frugt 
{
	String name;
	String descr;
	int weight;
	String country;
	
	public Frugt(String name, String descr, int weight, String country) {
		super();
		this.name = name;
		this.descr = descr;
		this.weight = weight;
		this.country = country;
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
