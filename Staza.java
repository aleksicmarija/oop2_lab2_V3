package skijanje;

import java.util.ArrayList;

public class Staza {
	private String naziv;
	private ArrayList<Deonica> listaDeonica;
	
	public Staza(String n) {
		this.naziv = n;
		listaDeonica = new ArrayList<>();
	}
	
	public void dodaj(Deonica d) {
		listaDeonica.add(d);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.naziv).append("|").append(this.broj()).append("|").append(this.duzina()).append("|").append(this.nagib()).append("\n");
		sb.append("[");
		for (Deonica d:listaDeonica) {
			sb.append(d);
			if (listaDeonica.indexOf(d) != (listaDeonica.size()-1)) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
		
	}
	
	public char oznaka() throws GOznaka{
		if (listaDeonica.size() == 0) {
			throw new GOznaka();
		}
		ArrayList<Character> novaLista = new ArrayList<>();
		for (Deonica d:listaDeonica) {
			novaLista.add(d.oznaka());
		}
		novaLista.sort(null);
		int max = 1;
		char rez = novaLista.get(0);
		int curr = 1;
		for (int i = 1;i<novaLista.size();i++) {
			if (novaLista.get(i) == novaLista.get(i-1)) {
				curr++;
			}else {
				if (curr > max) {
					max = curr;
					rez = novaLista.get(i-1);
				}
				curr = 1;
			}
			if (curr > max) {
				max = curr;
				rez = novaLista.get(novaLista.size()-1);
			}
		}
		return rez;
	}
	
	public int broj() {
		return listaDeonica.size();
	}
	
	public double duzina() {
		int s = 0;
		for (Deonica d:listaDeonica) {
			s += d.duzina;
		}
		return s;
	}
	
	public double nagib() {
		double max = -500;
		for (Deonica d:listaDeonica) {
			if (d.nagib() > max) {
				max = d.nagib();
			}
		}
		return max;
	}
	
	public double brzina(double pocetnaBrzina) {
		for (Deonica d:listaDeonica) {
			pocetnaBrzina = d.brzina(pocetnaBrzina);
		}
		return pocetnaBrzina;
	}
	
	
	public double vreme(double pocetnaBrzina) {
		double vreme = 0;
		for (Deonica d:listaDeonica) {
			vreme += d.vreme(pocetnaBrzina);
			pocetnaBrzina = d.brzina(pocetnaBrzina);
		}
		return vreme;
	}

	
	public static void main(String[] args) {
		Teska deonica = new Teska(100,5);
		Staza s = new Staza("Staza");
		s.dodaj(deonica);
		System.out.println(s);
	}

}
