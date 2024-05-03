package org.example.task1.elements;

public class Book extends LibraryElementAbstract{
    private String title;

    //region
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //endregion
    public Book(String id, String category, String auth, String title) {
        super(id, category, auth);
        this.title = title;
    }

    @Override
    public String getInformationInElement(){
        return String.format("id: %s, category: %s, author: %s, title: %s", getId(), getCategory(), getAuth(),getTitle());
    }
}
