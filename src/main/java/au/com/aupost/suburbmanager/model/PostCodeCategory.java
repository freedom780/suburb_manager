package au.com.aupost.suburbmanager.model;

public enum PostCodeCategory {

    DELIVERY("Delivery Area"), 
    PO_BOXES("Post Office Boxes");

    private String description;

    PostCodeCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
