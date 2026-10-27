package Registro;

public class Pokemon {
	String nombre,tipo;
	int ataque , defensa , hp ;
	
	public Pokemon() {
		super();
	}

	public Pokemon(String nombre, String tipo, int ataque, int defensa, int hp) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataque = ataque;
		this.defensa = defensa;
		this.hp = hp;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getHp() {
		return hp;
	}
	
	
	
}
