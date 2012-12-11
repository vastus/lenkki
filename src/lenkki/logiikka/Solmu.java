
package lenkki.logiikka;

public class Solmu<E> {

	private E elem;
	private Solmu seuraava;

	public Solmu(E elem) {
		this.elem = elem;
		this.seuraava = null;
	}

	public Solmu seuraava() {
		return seuraava;
	}

	public void asetaSeuraava(Solmu solmu) {
		this.seuraava = solmu;
	}

	public E elem() {
		return elem;
	}

}
