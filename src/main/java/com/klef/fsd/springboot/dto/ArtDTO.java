package com.klef.fsd.springboot.dto;



public class ArtDTO 
{
    private String title;          
    private String artistName;    
    private String description;    
    private String category;       
    private double price;          
    private int quantity;         
    private int galleryManagerId;  

    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getGalleryManagerId() {
        return galleryManagerId;
    }
    public void setGalleryManagerId(int galleryManagerId) {
        this.galleryManagerId = galleryManagerId;
    }
}
