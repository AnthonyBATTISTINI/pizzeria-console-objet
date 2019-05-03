package fr.pizzeria.model;

public class Pizza {
	
	private static int nextId = 0;
	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	public Pizza(String code, String libelle, double prix) {
		this.id = nextId++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		if(id >= nextId) {
			nextId = id + 1;
		}
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void modificationPizza(String code, String libelle, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
}
