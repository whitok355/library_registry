package org.example.task1.elements;

public abstract class LibraryElementAbstract {
    private String id;
    private String category;
    private String auth;

    //region
    public String getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuth() {
        return auth;
    }
    public void setAuth(String auth) {
        this.auth = auth;
    }
    //endregion

    public LibraryElementAbstract(String id, String category, String auth) {
        this.id = id;
        this.category = category;
        this.auth = auth;
    }

    public abstract String getInformationInElement();
}
