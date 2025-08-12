package progetto;

public class Aeromobile {
	
	//Attributi
	private String codiceUnivoco;
	private int numMaxPasseggeri;
	private int capacitaMaxSerbatoio;
	private int numViaggiUltimoAnno;
	
	
	//Costruttore classe Aeromobile
	public Aeromobile(String codiceUnivoco, int numMaxPasseggeri, int capacitaMaxSerbatoio, int numViaggiUltimoAnno) {
		this.codiceUnivoco = codiceUnivoco;
		this.numMaxPasseggeri = numMaxPasseggeri;
		this.capacitaMaxSerbatoio = capacitaMaxSerbatoio;
		this.numViaggiUltimoAnno = numViaggiUltimoAnno;
	}

	/*------------------------------METODI GET------------------------------*/
	
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public int getNumMaxPasseggeri() {
		return numMaxPasseggeri;
	}

	public int getCapacitaMaxSerbatoio() {
		return capacitaMaxSerbatoio;
	}

	public int getNumViaggiUltimoAnno() {
		return numViaggiUltimoAnno;
	}
	
	
	
}
