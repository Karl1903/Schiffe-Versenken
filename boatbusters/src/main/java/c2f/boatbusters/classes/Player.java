package c2f.boatbusters.classes;

import java.util.Scanner;

import c2f.boatbusters.abstractClasses.Board;
import c2f.boatbusters.abstractClasses.Ship;
import c2f.boatbusters.factories.ShipFactory;
import c2f.boatbusters.interfaces.IPlayer;
import javafx.scene.text.Text;

public class Player implements IPlayer {

	private int score = 0;
	private int choice;
	private int countSmall = 2;
	private int countMiddle = 3;
	private int countBig = 2;
	private int shipsCount = countSmall + countMiddle + countBig;
	private boolean shipsLeftToPut = (shipsCount > 0);
	private boolean shipSetMode;

	private boolean secondClick = false;
	private int xfirst;
	private int xlast;
	private int yfirst;
	private int ylast;

	private boolean ready = false;
	private boolean hit = false;
	private boolean missed = false;
	
	// Sachen für Bestenliste/Highschore:

	// Container für Paare. Jeder Spieler wird angelegt mit seinem Namen und der
	// Anzahl an Siegen, die er schon
	// erringen konnte
	private String name;
	private int numberOfWins;

	// Konstruktor: Spieler erhält vor dem Spiel einen Namen, sowie wenn er das
	// erste Mal spielt, numberOfWins = 0
	public Player (String name, int numberOfWins) {
		this.name = name;
		this.numberOfWins = numberOfWins;
	}
	
	public Player (String name, String numberOfWins){
		this.name = name;
		this.numberOfWins = Integer.parseInt(numberOfWins);
	}

