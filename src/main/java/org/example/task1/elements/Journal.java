package org.example.task1.elements;

public class Journal extends LibraryElementAbstract{
    private String publishingHouse;
    private String publication;

    //region
    public String getPublishingHouse() {
        return publishingHouse;
    }
    public String getPublication() {
        return publication;
    }
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }
    //endregion

    public Journal(String id, String category, String auth, String publishingHouse, String publication) {
        super(id, category, auth);
        this.publishingHouse = publishingHouse;
        this.publication = publication;
    }

    @Override
    public String getInformationInElement() {
        return String.format("id: %s, category: %s, author: %s, publishing house: %s, publication: %s", getId(), getCategory(), getAuth(), getPublishingHouse(), getPublication());
    }
}
