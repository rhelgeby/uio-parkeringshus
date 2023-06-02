package no.helgeby.uio.generisk.parkeringshus;

import java.util.Objects;

public abstract class Fremkostmiddel {

	private Registreringsnummer registreringsnummer;

	public Fremkostmiddel(Registreringsnummer registreringsnummer) {
		Objects.requireNonNull(registreringsnummer, "registreringsnummer");
		this.registreringsnummer = registreringsnummer;
	}

	public Registreringsnummer getRegistreringsnummer() {
		return registreringsnummer;
	}

	public abstract void giVarsel();

}
