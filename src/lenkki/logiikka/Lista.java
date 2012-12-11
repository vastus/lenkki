
package lenkki.logiikka;

public interface Lista<E> {

	/*
	 * Lisää elementin listan keulaan
	 * Palauttaa true
	 */
	boolean lado(E elem);

	/*
	 * Lisää elementin listan perään
	 * Palauttaa true
	 */
	boolean lisaa(E elem);

	/*
	 * Poistaa elementin indeksissä
	 * Palauttaa poistetun
	 * Aiheuttaa poikkeuksen, jos indeksi rajojen ulkopuolella
	 */
	E poista(int indeksi) throws IndexOutOfBoundsException;

	/*
	 * Ota (poista) ensimmäinen elementti listasta
	 * Palauta poistettu
	 * Aiheuttaa poikkeuksen, jos lista tyhjä
	 */
	E ota() throws IndexOutOfBoundsException;

	/*
	 * Vedä (poista) viimeinen elementti listasta
	 * Palauta poistettu
	 * Aiheuttaa poikkeuksen, jos lista tyhjä
	 */
	E veda() throws IndexOutOfBoundsException;

	/*
	 * Hakee elementin indeksissä
	 * Palauttaa haetun
	 * Aiheuttaa poikkeuksen, jos indeksi rajojen ulkopuolella
	 */
	E hae(int indeksi) throws IndexOutOfBoundsException;

	/*
	 * Listan koko
	 * Palauttaa listan koon
	 */
	int koko();

	/*
	 * Tarkastaa onko lista tyhjä
	 * Palauttaa true, jos tyhjä
	 */
	boolean tyhja();

	/*
	 * Tarkastaa sisältääkö lista elementin
	 * Palauttaa true, jos löytyy
	 */
	boolean sisaltaa(E elem);

	/*
	 * Viite keulaan
	 * Palauttaa elementin keulassa
	 */
	E keula();

	/*
	 * Viite perään
	 * Palauttaa elementin perässä
	 */
	E pera();

	@Override
	String toString();
}
