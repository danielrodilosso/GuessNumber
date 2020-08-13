package it.polito.tdp.numero.model;

import java.util.Random;

public class Partita {
	public final static int N_MIN = 0;
	public final static int N_MAX = 100;
	public final static int T_MAX = 8;

	private int segreto;
	private int tentativoGiocatore;
	private int tentativiFatti;
	private boolean inGioco;
	
	public Partita() {
		inGioco = false;
	}
	
    //Logica di gioco
    public void inizializzazionePartita() {
    	Random r = new Random(); //generiamo il numero segreto da indovinare:
    	segreto = r.nextInt(N_MAX); // assegniamo il numero casuale
    	tentativiFatti = 0;
    	inGioco = true;
    }
    
    //Verifica che la partita sia finita per aver indovinato il numero ( == 0) o
    //per aver terminato il numero Massimo di tentativi ( == 1).
    private int controlloTerminePartita() {
    	if (tentativoGiocatore == segreto) {
    		inGioco = false;
    		return 0;
    	} else if (tentativiFatti == T_MAX) {
    		inGioco = false;
    		return 1;
    	}
    	
    	return 2;
    }
    
    private boolean rangeCorretto(final int tentativoProvato) {
    	if(tentativoProvato < N_MIN || tentativoProvato > N_MAX) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public int tentativoGiocatore(final int tentativoProvato) {
    	tentativoGiocatore = tentativoProvato;
		
    	// Nel caso in cui si vogliano far valere anche i tentativi di numero fuori dal Range
    	//if(rangeCorretto(tentativoProvato) == true) {
    		tentativiFatti++;
    	//}
		return (T_MAX - this.tentativiFatti);
    }
    
    public int controlloTentativo() {
    	int risultato = controlloTerminePartita();
    	
    	if(controlloTerminePartita() == 2) {
    	//Significa che NON abbiamo raggiunto il numero Massimo di tentativi o non è stato
    	//trovato il numero segreto e quindi si è perso
    		
    		if(this.rangeCorretto(tentativoGiocatore) == false){
				/*
			 * if(tentativoGiocatore == segreto || tentativiFatti == T_MAX) { inGioco =
			 * false; }
			 */
    		
    			return 4;
    		}
    	
			/*
		 	* if(tentativoGiocatore == segreto) { inGioco = false; return 0; }
		 	* 
		 	* if(tentativiFatti == T_MAX) { inGioco = false; return 1; }
		 	*/
    		if(tentativoGiocatore < segreto) {
    			return 2;
    		}else {
    			return 3;
    		}
    	}
    	return risultato;
    }

    // ELENCO Metodi Getter e Setter:
    
    public int getTentativiFatti() {
    	return this.tentativiFatti;
    }
    
    public int getNumeroSegreto() {
    	return this.segreto;
    }
    
    public boolean getInGioco() {
    	return this.inGioco;
    }
    
    public int getTentativoGiocatore() {
    	return this.tentativoGiocatore;
    }
    
    public void setInGioco(final boolean inGioco) {
    	this.inGioco = inGioco;
    }
    
   
}
