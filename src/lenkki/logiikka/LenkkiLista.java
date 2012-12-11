
package lenkki.logiikka;

import java.util.Arrays;

public class LenkkiLista<E> implements Lista<E> {

	private int koko;
	private Solmu<E> keula;
	private Solmu<E> pera;

	public LenkkiLista() {
		this.koko = 0;
		this.keula = null;
		this.pera = null;
	}

	@Override
	public boolean lado(E elem) {
		Solmu<E> solmu = new Solmu<>(elem);

		if (tyhja()) {
			this.keula = solmu;
			this.pera = solmu;
		} else {
			solmu.asetaSeuraava(keula);
			this.keula = solmu;
		}

		koko++;
		return true;
	}

	@Override 
	public boolean lisaa(E elem) {
		Solmu<E> solmu = new Solmu<>(elem);
		
		if (tyhja()) {
			this.keula = solmu;
			this.pera = solmu;
		} else {
			pera.asetaSeuraava(solmu);
			this.pera = solmu;
		}

		koko++;
		return true;
	}

	@Override
	public E poista(int indeksi) {
		tarkastaIndeksi(indeksi);

		Solmu<E> poistettava;

		if (koko == 1) {
			poistettava = keula;
			this.keula = null;
			this.pera = null;
		} else if (indeksi == 0) {
			poistettava = keula;
			this.keula = keula.seuraava();
		} else {
			Solmu<E> ankkuri = null;
			poistettava = keula;

			for (int i = 0; i < indeksi; i++) {
				ankkuri = poistettava;
				poistettava = poistettava.seuraava();
			}

			// ankkuri -> poistettavaa edeltävä solmu
			ankkuri.asetaSeuraava(poistettava.seuraava());
			if (ankkuri.seuraava() == null) {
				this.pera = ankkuri;
			}
		}
		
		koko--;
		return poistettava.elem();
	}

	@Override
	public E ota() {
		return poista(0);
	}

	@Override
	public E veda() {
		return poista(koko - 1);
	}

	@Override
	public E keula() {
		return (keula == null) ? null : keula.elem();
	}

	@Override
	public E pera() {
		return (pera == null) ? null : pera.elem();
	}

	@Override
	public E hae(int indeksi) {
		tarkastaIndeksi(indeksi);

		Solmu<E> solmu = keula;
		for (int i = 0; i < indeksi; i++) {
			solmu = solmu.seuraava();
		}

		return solmu.elem();
	}

	@Override
	public int koko() {
		return koko;
	}

	@Override
	public boolean tyhja() {
		return koko == 0;
	}

	@Override
	public boolean sisaltaa(E elem) {
		for (int i = 0; i < koko; i++) {
			if (elem.equals(hae(i))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		if (tyhja()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < koko; i++) {
			sb.append(hae(i).toString()).append(", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append("]");
		return sb.toString();
	}

	private void tarkastaIndeksi(int indeksi) {
		if (indeksi < 0 || indeksi >= koko ) {
			throw new IndexOutOfBoundsException();
		}
	}
}
