package crudjdbc;

public class User {

	private Integer id;
	private String name;
	private String email;

	public User() {
		super();
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + id);
		sb.append("\nNome: " + name);
		sb.append("\nEmail: " + email);
		return sb.toString();
	}

}
