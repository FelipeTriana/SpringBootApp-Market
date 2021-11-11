package com.platzi.market.domain;

public class Category {
    //Important: We have not productos attribute, this won't be mapped is a desing decision!!!!!!!!!!!
    private int categoryId;
    private String category;
    private boolean active;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory( String category) {
        this.category = category;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive( boolean active) {
        this.active = active;
    }
}
