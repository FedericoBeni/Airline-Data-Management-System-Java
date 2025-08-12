/*Durante l'implementazione è stato assunto che l’input fosse sempre corretto (come scritto nella traccia del progetto), 
 * quindi non vi è stata necessità di effettuare controlli; per quanto sono state fatte diverse prove per verificare
 * se cambiando i dati in input il valore finale delle risposte effettivamente cambiasse*/
//Binci Alessandro, Beni Federico


package progetto;

//Librerie per lavorare con i vettori di lunghezza variabile, gli HashSet e Scanner
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Progetto {

	//ArrayLists per aggiungere gli elementi all'interno di esse
	private static ArrayList<Aeromobile> aeromobili = new ArrayList<>();
    private static ArrayList<Aeroporto> aeroporti = new ArrayList<>();
    private static ArrayList<Viaggio> viaggi = new ArrayList<>();
    //Inizializzazione variabili
	private static int numAeromobili = 0;
	private static int numAeroporti  = 0;
	private static int numViaggi  = 0;
	
	
	//Metodo main contenente lettura da standard input
	public static void main(String[] args) 
	{
		//Legge i dati da standard input
		Scanner sc = new Scanner(System.in);
		
		//Lettura dati
		numAeromobili = sc.nextInt(); //nextInt per leggere gli interi nella riga (senza avere problemi con gli spazi)
        numAeroporti = sc.nextInt();
        numViaggi = sc.nextInt();
        sc.nextLine();//nextLine per andare poi a leggere la linea successiva
        
        leggiAeromobili(sc, numAeromobili);
        leggiAeroporti(sc, numAeroporti);
        leggiViaggi(sc, numViaggi);
        

        // Determinazione del task da eseguire
        String task = sc.next(); //next per leggere la riga (senza avere problemi con gli spazi)
        //Utilizzo di switch perché ci sono tre diversi casi distinti che sappiamo devono essere quelli
        switch (task) {
            case "TASK1":
                executeTask1();
                break;
            case "TASK2":
                int p = sc.nextInt();
                int q = sc.nextInt();
                executeTask2(p, q);
                break;
            case "TASK3":
                int numNuoviViaggi = sc.nextInt();
                ArrayList<Viaggio> nuoviViaggi = leggiNuoviViaggi(sc, numNuoviViaggi);
                executeTask3(nuoviViaggi);
                break;
        }
	}
	
	/*--------------------------------Metodi per leggere dati--------------------------------------------*/
	
    //Metodo per leggere gli aeromobili
	private static void leggiAeromobili(Scanner sc, int num) {
		//Iterazione per scorrere ed assegnare gli elementi
    	for (int i = 0; i < num; i++) {
            String codice = sc.next();
            int maxPasseggeri = sc.nextInt();
            int capacitaSerbatoio = sc.nextInt();
            int viaggiEffettuati = sc.nextInt();
            
            //Aggiungo gli aeromobili all'ArrayList
            aeromobili.add(new Aeromobile(codice, maxPasseggeri, capacitaSerbatoio, viaggiEffettuati));
        }
    	sc.nextLine();
    }
    
  
    //Metodo per leggere gli aeroporti
    private static void leggiAeroporti(Scanner sc, int num) {
    	//Iterazione per scorrere ed assegnare gli elementi
        for (int i = 0; i < num; i++) {    	
        	String[] parts = sc.nextLine().split(","); //Uso split perché nell'input ho le virgole
            String codice = parts[0].toString();
            String nazione = parts[1].toString();
            int maxAeromobiliDaProcessare = Integer.parseInt(parts[2].toString());
            
             //Aggiungo gli aeroporti all'ArrayList
            aeroporti.add(new Aeroporto(codice, nazione, maxAeromobiliDaProcessare));
        }
    }

    //Metodo per leggere i viaggi
    private static void leggiViaggi(Scanner sc, int num) {
    	//Iterazione per scorrere ed assegnare gli elementi
        for (int i = 0; i < num; i++) {
            String codiceAeromobile = sc.next();
            int numPasseggeri = sc.nextInt();
            String codicePartenza = sc.next();
            String codiceArrivo = sc.next();
            int giorno = sc.nextInt();

            //Esecuzione funzione per trovare l'aeromobile, e gli aeroporti di partenza e arrivo
            Aeromobile aeromobile = findAeromobileByCodice(codiceAeromobile);
            Aeroporto partenza = findAeroportoByCodice(codicePartenza);
            Aeroporto arrivo = findAeroportoByCodice(codiceArrivo);
            
            //Aggiungo i viaggi all'ArrayList
            viaggi.add(new Viaggio(aeromobile, numPasseggeri, partenza, arrivo, giorno));
        }
    }

    //Metodo per leggere i nuovi viaggi per la task 3
    private static ArrayList<Viaggio> leggiNuoviViaggi(Scanner sc, int num) {
    	
    	//ArrayList per i nuovi viaggi
    	ArrayList<Viaggio> nuoviViaggi = new ArrayList<>();
    	//Iterazione per scorrere ed assegnare gli elementi
        for (int i = 0; i < num; i++) {
            String codiceAeromobile = sc.next();
            int numPasseggeri = sc.nextInt();
            String codicePartenza = sc.next();
            String codiceArrivo = sc.next();
            int giorno = sc.nextInt();

            //Esecuzione funzione per trovare l'aeromobile, e gli aeroporti di partenza e arrivo
            Aeromobile aeromobile = findAeromobileByCodice(codiceAeromobile);
            Aeroporto partenza = findAeroportoByCodice(codicePartenza);
            Aeroporto arrivo = findAeroportoByCodice(codiceArrivo);

            //Aggiungo i nuovi viaggi all'ArrayList
            nuoviViaggi.add(new Viaggio(aeromobile, numPasseggeri, partenza, arrivo, giorno));
        }
        return nuoviViaggi;
    }

    /*--------------Metodi per trovare aeromobili e aeroporti------------------*/
    private static Aeromobile findAeromobileByCodice(String codice) {
        for (Aeromobile a : aeromobili) {
            if (a.getCodiceUnivoco().equals(codice)) return a;
        }
        return null;
    }

    private static Aeroporto findAeroportoByCodice(String codice) {
        for (Aeroporto a : aeroporti) {
            if (a.getCodiceUnivoco().equals(codice)) return a;
        }
        return null;
    }
	
    /*---------------------------Metodi Execute -------------------------------------*/
    
    //Metodo execute per il primo task
    private static void executeTask1() {
        // 1. Numero totale di aeromobili, aeroporti e viaggi
        //Stampa a schermo la grandezza delle diverse ArrayLists
        System.out.println(aeromobili.size() + " " + aeroporti.size() + " " + viaggi.size()); 

        // 2. Numero totale di viaggi overboard e underboard
        int overboardCount = 0;
        int underboardCount = 0;
        //Iterazione per capire il tipo di viaggio
        for (Viaggio v : viaggi) {
            if (v.getTipo() == TipoViaggio.OVERBOARD) overboardCount++;
            if (v.getTipo() == TipoViaggio.UNDERBOARD) underboardCount++;
        }
        System.out.println(overboardCount + " " + underboardCount); //Stampa a schermo quanti viaggi overboard e underboard

        // 3. Aeroporto con il numero massimo di aeromobili da processare
        //Si prende il primo valore dell ArrayList aeroporti
        Aeroporto aeroportoMax = aeroporti.get(0);
        //Iterazione per impostare il valore più alto
        for (Aeroporto a : aeroporti) {
            if (a.getNumMaxAereomobiliProcessabili() > aeroportoMax.getNumMaxAereomobiliProcessabili()) {
                aeroportoMax = a;
            }
        }
        
        System.out.println(aeroportoMax.getCodiceUnivoco()); //Stampa a schermo il codice univoco dell'aeroporto con il numero massimo di aeromobili da processare più alto

        // 4. Numero di aeromobili con capacità del serbatoio maggiore di 108
        int aeroCount = 0;
        //Iterazione per incrementare il numero di aerei con il serbatoio maggiore a 108
        for (Aeromobile a : aeromobili) {
            if (a.getCapacitaMaxSerbatoio() > 108) aeroCount++;
        }
        System.out.println(aeroCount); //Stampa a schermo gli aeromobili con capacità del serbatoio maggiore di 108

        // 5. Primo giorno con il numero di viaggi effettuati più alto
        int[] giorni = new int[366];
        //Iterazione per vedere il giorno in cui c'è stato il volo
        for (Viaggio v : viaggi) {
            giorni[v.getGiorno()]++;
        }
        int giornoMax = 1;
        //Iterazione per impostare il giorno con maggiori viaggi effettuati
        for (int i = 2; i <= 365; i++) {
            if (giorni[i] > giorni[giornoMax]) {
                giornoMax = i;
            }
        }
        System.out.println(giornoMax); //Stampa a schermo il primo giorno con il numero di viaggi effettuati più alto

        // 6. Numero di aeromobili con esattamente 42 viaggi effettuati
        int aero42Count = 0;
        //Iterazione per controllare se ci sono aeromobili con esattamente 42 viaggi
        for (Aeromobile a : aeromobili) {
            if (a.getNumViaggiUltimoAnno() == 42) aero42Count++;
        }
        System.out.println(aero42Count); //Stampa a schermo il num di aereomobili con esattamente 42 viaggi effettuati

        // 7. Numero di aeroporti senza collegamenti
        int aeroportiSenzaCollegamenti = 0;
        //Ciclo annidato per controllare i collegamenti scorrendo gli ArrayList di aeroporti e viaggi
        for (Aeroporto a : aeroporti) {
            boolean hasConnection = false;
            for (Viaggio v : viaggi) {
                if (v.getPartenza().equals(a) || v.getArrivo().equals(a)) {
                    hasConnection = true;
                    break;
                }
            }
            //Si controlla se la condizione che ottengo è vera o falsa, e in tal caso la post-incremento
            if (!hasConnection) aeroportiSenzaCollegamenti++;
        }
        System.out.println(aeroportiSenzaCollegamenti);//Stampa a schermo il numero di aeroporti senza collegamenti

        // 8. Numero di giorni in cui hanno viaggiato complessivamente almeno 815 passeggeri
        int giorni815 = 0;
        //Iterazione per controllare i passeggeri totali per ogni viaggio
        for (int i = 1; i <= 365; i++) {
            int passeggeriTotali = 0;
            for (Viaggio v : viaggi) {
                if (v.getGiorno() == i) passeggeriTotali += v.getNumeroPasseggeri();
            }
            if (passeggeriTotali >= 815) giorni815++;
        }
        System.out.println(giorni815);//Stampa a schermo il numero di giorni in cui hanno viaggiato complessivamente almeno 815 passeggeri
    }

    //Metodo execute per il secondo task
    //Si devono utilizzare due interi che si avranno nell'input
    private static void executeTask2(int p, int q) {
    	//Inizializzazione dei 4 diversi casi che potranno essere validi o meno
        boolean condition1 = false, condition2 = false, condition3 = false, condition4 = false;

        // 1. Almeno p aeromobili coinvolti in almeno q viaggi
        int count = 0;
        //Ciclo annidato per scorrere gli elementi delle ArrayList aeromobili e viaggi
        for (Aeromobile a : aeromobili) {
            int viaggiCount = 0;
            for (Viaggio v : viaggi) {
                if (v.getAeromobile().equals(a)) {
                    viaggiCount++;
                }
            }
            //Per ogni q viaggi...
            if (viaggiCount >= q) count++;
        }
        //...devono essserci almeno p aeromobili per far si che la condizione finale sia vera
        if (count >= p) condition1 = true;

        // 2. Almeno p viaggi con almeno un aeromobile in comune che si tengono a distanza di al piu due giorni
        count = 0;
        //Ciclo annidato per confrontare più giorni
        for (Viaggio v1 : viaggi) {
            for (Viaggio v2 : viaggi) {
            	//Condizione per effettuare il controllo successivo
                if (!v1.equals(v2) && v1.getAeromobile().equals(v2.getAeromobile()) && (v1.getGiorno() - v2.getGiorno()) <= 2) {
                    count++;
                    break;
                }
            }
        }
        //Variabile maggiore di almeno p viaggi per far si che la condizione finale sia vera
        if (count >= p) condition2 = true;

        // 3. Almeno p e al massimo q aeroporti coinvolti in viaggi di tipo overboard
        
        //Utilizzo di HashSet invece di ArrayList perché con questo non ci sono i duplicati
        HashSet<Aeroporto> aeroportiOverboard = new HashSet<>();
        //Iterazione per controllare gli aeroporti coinvolti con il tipo di viaggio
        for (Viaggio v : viaggi) {
            if (v.getTipo() == TipoViaggio.OVERBOARD) {
                aeroportiOverboard.add(v.getPartenza());
                aeroportiOverboard.add(v.getArrivo());
            }
        }
        //Ci devono essere almeno p e al masssimo q aeroporti per far si che la condizione finale sia vera
        if (aeroportiOverboard.size() >= p && aeroportiOverboard.size() <= q) condition3 = true;

        // 4. Almeno p viaggi i cui aeroporti di partenza e destinazione non risiedono nella stessa nazione
        count = 0;
        //Iterazione per controllare partenza e arrivo dei viaggi
        for (Viaggio v : viaggi) {
            if (!v.getPartenza().getNazione().equals(v.getArrivo().getNazione())) count++;
        }
        //Ci devono essere almeno p viaggi (con le condizioni controllate nel ciclo) per far si che la condizione finale sia vera
        if (count >= p) condition4 = true;
        
        //Utilizzo dell'operatore ternario per verificare la validità o meno delle quattro condizioni
        System.out.println(condition1 && condition2 && condition3 && condition4 ? "YES" : "NO");
    }

    //Metodo execute per il terzo task
    private static void executeTask3(ArrayList<Viaggio> nuoviViaggi) {
    	//Inizializzazione dei 4 diversi casi che potranno essere validi o meno
        boolean condition1 = false, condition2 = false, condition3 = false;

        // 1. Almeno un aeroporto che non appare nella lista dei nuovi viaggi
        //Ciclo annidato per confrontare gli aeroporti con i nuovi viaggi
        for (Aeroporto a : aeroporti) {
        	//Impostazione variabile a falso inizialmente
            boolean found = false;
            for (Viaggio v : nuoviViaggi) {
            	//Impostazione condizioni richieste dalla traccia
                if (v.getPartenza().equals(a) || v.getArrivo().equals(a)) {
                    found = true;
                    break;
                }
            }
            //Si controlla se la condizione che ottengo è vera o falsa, e in tal caso imposto la condizione finale a vera
            if (!found) {
                condition1 = true;
                break;
            }
        }

        // 2. Almeno un viaggio nella nuova lista che sia un viaggio ponte
        //Ciclo annidato per controllare il nuovo viaggio all'interno dei viaggi
        for (Viaggio vx : nuoviViaggi) {
            for (Viaggio va : viaggi) {
                for (Viaggio vb : viaggi) {
                	//Impostazione condizioni richieste dalla traccia
                    if (vx.getAeromobile().equals(va.getAeromobile()) && vx.getAeromobile().equals(vb.getAeromobile()) && vx.getPartenza().equals(va.getArrivo()) && vx.getArrivo().equals(vb.getPartenza()) && vx.getGiorno() == va.getGiorno() + 1 && vx.getGiorno() == vb.getGiorno() - 1) {
                        condition2 = true;
                        break;
                    }
                }
                if (condition2) break;
            }
            if (condition2) break;
        } //Se le condizoni sono sempre valide esco dal ciclo annidato

        // 3. Almeno un viaggio ordinario nella lista fornita
        //Iterazione per controllare il tipo di viaggio all'interno dell'ArrayList nuoviViaggi
        for (Viaggio v : nuoviViaggi) {
            if (v.getTipo() == TipoViaggio.ORDINARIO) {
                condition3 = true;
                break;
            }
        }
        
        //Utilizzo dell'operatore ternario per verificare la validità o meno delle tre condizioni
        System.out.println(condition1 && condition2 && condition3 ? "VALID" : "NOT VALID");
    }

    
    
}