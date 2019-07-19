package godgiven_school;

public class person {
    private String fullname;
    private String id;

    public person() {
    }

    public person(String fullname, String id) {
        this.fullname = fullname;
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setId(String id) {
        this.id = id;
    }
}
