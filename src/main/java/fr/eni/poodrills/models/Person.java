package fr.eni.poodrills.models;

public class Person {

	private int personNb;

	private String name;

	public Person() {
	}

	public Person(int personNb, String name) {
		super();
		this.personNb = personNb;
		this.name = name;
	}

	public int getPersonNb() {
		return personNb;
	}

	public void setPersonNb(int personNb) {
		this.personNb = personNb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [noPersonne=" + getPersonNb() + ", name=" + getName() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Float.floatToIntBits(this.getPersonNb()) == Float.floatToIntBits(other.getPersonNb())
				&& this.getName().equals(other.getName());
	}

}