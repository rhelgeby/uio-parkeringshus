package no.helgeby.uio.generisk.parkeringshus;

import java.util.ArrayList;
import java.util.List;

public class Parkeringshus {

	private List<Parkeringsplass<Fremkostmiddel>> storePlasser;
	private List<Parkeringsplass<LiteFremkostmiddel>> småPlasser;

	/**
	 * Hvor stort et parkeringshus kan bli.
	 */
	public static final int MAKS_PLASSER = 1000;

	/**
	 * Oppretter et parkeringshus.
	 * 
	 * @throws IllegalArgumentException hvis antall plasser er negativt.
	 * @throws IllegalArgumentException hvis det totale antall plasser er mindre enn
	 *                                  én plass.
	 * @throws IllegalArgumentException hvis parkeringshuset blir for stort.
	 */
	public Parkeringshus(int antallStorePlasser, int antallSmåPlasser) {
		if (antallStorePlasser < 0 || antallSmåPlasser < 0) {
			throw new IllegalArgumentException("Antall plasser kan ikke være negativt.");
		}

		int totalePlasser = antallStorePlasser + antallSmåPlasser;
		if (totalePlasser < 1) {
			throw new IllegalArgumentException("Trenger minst én plass.");
		} else if (totalePlasser > MAKS_PLASSER) {
			throw new IllegalArgumentException("Vi har ikke råd til å bygge mer enn " + MAKS_PLASSER + " plasser.");
		}

		storePlasser = new ArrayList<Parkeringsplass<Fremkostmiddel>>(antallStorePlasser);
		småPlasser = new ArrayList<Parkeringsplass<LiteFremkostmiddel>>(antallSmåPlasser);

		// Opprett parkeringsplasser. For øyeblikket er listene tomme.

		for (int i = 0; i < antallStorePlasser; i++) {
			Parkeringsplass<Fremkostmiddel> plass = new Parkeringsplass<Fremkostmiddel>();
			storePlasser.add(plass);
		}
		for (int i = 0; i < antallSmåPlasser; i++) {
			Parkeringsplass<LiteFremkostmiddel> plass = new Parkeringsplass<LiteFremkostmiddel>();
			småPlasser.add(plass);
		}
	}

	/**
	 * Prøver å parkere et fremkostmiddel.
	 * 
	 * @param fremkostmiddel Fremkostmiddel som skal parkeres.
	 * @return Om kjøretøyet ble parkert.
	 */
	public boolean parker(Fremkostmiddel fremkostmiddel) {
		if (fremkostmiddel instanceof LiteFremkostmiddel liteFremkostmiddel) {
			// Prøv de små plassene først for små fremkostmidler.
			boolean fantLitenPlass = parkerLiten(liteFremkostmiddel);
			if (fantLitenPlass) {
				return true;
			}
		}

		Parkeringsplass<Fremkostmiddel> plass = finnStorPlass(storePlasser);
		if (plass == null) {
			return false;
		}

		return parkerStor(fremkostmiddel);
	}

	/**
	 * Prøver å parkere et fremkostmiddel på en stor plass.
	 * 
	 * @param fremkostmiddel Fremkostmiddel som skal parkeres.
	 * @return Om kjøretøyet ble parkert.
	 */
	public boolean parkerStor(Fremkostmiddel fremkostmiddel) {
		Parkeringsplass<Fremkostmiddel> p = finnStorPlass(storePlasser);
		if (p == null) {
			return false;
		}
		return p.parker(fremkostmiddel);
	}

	/**
	 * Prøver å parkere et lite fremkostmiddel på en liten plass.
	 * 
	 * @param fremkostmiddel Fremkostmiddel som skal parkeres.
	 * @return Om kjøretøyet ble parkert.
	 */
	public boolean parkerLiten(LiteFremkostmiddel fremkostmiddel) {
		Parkeringsplass<LiteFremkostmiddel> p = finnLitenPlass(småPlasser);
		if (p == null) {
			return false;
		}
		return p.parker(fremkostmiddel);
	}

	private Parkeringsplass<Fremkostmiddel> finnStorPlass(List<Parkeringsplass<Fremkostmiddel>> plasser) {
		for (var parkeringsplass : plasser) {
			if (parkeringsplass.erLedig()) {
				return parkeringsplass;
			}
		}
		return null;
	}

	private Parkeringsplass<LiteFremkostmiddel> finnLitenPlass(List<Parkeringsplass<LiteFremkostmiddel>> plasser) {
		for (var parkeringsplass : plasser) {
			if (parkeringsplass.erLedig()) {
				return parkeringsplass;
			}
		}
		return null;
	}

}
