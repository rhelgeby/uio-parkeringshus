package no.helgeby.uio.generisk.parkeringshus;

public class Applikasjon {

	private static final int STORE_PLASSER = 10;
	private static final int SMÅ_PLASSER = 3;

	public static void main(String[] args) {
		Parkeringshus hus = new Parkeringshus(STORE_PLASSER, SMÅ_PLASSER);

		Trehjulssykkel lilleBlå = new Trehjulssykkel();
		Motorsykkel broom = new Motorsykkel(Registreringsnummer.av("BR346790"), 500);

		hus.parker(lilleBlå);
		hus.parker(broom);
	}

}
