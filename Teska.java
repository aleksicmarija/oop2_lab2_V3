package skijanje;

public class Teska extends Deonica {
	private char oznaka;

	public Teska(double d, double n) {
		super(d, n);
		this.oznaka = 'T';
		// TODO Auto-generated constructor stub
	}

	@Override
	public double ubrzanje() {
		double toRadians = Math.toRadians(nagib);
		return 9.81*(Math.sin(toRadians));
	}

	public static void main(String[] args) {
	}

	@Override
	public char oznaka() {
		// TODO Auto-generated method stub
		return this.oznaka;
	}

}
