package org.example.task1.elements;

public class Letter extends LibraryElementAbstract{

    private String recipient;
    private String sender;

    //region
    public String getRecipient() {
        return recipient;
    }
    public String getSender() {
        return sender;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    //endregion

    public Letter(String id, String category, String auth, String recipient, String sender) {
        super(id, category, auth);
        this.recipient = recipient;
        this.sender = sender;
    }
    @Override
    public String getInformationInElement() {
        return String.format("id: %s, category: %s, author: %s, recipient: %s, sender: %s", getId(), getCategory(),getAuth() ,getRecipient(), getSender());
    }
}
