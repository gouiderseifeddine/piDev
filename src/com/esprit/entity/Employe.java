/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Objects;

/**
 *
 * @author saif
 */
public class Employe {

    Integer id;
    String nom;
    String prenom;
    String tache;
    String age;
    String mobile;
    String salaire;
    String num_carte;
    int status;
    int num_salle;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Employe(Integer id, String tache, int status) {
        this.id = id;
        this.tache = tache;
        this.status = status;
    }

    public Employe() {
    }
    

    public Employe(Integer id, String nom, String prenom, String tache, String age, String mobile, String salaire, String num_carte, int status) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tache = tache;
        this.age = age;
        this.mobile = mobile;
        this.salaire = salaire;
        this.num_carte = num_carte;
        this.status = status;
    }

    public Employe(String nom, String prenom, String tache, String mobile, int num_salle) {
        this.nom = nom;
        this.prenom = prenom;
        this.tache = tache;
        this.mobile = mobile;
        this.num_salle = num_salle;
    }

    public int getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(int num_salle) {
        this.num_salle = num_salle;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employe other = (Employe) obj;
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.tache, other.tache)) {
            return false;
        }
        if (!Objects.equals(this.mobile, other.mobile)) {
            return false;
        }
        if (!Objects.equals(this.salaire, other.salaire)) {
            return false;
        }
        if (!Objects.equals(this.num_carte, other.num_carte)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(String num_carte) {
        this.num_carte = num_carte;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    


}
