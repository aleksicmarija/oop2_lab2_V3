package skijanje;

public abstract class Deonica {
	protected double duzina;
	protected double nagib;
	
	public Deonica(double d, double n) {
		this.duzina = d;
		this.nagib = n;
	}
	
	abstract public double ubrzanje();
	
	public double brzina(double pocetnaBrzina) {
		return Math.sqrt(2*this.ubrzanje()*this.duzina+pocetnaBrzina*pocetnaBrzina);
	}
	
	public double vreme(double pocetnaBrzina) {
		return ((this.brzina(pocetnaBrzina)-pocetnaBrzina)/this.ubrzanje());
	}
	
	abstract public char oznaka();


	public double duzina() {
		return this.duzina;
	}


	public double nagib() {
		return nagib;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.oznaka() + "(" + duzina + "," + nagib + ")");
		return sb.toString();
	}


	public static void main(String[] args) {
	}

}
