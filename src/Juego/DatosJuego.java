package Juego;

public class DatosJuego {

	private static DatosJuego datos = null;
	
	private Mapa mapa = Mapa.getInstance();
	
	private Integer score;

	private Integer diamantesRecolectados;

	private Integer diamantesTotales;

	private Integer diamantesPorRecolectar;
	

	private Integer vidas = 4;
	
	private int nivelActual;
	
	private int tiempo=150;
	

	/**
	 * Constructor principal de la clase DatosJuego.
	 */
	private DatosJuego() {
		this.score = 0;
		this.diamantesRecolectados = 0;
		this.diamantesTotales = 0;

	}

	/**
	 * @return la unica instancia existente de la logica.
	 */
	public static DatosJuego getInstance() {
		if (datos == null)
			datos = new DatosJuego();
		
		return datos;			
	}

	/**
	 * Se obtienen los diamantes actuales.
	 * @return numero de diamantes
	 */
	public Integer getDiamantesRecolectados() {
		return diamantesRecolectados;
	}

	/**
	 * Cada vez que se agarra un diamante se incrementa los "e" 
	 * diamantes recibidos.
	 * 
	 * @param e recibe el numero de diamantes agarrados en esa acci�n
	 */
	public void increaseDiamantesRecolectados(Integer e) {
		this.diamantesRecolectados = this.diamantesRecolectados + e;
	}

	/**
	 * Setea la cantidad de diamantes actuales.
	 * @param diamantesRecolectados recibe la cantidad actual de diamantes
	 */
	public void setDiamantesRecolectados(Integer diamantesRecolectados) {
		this.diamantesRecolectados = diamantesRecolectados;
	}

	/**
	 * Obtiene la cantidad total de diamantes.
	 * @return devuelve el numero de diamantes totales
	 */
	public Integer getDiamantesTotales() {
		return diamantesTotales;
	}

	/**
	 * Setea la cantidad total de diamantes.
	 * @param diamantesTotales recibe la cantidad total de diamantes
	 */
	public void setDiamantesTotales(Integer diamantesTotales) {
		this.diamantesTotales = diamantesTotales;
	}

	/**
	 * Obtiene la cantidad de diamantes a recolectar.
	 * @return devuelve la cantidad de diamantes a recolectar
	 */
	public Integer getDiamantesPorRecolectar() {
		return diamantesPorRecolectar;
	}

	/**
	 * Se setea la cantidad de diamantes a recolectar.
	 * @param diamantesPorRecolectar reciba la cantidad de diamantes a recolectar
	 */
	public void setDiamantesPorRecolectar(Integer diamantesPorRecolectar) {
		this.diamantesPorRecolectar = diamantesPorRecolectar;
	}

	/**
	 * Se setea el score del jugador.
	 * @param score recibe el score del personaje
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * Incrementa el score del personaje en una cantidad e.
	 * @param e recibe una cantidad de puntos
	 */
	public void increaseScore(Integer e) {
		this.score = this.score + e;
	}

	/**
	 * Se obtiene el score del jugador.
	 * @return devuelve el score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Setea la cantidad de vidas del jugador.
	 * @param vidas cantidad de vidas del jugador
	 */
	public void setLife(Integer vidas) {
		this.vidas = vidas;
	}

	/**
	 * Se decrementa las vidas del jugador.
	 */
	public void decVidas() {
		this.vidas--;
	}

	/**
	 * Se obtiene las vidas del jugador.
	 * @return devuelve el numero de vidas
	 */
	public int getVidas() {
		return this.vidas;
	}

	public void update() {

	}

	/**
	 * Se obtiene el nivel actual.
	 * @return numero del nivel actual
	 */
	public int getNivelActual() {
		return nivelActual;
	}

	/**
	 * Se setea el nivel actual.
	 * @param nivelActual recibe el nivel actual
	 */
	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}
	
	/**
	 * Se incrementa el nivel actual.
	 */
	public void increaseNivelActual() {
		this.nivelActual++;
	}

	/**
	 * Se obtiene el tiempo del juego.
	 * @return devuelve en numero el tiempo del juego
	 */
	public int getTiempo() {
		return tiempo;
	}
	
	/**
	 * Se setea el tiempo del juego.
	 */
	public void setTiempo() {
		this.tiempo = 150;
	}

	/**
	 * Se decrementa el tiempo del juego.
	 */
	public void decTiempo() {
		this.tiempo--;
	}
	
	public String getElementosPos(int i, int j){
		return (mapa.getEspacio(i, j)).toString();
	}
}