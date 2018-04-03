
package com.formation.dating.entities; 
 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull; 
 
@Entity 
public class Multimedia { 
 @Id
  private Long Id; 
 @NotNull
  private String typeMultimedia; 
 @NotNull
  private String genre; 
 @NotNull
  private String titre; 
 @NotNull
  private String artiste;
  
  @ManyToMany
  private List<CentreInteret> centresinterets;
   
  public Multimedia(Long id, String typeMultimedia, String genre, String titre, String artiste) { 
    super(); 
    Id = id; 
    this.typeMultimedia = typeMultimedia; 
    this.genre = genre; 
    this.titre = titre; 
    this.artiste = artiste; 
  } 
 
  public Multimedia() { 
     
  } 
 
  public Long getId() { 
    return Id; 
  } 
 
  public void setId(Long id) { 
    Id = id; 
  } 
 
  public String getTypeMultimedia() { 
    return typeMultimedia; 
  } 
 
  public void setTypeMultimedia(String typeMultimedia) { 
    this.typeMultimedia = typeMultimedia; 
  } 
 
  public String getGenre() { 
    return genre; 
  } 
 
  public void setGenre(String genre) { 
    this.genre = genre; 
  } 
 
  public String getTitre() { 
    return titre; 
  } 
 
  public void setTitre(String titre) { 
    this.titre = titre; 
  } 
 
  public String getArtiste() { 
    return artiste; 
  } 
 
  public void setArtiste(String artiste) { 
    this.artiste = artiste; 
  } 
   
   
} 
