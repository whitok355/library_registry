package org.example.task1.elements;

public class Microfilm extends LibraryElementAbstract{

    private String duration;
    private String format;

    //region
    public String getDuration() {
        return duration;
    }
    public String getFormat() {
        return format;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    //endregion
    public Microfilm(String id, String category, String auth, String duration, String format) {
        super(id, category, auth);
        this.duration = duration;
        this.format = format;
    }

    @Override
    public String getInformationInElement() {
        return String.format("id: %s, category: %s, author: %s, duration: %s, format: %s", getId(), getCategory(), getAuth(),getDuration(), getFormat());
    }
}
