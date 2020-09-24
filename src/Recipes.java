

public class Recipes {
	private int id;
	private String name;
	private String desc;

	public Recipes() {
		id = 0;
		name = null;
		desc = null;
	}
	public Recipes(int id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public int setId(int id) {
		this.id = id;
		return this.id;
	}
	public String setName(String name) {
		this.name = name;
		return this.name;
	}
	public String setDesc(String desc) {
		this.desc = desc;
		return this.desc;
	}
	public String toString() {
		return name+": "+desc;
	}

}
