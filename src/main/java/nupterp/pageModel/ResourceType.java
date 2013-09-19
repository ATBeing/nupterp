package nupterp.pageModel;

public class ResourceType implements java.io.Serializable {

	private static final long serialVersionUID = 5302387992891797026L;
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
