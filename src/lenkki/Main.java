
package lenkki;

import lenkki.logiikka.LenkkiLista;
import lenkki.logiikka.Lista;

public class Main {

	public static void main(String[] args) {

		Lista<Integer> lista = new LenkkiLista();
		
		lista.lisaa(200);
		lista.lado(100);
		lista.lisaa(300);
		System.out.println("Keula: " + lista.keula());
		System.out.println("Perä: " + lista.pera());
		System.out.println("Lista: " + lista);
		System.out.println("----------------");

		Integer otettu = lista.ota();
		System.out.println("Otettiin: " + otettu);
		System.out.println("Keula: " + lista.keula());
		System.out.println("Perä: " + lista.pera());
		System.out.println("Lista: " + lista);
		System.out.println("----------------");

		Integer vedetty = lista.veda();
		System.out.println("Vedettiin: " + vedetty);
		System.out.println("Lista: " + lista);
		System.out.println("----------------");

		System.out.println("Sisältääkö 200? " + lista.sisaltaa(200));
		System.out.println("Listan koko: " + lista.koko());
		System.out.println("Haettu indeksillä 0: " + lista.hae(0));
	}
}
