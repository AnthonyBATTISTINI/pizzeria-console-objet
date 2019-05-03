package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private static Pizza[] tabPizza = new Pizza[10];
	
	public static void main(String[] args) {
		
		Scanner userChoose = new Scanner(System.in);
		int numberChoose;
		tabPizza[0] = new Pizza("PEP", "Pépéroni", 12.50);
		tabPizza[1] = new Pizza("MAR", "Margherita", 14.00);
		tabPizza[2] = new Pizza("REIN", "La Reine", 11.50);
		tabPizza[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		tabPizza[4] = new Pizza("CAN", "La cannibale", 12.50);
		tabPizza[5] = new Pizza("SAV", "La savoyarde", 13.00);
		tabPizza[6] = new Pizza("ORI", "L'orientale", 13.50);
		tabPizza[7] = new Pizza("IND", "L'indienne", 14.00);
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			numberChoose = userChoose.nextInt();
			
			switch(numberChoose) {
			case 1:
				System.out.println("Liste des pizzas");
				affichageListePizzas();
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				demandeAjout(userChoose);
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				modifierPizza(userChoose);
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				suppressionPizza(userChoose);
				break;
			case 99:
				System.out.println("Au revoir");
				return;
			default:
				System.out.println("Choix non valide");
				break;
			}
			
		} while (numberChoose != 99);
	}
	
	private static void affichageListePizzas() {
		for(int i = 0; i < tabPizza.length; i++) {
			if(tabPizza[i] != null) {
				System.out.println(tabPizza[i].getCode() + " -> " + tabPizza[i].getLibelle() + " (" + String.format("%.2f", tabPizza[i].getPrix()) + "€)");
			}
		}
		System.out.println();
	}
	
	private static void demandeAjout(Scanner s) {
		System.out.println("Veuillez saisir le code :");
		String code = s.next();
		System.out.println("Veuillez saisir le nom :");
		String libelle = s.next();
		System.out.println("Veuillez saisir le prix :");
		double prix = s.nextDouble();
		int i = 0;
		while (i < tabPizza.length && tabPizza[i] != null) {
			i++;
		}
		if ( i == tabPizza.length) {
			Pizza[] tabTemp = new Pizza[tabPizza.length];
			for(int j = 0; j < tabPizza.length; j++) {
				tabTemp[j] = tabPizza[j];
			}
			tabPizza = tabTemp;
		}
		tabPizza[i] = new Pizza(i, code, libelle, prix);
		System.out.println("Ajout effectuer");
	}
	
	private static void modifierPizza(Scanner s) {
		affichageListePizzas();
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		String code = s.next();
		int i = 0;
		while(i < tabPizza.length && tabPizza[i].getCode().compareTo(code) != 0) {
			i++;
		}
		if(i == tabPizza.length) {
			System.out.println("Code non reconnu");
			return;
		}
		System.out.println("Veuillez saisir le nouveau code :");
		code = s.next();
		System.out.println("Veuillez saisir le nouveau nom :");
		String libelle = s.next();
		System.out.println("Veuillez saisir le nouveau prix :");
		double prix = s.nextDouble();
		tabPizza[i].modificationPizza(code, libelle, prix);
		System.out.println("Modification effective");
		affichageListePizzas();
	}
	
	private static void suppressionPizza(Scanner s) {
		affichageListePizzas();
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String code = s.next();
		int i = 0;
		while(i < tabPizza.length && (tabPizza[i] == null || tabPizza[i].getCode().compareTo(code) != 0)) {
			i++;
		}
		if(i == tabPizza.length) {
			System.out.println("Code non reconnu");
			return;
		}
		tabPizza[i] = null;
		System.out.println("Suppression effective");
		affichageListePizzas();
	}
}
