package com.klef.fsd.springboot.model;



import java.sql.Blob;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "art_table")
public class Art 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private int id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 100)
  private String artistName;

  @Column(nullable = false, length = 500)
  private String description;

  @Column(nullable = false, length = 100)
  private String category;  // e.g., Painting, Sculpture, Digital Art

  @Column(nullable = false)
  private double price;

  @Column(nullable = false)
  private int quantity;  // available copies (for prints etc.)

  @Column(nullable = true)
  private Blob image;  // store artwork image (optional)

  @ManyToOne
  @JoinColumn(name = "admin_id")
  private Admin admin;

  // Getters and Setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

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

  public Blob getImage() {
    return image;
  }
  public void setImage(Blob image) {
    this.image = image;
  }

  }
