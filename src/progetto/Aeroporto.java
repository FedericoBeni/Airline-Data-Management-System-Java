package progetto;

public class Aeroporto {

	//Attributi
	private String codiceUnivoco;
	private String nazione;
	private int numMaxAereomobiliProcessabili;
	
	
	//Costruttore classe Aeroporto
	public Aeroporto(String codiceUnivoco, String nazione, int numMaxAereomobiliProcessabili) {
		this.codiceUnivoco = codiceUnivoco;
		this.nazione = nazione;
		this.numMaxAereomobiliProcessabili = numMaxAereomobiliProcessabili;
	
	}
	
	
	/*------------------------------METODI GET------------------------------*/
	
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public String getNazione() {
		return nazione;
	}

	public int getNumMaxAereomobiliProcessabili() {
		return numMaxAereomobiliProcessabili;
	}
	
	
	
	
	
}
