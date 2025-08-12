package progetto;

public class Viaggio {
	
	//Attributi
	private Aeromobile aeromobile;
    private int numeroPasseggeri;
    private Aeroporto partenza;
    private Aeroporto arrivo;
    private int giorno;
    private TipoViaggio tipo;
	
    // Costruttore classe Viaggio
    public Viaggio(Aeromobile aeromobile, int numeroPasseggeri, Aeroporto partenza, Aeroporto arrivo, int giorno) {
        this.aeromobile = aeromobile;
        this.numeroPasseggeri = numeroPasseggeri;
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.giorno = giorno;
        this.tipo = determinaTipoViaggio();
    }

    // Metodo per determinare il tipo di viaggio utilizzando l'apposita classe
    private TipoViaggio determinaTipoViaggio() {
    	//Cast con double
        double percentuale = (double) numeroPasseggeri / aeromobile.getNumMaxPasseggeri();
        if (percentuale > 0.9) {
            return TipoViaggio.OVERBOARD;
        } else if (percentuale < 0.1) {
            return TipoViaggio.UNDERBOARD;
        } else {
            return TipoViaggio.ORDINARIO;
        }
        
    }
    
    /*------------------------------METODI GET------------------------------*/

	public Aeromobile getAeromobile() {
		return aeromobile;
	}

	public int getNumeroPasseggeri() {
		return numeroPasseggeri;
	}

	public Aeroporto getPartenza() {
		return partenza;
	}

	public Aeroporto getArrivo() {
		return arrivo;
	}

	public int getGiorno() {
		return giorno;
	}

	public TipoViaggio getTipo() {
		return tipo;
	}

   
    
    
}
