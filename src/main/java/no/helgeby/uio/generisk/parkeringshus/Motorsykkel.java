package no.helgeby.uio.generisk.parkeringshus;

public class Motorsykkel extends LiteFremkostmiddel {

	private int kubikk;

	public Motorsykkel(Registreringsnummer registreringsnummer, int kubikk) {
		super(registreringsnummer);
		if (kubikk <= 0) {
			throw new IllegalArgumentException("Kubikk kan ikke vøre 0 eller mindre. Prøv en Trehjulssykkel i stedet.");
		}
		this.kubikk = kubikk;
	}

	public int getKubikk() {
		return kubikk;
	}

	@Override
	public void giVarsel() {
		System.out.println("Meep!");
	}

	@Override
	public String toString() {
		return "motorsykkel " + getRegistreringsnummer();
	}

}
