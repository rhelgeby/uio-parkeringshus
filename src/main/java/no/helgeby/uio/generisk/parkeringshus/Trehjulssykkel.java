package no.helgeby.uio.generisk.parkeringshus;

public class Trehjulssykkel extends LiteFremkostmiddel {

	public Trehjulssykkel() {
		super(Registreringsnummer.UREGISTRERT);
	}

	@Override
	public void giVarsel() {
		System.out.println("Flytt deg!");
	}

	@Override
	public String toString() {
		return "en trehjulssykkel";
	}

}
