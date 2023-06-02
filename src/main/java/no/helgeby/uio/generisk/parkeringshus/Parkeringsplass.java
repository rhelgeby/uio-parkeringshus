package no.helgeby.uio.generisk.parkeringshus;

import java.util.Objects;

public class Parkeringsplass<E> {

	private E kjøretøy;

	/**
	 * @param kjøretøy Kjøretøy som skal parkeres.
	 * @return Om et kjøretøyet ble parkert.
	 */
	public boolean parker(E kjøretøy) {
		Objects.requireNonNull(kjøretøy, "kjøretøy");
		if (!erLedig()) {
			return false;
		}
		System.out.println("Parkerer " + kjøretøy);
		this.kjøretøy = kjøretøy;
		return true;
	}

	/**
	 * @return Kjøretøyet som var parkert.
	 * @throws IllegalStateException hvis ingen ting er parkert.
	 */
	public E kjørUt() {
		if (erLedig()) {
			throw new IllegalStateException("Ingen ting er parkert her.");
		}

		System.out.println("Kjører ut " + kjøretøy);
		E kjøretøy = this.kjøretøy;
		this.kjøretøy = null;
		return kjøretøy;
	}

	/**
	 * @return Om plassen kan ta i mot et kjøretøy.
	 */
	public boolean erLedig() {
		return kjøretøy == null;
	}

}
