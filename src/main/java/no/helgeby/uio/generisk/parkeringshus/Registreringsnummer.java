package no.helgeby.uio.generisk.parkeringshus;

import static java.lang.Character.isUpperCase;

import java.util.Objects;

public class Registreringsnummer {

	private String verdi;

	/**
	 * Vi definerer et spesielt nummer for uregistrerte fremkostmidler.
	 */
	public static final Registreringsnummer UREGISTRERT = Registreringsnummer.av("AA000000");

	public Registreringsnummer(String registreringsnummer) {
		hevdGyldigFormat(registreringsnummer);
		verdi = registreringsnummer;
	}

	public String value() {
		return verdi;
	}

	public static Registreringsnummer av(String registreringsnummer) {
		return new Registreringsnummer(registreringsnummer);
	}

	public static void hevdGyldigFormat(String registreringsnummer) {
		Objects.requireNonNull(registreringsnummer, "registreringsnummer");

		if (registreringsnummer.length() != 8) {
			throw new IllegalArgumentException("Lengden må være 8 tegn.");
		}

		char bokstav1 = registreringsnummer.charAt(0);
		char bokstav2 = registreringsnummer.charAt(1);
		if (!isUpperCase(bokstav1) || !isUpperCase(bokstav2)) {
			throw new IllegalArgumentException("Registeringsnummeret må begynne med to store bokstaver.");
		}

		// Prøv å lese resten som tall i titallssystemet.
		String resten = registreringsnummer.substring(2);
		Integer.parseInt(resten);

		return;
	}

	@Override
	public String toString() {
		return verdi;
	}
}
