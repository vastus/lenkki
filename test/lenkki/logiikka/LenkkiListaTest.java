
package lenkki.logiikka;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LenkkiListaTest {

	private Lista<Integer> lista;
	
	public LenkkiListaTest() {
	}
	
	@Before
	public void setUp() {
		this.lista = new LenkkiLista<>();
	}

	@Test
	public void latominen() {
		assertTrue("Elementin latomisen tulee palauttaa true", lista.lado(1));
	}

	@Test
	public void latominen_tapahtuu_listan_keulaan_lisaamalla() {
		lista.lado(200);
		lista.lado(100);

		Integer eka = lista.hae(0);
		Integer toka = lista.hae(1);

		assertEquals(new Integer(100), eka);
		assertEquals(new Integer(200), toka);
	}

	@Test
	public void latominen_ja_hakeminen() {
		lista.lado(100);

		Integer haettu = lista.hae(0);
		assertEquals(new Integer(100), haettu);
	}

	@Test
	public void lisaaminen() {
		assertTrue(lista.lisaa(1));
	}

	@Test
	public void lisaaminen_tapahtuu_listan_peraan_lisaamalla() {
		lista.lisaa(100);
		lista.lisaa(200);

		Integer eka = lista.hae(0);
		Integer toka = lista.hae(1);

		assertEquals(new Integer(100), eka);
		assertEquals(new Integer(200), toka);
	}

	@Test
	public void lisaaminen_ja_hakeminen() {
		lista.lisaa(100);

		Integer haettu = lista.hae(0);
		assertEquals(new Integer(100), haettu);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void hakeminen_rajojen_ulkopuolelta_aiheuttaa_poikkeuksen() {
		lista.hae(0);
	}

	@Test
	public void lista_on_alustamisen_jalkeen_tyhja() {
		assertTrue(lista.tyhja());
	}
	
	@Test
	public void tyhjan_listan_koko_nolla() {
		assertEquals(0, lista.koko());
	}

	@Test
	public void listan_koko_on_sen_sisaltamien_elementtien_summa() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);
		assertEquals(lista.koko(), 3);
	}

	@Test
	public void sisaltaa() {
		lista.lisaa(1);

		assertTrue("sisältää lisätyn elementin", lista.sisaltaa(1));
		assertFalse("sisältää vain lisätyt elementit", lista.sisaltaa(2));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void tyhjasta_listasta_poistaminen_aiheuttaa_poikkeuksen() {
		lista.poista(0);
	}

	@Test
	public void poistaminen_palauttaa_elementin_kyseisessa_indeksissa() {
		lista.lisaa(100);
		Integer poistettu = lista.poista(0);

		assertEquals(new Integer(100), poistettu);
	}

	@Test
	public void listan_perasta_poistaminen() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);
		lista.lisaa(400);

		Integer poistettu = lista.poista(3);

		assertEquals(new Integer(400), poistettu);
	}

	@Test
	public void listaan_latominen_poistamisen_jalkeen() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);
		lista.lisaa(400);

		lista.poista(3);
		lista.lado(1);
		
		assertEquals(new Integer(1), lista.hae(0));
		assertEquals(new Integer(100), lista.hae(1));
		assertEquals(new Integer(200), lista.hae(2));
		assertEquals(new Integer(300), lista.hae(3));
	}

	@Test
	public void listaan_lisaaminen_poistamisen_jalkeen() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);
		lista.lisaa(400);

		lista.poista(3);
		lista.lisaa(900);
		
		assertEquals(new Integer(100), lista.hae(0));
		assertEquals(new Integer(200), lista.hae(1));
		assertEquals(new Integer(300), lista.hae(2));
		assertEquals(new Integer(900), lista.hae(3));
	}

	@Test
	public void listan_keskelta_poistaminen() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);

		lista.poista(1);

		assertEquals("[100, 300]", lista.toString());
		assertEquals(new Integer(100), lista.keula());
		assertEquals(new Integer(300), lista.pera());
	}

	@Test
	public void paivittaa_keulan_ja_peran_elementin_poistamisen_jalkeen() {
		lista.lisaa(100);

		assertNotNull(lista.keula());
		assertNotNull(lista.pera());

		lista.poista(0);

		assertNull(lista.keula());
		assertNull(lista.pera());
	}

	@Test
	public void listan_keskelta_poistaminen_ei_muuta_peraa() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);

		lista.poista(1);

		assertEquals(new Integer(300), lista.pera());
	}

	@Test
	public void ota() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);

		Integer otettu = lista.ota();

		assertFalse("poistaa otetun listasta", lista.sisaltaa(new Integer(100)));
		assertEquals("palauttaa otetun", new Integer(100), otettu);
		assertEquals("päivittää koon", 2, lista.koko());
		assertEquals("päivittää keulan", new Integer(200), lista.keula());
		assertEquals("pitää perän samana", new Integer(300), lista.pera());
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void tyhjasta_listasta_ei_voi_ottaa() {
		lista.ota();
	}

	@Test
	public void veda() {
		lista.lisaa(100);
		lista.lisaa(200);
		lista.lisaa(300);

		Integer vedetty = lista.veda();

		assertFalse("poistaa vedetyn listasta", lista.sisaltaa(new Integer(300)));
		assertEquals("palauttaa vedetyn", new Integer(300), vedetty);
		assertEquals("päivittää koon", 2, lista.koko());
		assertEquals("pitää keulan samana", new Integer(100), lista.keula());
		assertEquals("päivittää perän", new Integer(200), lista.pera());
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void tyhjasta_listasta_ei_voi_vetaa() {
		lista.veda();
	}

	@Test
	public void teesit() {
		lista.lisaa(300);
		lista.lisaa(400);
		lista.lisaa(500);

		lista.lado(200);
		lista.lado(100);

		assertFalse(lista.tyhja());
		assertEquals(5, lista.koko());
		assertEquals(new Integer(100), lista.keula());
		assertEquals(new Integer(500), lista.pera());
		assertEquals("[100, 200, 300, 400, 500]", lista.toString());

		lista.ota();

		assertFalse(lista.tyhja());
		assertEquals(4, lista.koko());
		assertEquals(new Integer(200), lista.keula());
		assertEquals(new Integer(500), lista.pera());
		assertEquals("[200, 300, 400, 500]", lista.toString());

		lista.veda();

		assertFalse(lista.tyhja());
		assertEquals(3, lista.koko());
		assertEquals(new Integer(200), lista.keula());
		assertEquals(new Integer(400), lista.pera());
		assertEquals("[200, 300, 400]", lista.toString());

		lista.poista(1);

		assertFalse(lista.tyhja());
		assertEquals(2, lista.koko());
		assertEquals(new Integer(200), lista.keula());
		assertEquals(new Integer(400), lista.pera());
		assertEquals("[200, 400]", lista.toString());

		lista.lisaa(1111);

		assertFalse(lista.tyhja());
		assertEquals(3, lista.koko());
		assertEquals(new Integer(200), lista.keula());
		assertEquals(new Integer(1111), lista.pera());
		assertEquals("[200, 400, 1111]", lista.toString());

		lista.lado(1);

		assertFalse(lista.tyhja());
		assertEquals(4, lista.koko());
		assertEquals(new Integer(1), lista.keula());
		assertEquals(new Integer(1111), lista.pera());
		assertEquals("[1, 200, 400, 1111]", lista.toString());

		assertTrue(lista.sisaltaa(1));
		assertTrue(lista.sisaltaa(200));
		assertTrue(lista.sisaltaa(400));
		assertTrue(lista.sisaltaa(1111));
	}
}
