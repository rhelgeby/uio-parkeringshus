package no.helgeby.uio.generisk.parkeringshus;

public class Bil extends StortFremkostmiddel {

	private int antallPasasjerer;

	public Bil(Registreringsnummer registreringsnummer, int antallPasasjerer) {
		super(registreringsnummer);

		if (antallPasasjerer < 0) {
			throw new IllegalArgumentException("Kan ikke lage en bil med negativt antall pasasjerer.");
		}
		this.antallPasasjerer = antallPasasjerer;
	}

	public int getAntallPasasjerer() {
		return antallPasasjerer;
	}

	@Override
	public void giVarsel() {
		System.out.println("Tut!");
	}

	@Override
	public String toString() {
		return "bil " + getRegistreringsnummer();
	}

}