	// GETTER AND SETTER

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getName()
	 */
	@Override
	public String getName() {
		return (String) name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#numberOfWins()
	 */
	@Override
	public int getNumberOfWins() {
		return (int) numberOfWins;
	}
	
	
	public int getXfirst() {
		return xfirst;
	}

	public int getXlast() {
		return xlast;
	}

	public int getYfirst() {
		return xfirst;
	}

	public int getYlast() {
		return ylast;
	}

	public void setXfirst(int xfirst) {
		this.xfirst = xfirst;
	}

	public void setXlast(int xlast) {
		this.xlast = xlast;
	}

	public void setYfirst(int yfirst) {
		this.yfirst = yfirst;
	}

	public void setYlast(int ylast) {
		this.ylast = ylast;
	}

	public boolean getSecondClick() {
		return secondClick;
	}

	public void setSecondClick(boolean value) {
		this.secondClick = value;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public void setMissed(boolean missed) {
		this.missed = missed;
	}

	public boolean getHit() {
		return hit;
	}

	public boolean getMissed() {
		return missed;
	}

	public boolean getReady() {
		return ready;
	}

	public boolean getShipSetMode() {
		return shipSetMode;
	}

	public void setShipSetMode(boolean ShipSetMode) {
		this.shipSetMode = ShipSetMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getScore()
	 */
	@Override
	public int getScore() {
		return score;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#increaseScore()
	 */

	@Override
	public void increaseScore() {
		score += 1;
	}

	// -------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getCountSmall()
	 */
	@Override
	public int getCountSmall() {
		return countSmall;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#decreaseCountSmall()
	 */

	public void setCountSmall(int countSmall) {
		this.countSmall = countSmall;
	}

	@Override
	public void decreaseCountSmall() {
		countSmall -= 1;
	}

	// -------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getCountMiddle()
	 */
	@Override
	public int getCountMiddle() {
		return countMiddle;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#decreaseCountMiddle()
	 */

	public void setCountMiddle(int countMiddle) {
		this.countMiddle = countMiddle;
	}

	@Override
	public void decreaseCountMiddle() {
		countMiddle -= 1;
	}

	// -------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getCountBig()
	 */
	@Override
	public int getCountBig() {
		return countBig;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#decreaseCountBig()
	 */

	public void setCountBig(int countBig) {
		this.countBig = countBig;
	}

	@Override
	public void decreaseCountBig() {
		countBig -= 1;
	}

	// -------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getShipsCount()
	 */
	@Override
	public int getShipsCount() {
		return shipsCount;
	}

	// -------------------------------

	// Aktualisiert den boolean jedes Mal aufs Neue
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#areShipsLeftToPut()
	 */

	@Override
	public boolean areShipsLeftToPut(Player player) {
		shipsLeftToPut = (shipsCount > 0);
		return shipsLeftToPut;
	}

	// -------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#getChoice()
	 */
	@Override
	public int getChoice() {
		return choice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#setChoice(int)
	 */
	@Override
	public void setChoice(int choice) {
		this.choice = choice;
	}

	// CHECKER
	// -------------------------------

	// noch ein schiff diesen Typs beim Spieler uebrig?
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#checkIfShipAvailable(int,
	 * c2f.boatbusters.classes.IPlayer)
	 */
	@Override
	public boolean checkIfShipAvailable(int i, IPlayer player) {
		if (i == 2) {
			return (player.getCountSmall() > 0);
		} else if (i == 3) {
			return (player.getCountMiddle() > 0);
		} else if (i == 4) {
			return (player.getCountBig() > 0);
		} else {
			// TODO error log
			return false;
		}
	}

	// Position frei?
	public boolean checkFree(int x, int y, WarShip[][] board) {
		return (board[x][y] == null);
	}

	// wenn man ein schiff setzt, wird die anzahl der verfuegbaren schiffe
	// diesen typs um 1 verringert
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#reduceShipCount(int,
	 * c2f.boatbusters.classes.IPlayer)
	 */
	@Override
	public void reduceShipCount(int i, Player player) {
		switch (i) {
		case 2:
			player.decreaseCountSmall();
			break;
		case 3:
			player.decreaseCountMiddle();
			break;
		case 4:
			player.decreaseCountBig();
			break;

		default:
			// TODO error log ("Error: Zahl nicht zwischen 1 und 4!");
		}
	}

	// checkt, ob die Linie frei ist und ob die Distanz zwischen den beiden
	// Punkte mit der Schifflänge übereinstimmen
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * c2f.boatbusters.classes.IPlayer#checkIfLineIsFreeAndLengthCorrect(int,
	 * int, int, int, int, c2f.boatbusters.classes.WarShip[][])
	 */
	@Override
	public boolean checkIfLineIsFreeAndLengthCorrect(int xfirst, int yfirst, int xlast, int ylast, int length,
			WarShip[][] board) {

		int staticInt, changingStart, changingEnd;
		// Hier wird festgelegt, welche Koordinate gleich bleibt und welche sich
		// aendert,
		// damit anhand der sich aendernden Koordinate die angepeilte Linie auf
		// dem Feld auf ihre Leere gecheckt werden kann.
		boolean isFree = true;

		if (xfirst == xlast) { // Wenn X statisch ist
			staticInt = xfirst;
			if (yfirst > ylast) { // Checkt, welcher Wert groeßer ist, damit die
									// for-Schleife funktioniert
				changingStart = ylast;
				changingEnd = yfirst;
			} else {
				changingStart = yfirst;
				changingEnd = ylast;
			}

			// Das eigentliche Abchecken findet hier statt
			for (int i = changingStart; i <= changingEnd; i++) {
				if (board[staticInt][i] != null) {
					isFree = false;
				}
			}
		} else if (yfirst == ylast) { // Wenn Y statisch ist
			staticInt = yfirst;
			if (xfirst > xlast) { // Checkt, welcher Wert groeßer ist, damit die
									// for-Schleife funktioniert
				changingStart = xlast;
				changingEnd = xfirst;
			} else {
				changingStart = xfirst;
				changingEnd = xlast;
			}

			// Das eigentliche Abchecken findet hier statt
			for (int i = changingStart; i <= changingEnd; i++) {
				if (board[i][staticInt] != null) {
					isFree = false;
				}
			}
		} else {
			// TODO Error Log: Die Eingaben sind falsch: Entweder die X- oder
			// Y-Koordinaten muessen gleich sein!
			isFree = false;
			return isFree;
		}

		// Vergleicht Laenge des zu setzenden Schiffs mit der Laenge des
		// Schifftyps
		if (!(changingEnd - changingStart + 1 == length)) {
			isFree = false;
		}

		return isFree;
	}

	public int checkLength(int xfirst, int yfirst, int xlast, int ylast) {

		int lengthOfShip;

		if (xfirst == xlast && yfirst > ylast) {
			lengthOfShip = yfirst - ylast + 1;
			return lengthOfShip;
		}

		else if (xfirst == xlast && yfirst < ylast) {
			lengthOfShip = ylast - yfirst + 1;
			return lengthOfShip;
		}

		else if (yfirst == ylast && xfirst > xlast) {
			lengthOfShip = xfirst - xlast + 1;
			return lengthOfShip;
		}

		else if (yfirst == ylast && xfirst < xlast) {
			lengthOfShip = xlast - xfirst + 1;
			return lengthOfShip;
		}

		else {
			return 0;
		}

	}

	// SHIP SETTER
	// --------------------------------------------------------------

	// Anfangs- und Endteil des Schiffs setzen
	// Bei falschen Eingaben: Brechstange, fang von vorne an!
	public void setShipPartsGui(int xlast, int ylast, WarShip[][] board, Player player) throws SetShipException {

		int lengthOfShip = checkLength(xfirst, yfirst, xlast, ylast);

		try {
			// Checkt input, Freiheit der Start- und Endposition, Freiheit der
			// Linie und Laenge des Schiffs. Setzt erst dann die Referenzen in
			// das Feld.
			if (checkIfLineIsFreeAndLengthCorrect(xfirst, yfirst, xlast, ylast, lengthOfShip, board)
					&& checkFree(xfirst, yfirst, board) && checkFree(xlast, ylast, board)
					&& checkIfShipAvailable(lengthOfShip, player)) {
				// Schiff wird gesetzt, Anzahl der verfuegbaren Schiffe
				// diesen Typs verringert
				setShipOnBoard(xfirst, yfirst, xlast, ylast, board, lengthOfShip);
				reduceShipCount(lengthOfShip, this);
			}
			// Wenn das Schiff falsch gesetzt wurde, wird die SetShipException
			// geworfen
			else {
				throw new SetShipException();

			}
		} catch (SetShipException e) {
			// Error Nachricht an Benutzer, warum das Schiff nicht gesetzt
			// werdeb konnte
			Main.getLogger()
					.error("Achtung. falsche Koordinaten-Eingabe, "
							+ "Sie können ihr Schiff so nicht setzen!\nFolgendes kann "
							+ "schief gelaufen sein:\n1. Sie haben versucht, ihr Schiff "
							+ "diagonal oder quer zu setzen.\n2. Sie haben versucht, "
							+ "ihr Schiff auf Zellen / Koordinaten zu setzen, auf denen sich bereits "
							+ "Schiffe befinden.\n3. Sie haben ein zu langes oder zu kurzes Schiff "
							+ "gesetzt.\n4. Sie haben kein Schiff der gewählten Länge mehr verfügbar.");
		}
	}

	private void setShipOnBoard(int xfirst, int yfirst, int xlast, int ylast, WarShip[][] board, int length) {
		int staticInt, changingStart, changingEnd;

		ShipFactory fact = new ShipFactory();

		if (xfirst == xlast) { // Wenn X statisch ist
			staticInt = xfirst;
			if (yfirst > ylast) { // Checkt, welcher Wert groeßer ist, damit die
									// for-Schleife funktioniert
				changingStart = ylast;
				changingEnd = yfirst;
			} else {
				changingStart = yfirst;
				changingEnd = ylast;
			}

			// Referenz wird gesetzt
			for (int i = changingStart; i <= changingEnd; i++) {
				WarShip ship = fact.getType(length);
				board[staticInt][i] = ship;
			}
		} else { // Wenn X statisch ist
			staticInt = yfirst;
			if (xfirst > xlast) { // Checkt, welcher Wert groeßer ist, damit die
									// for-Schleife funktioniert
				changingStart = xlast;
				changingEnd = xfirst;
			} else {
				changingStart = xfirst;
				changingEnd = xlast;
			}

			// Referenz wird gesetzt
			for (int i = changingStart; i <= changingEnd; i++) {
				WarShip ship = fact.getType(length);
				board[i][staticInt] = ship;
			}
		}
	}

	// FIRE AND DESTROY METHODS
	// --------------------------------------------------------------

	// Feuer-Modus Methode
	public void fire(int x, int y, Player player, Game game) {

		if (player == game.getPlayer1()) {
			// Wenn auf Zielreferenz ein Schiff ist, das Länge 2, 3, oder 4 hat,
			// hat der Spieler ein Schiff getroffen
			// Wenn auf der Referenz ein Schiff der Länge 0 ist, weiß das
			// Programm, auf dieses Feld wurde bereits gefeuert
			// und um diese Information zu speichern, wurde als Platzhalter eine
			// Schiffsreferenz gesetzt, die explizit sagen soll
			// "Hier war kein Schiff". Für eine weiterführende Erklärung siehe
			// das Kommentar unten zur setEmptyShip-Methode.
			if (!player.checkFree(x, y, game.getBoard2()) && game.getBoard2()[x][y].getEmpty() == false
					&& game.getBoard2()[x][y].getShipDestroyed() == false) {
				setHit(true);
				setMissed(false);
				destroy(game.getBoard2()[x][y]);
				player.increaseScore();
				// Wenn der Spieler auf ein Feld schießt, auf das er bereits
				// geschossen hat und auf dem kein Schiff war,
				// werden die boolean-Variablen missed und hit angepasst, damit
				// die GUI das Ergebnis des aktuellen Schusses
				// richtig ausgibt ("HIT!" bzw. "Missed!")
				
				// Wenn der Spieler auf ein Feld schießt, auf dem er bereits ein
				// Schiff zerstört hat, verfehlt er beim
				// zweiten mal Schießen auf dieses Feld
			} else if (!player.checkFree(x, y, game.getBoard2()) && (game.getBoard2()[x][y].getEmpty() == true
					|| game.getBoard2()[x][y].getShipDestroyed() == true)) {
				setMissed(true);
				setHit(false);
				//Spieler 1 feuert auf leeres Feld
			} else if (player.checkFree(x, y, game.getBoard2())) {
				setMissed(true);
				setHit(false);
				setEmptyShip(x, y, game.getBoard2());
			}
		} else if (player == game.getPlayer2()) {

			if (!player.checkFree(x, y, game.getBoard1()) && game.getBoard1()[x][y].getEmpty() == false
					&& game.getBoard1()[x][y].getShipDestroyed() == false) {
				setHit(true);
				setMissed(false);
				destroy(game.getBoard1()[x][y]);
				player.increaseScore();
				// Wenn der Spieler auf ein Feld schießt, auf das er bereits
				// geschossen hat und auf dem kein Schiff war,
				// werden die boolean-Variablen missed und hit angepasst, damit
				// die GUI das Ergebnis des aktuellen Schusses
				// richtig ausgibt ("HIT!" bzw. "Missed!")
				
				// Wenn der Spieler auf ein Feld schießt, auf dem er bereits ein
				// Schiff zerstört hat, verfehlt er beim
				// zweiten mal Schießen auf dieses Feld
			} else if (!player.checkFree(x, y, game.getBoard1())  && (game.getBoard1()[x][y].getEmpty() == true
					|| game.getBoard1()[x][y].getShipDestroyed() == true)) {
				setMissed(true);
				setHit(false);
				//Spieler 2 feuert auf leeres Feld
			} else if (player.checkFree(x, y, game.getBoard1())) {
				setMissed(true);
				setHit(false);
				setEmptyShip(x, y, game.getBoard1());
			}
		}
	}

	private void destroy(WarShip warship) {
		warship.setShipDestroyed(true);
	}

	// Wenn der Spieler auf ein leeres Feld schießt, wird ein Platzhalter darauf
	// gesetzt, der sozusagen für zwei logische Aussagen steht:
	// "Auf diesem Feld existiert kein Schiff, und es wurde schon darauf
	// gefeuert"
	// Die Methode dient dazu, später zu wissen, auf welche Felder schon
	// gefeuert wurde,
	// auf denen kein Schiff gesetzt war (diese Felder werden blau). So kann man
	// diese
	// Felder unterscheiden von denen, die auch leer sind, und auf die
	// noch nicht gefeuert wurde (Diese Felder sind transparent, also
	// grau-weiß).
	private void setEmptyShip(int x, int y, WarShip[][] board) {
		ShipFactory sf = new ShipFactory();
		WarShip empty = sf.getType(0);
		board[x][y] = empty;
		empty.setEmpty(true);
	}

	public boolean checkIfPlayerWins() {
		if (score == 21) {
			return true;
		}
		return false;
	}

	

	// Ist in Einklang mit der printBestenliste Mehtode, es entsteht eine
	// Tabelle im richtigen Format abhängig von der
	// Länge des Spielernamens
	/*
	 * (non-Javadoc)
	 * 
	 * @see c2f.boatbusters.classes.IPlayer#toString()
	 */

	public String toString2() {
		if (name.length() == 1) {
			return name + "                 |   " + numberOfWins;
		} else if (name.length() == 2) {
			return name + "                |   " + numberOfWins;
		} else if (name.length() == 3) {
			return name + "               |   " + numberOfWins;
		} else if (name.length() == 4) {
			return name + "              |   " + numberOfWins;
		} else if (name.length() == 5) {
			return name + "             |   " + numberOfWins;
		} else if (name.length() == 6) {
			return name + "            |   " + numberOfWins;
		} else if (name.length() == 7) {
			return name + "           |   " + numberOfWins;
		} else if (name.length() == 8) {
			return name + "          |   " + numberOfWins;
		} else if (name.length() == 9) {
			return name + "         |   " + numberOfWins;
		} else if (name.length() == 10) {
			return name + "        |   " + numberOfWins;
		} else if (name.length() == 11) {
			return name + "       |   " + numberOfWins;
		} else if (name.length() == 12) {
			return name + "      |   " + numberOfWins;
		} else if (name.length() == 13) {
			return name + "     |   " + numberOfWins;
		} else if (name.length() == 14) {
			return name + "    |   " + numberOfWins;
		} else if (name.length() == 15) {
			return name + "   |   " + numberOfWins;
		} else if (name.length() == 16) {
			return name + "  |   " + numberOfWins;
		} else if (name.length() == 17) {
			return name + " |   " + numberOfWins;
		} else if (name.length() == 18) {
			return name + "|   " + numberOfWins;
		} else if (name.length() == 0) {
			return name + "                  |   " + numberOfWins;
		} else {
			return name + "      |   " + numberOfWins;
		}
	}

	/**
	 * Formatierung zum Abspeichern in .csv Datei
	 * 
	 * @return Ein Eintrag -> Eine Zeile in Datei
	 */
	String file() {
		return name + ";" + numberOfWins + ";\n";
	}

	@Override
	public int getShipCountCheck() {
		int ShipsLeft = getCountBig() + getCountMiddle() + getCountSmall();

		return ShipsLeft;
	}

	@Override
	public void reduceShipCount(int i, IPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean areShipsLeftToPut() {
		shipsLeftToPut = (shipsCount > 0);
		return shipsLeftToPut;
	}

	// Sachen für Bestenliste/ Highscore: Ende

}
