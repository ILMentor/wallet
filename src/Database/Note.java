package Database;

public class Note {

    private String value;
    private String date;
    private String category;
    private String type;
    private String description;

    public Note(String value, String date, String category, String type, String description) {
        this.value = value;
        this.date = date;
        this.category = category;
        this.type = type;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
