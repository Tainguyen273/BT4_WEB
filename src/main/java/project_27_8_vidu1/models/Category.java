package project_27_8_vidu1.models;

public class Category {
	private int cateid;
	private String catename;
	private String icon;
	// Constructor mặc định
    public Category() {
    }

    // Constructor với tất cả các thuộc tính
    public Category(int cateid, String catename, String icon) {
        this.cateid = cateid;
        this.catename = catename;
        this.icon = icon;
    }

    // Getters
    public int getCateid() {
        return cateid;
    }

    public String getCatename() {
        return catename;
    }

    public String getIcon() {
        return icon;
    }

    // Setters
    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
