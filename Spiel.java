import ea.*;

/**
 * Diese Klasse repraesentiert ein einfaches Sonnensystem. Es ist eine Loesungsmoeglichkeit fuer die 
 * Praxisuebung aus dem Handbuch.<br />
 * Verwendet werden hierbei Knoten, Kreis sowie Methoden zum Animieren auf einer Kreisbahn. Diese 
 * Methoden wurden im Handbuch bereitgestellt.
 * 
 * @version 2.0
 * @author Michael Andonie
 */
public class Spiel
extends Game
{

    /**Die Sonne*/
    public Kreis sonne;

    /**Die Erde*/
    public Kreis erde;
    
    /** Der Mond*/
    public Kreis mond;
    
    /**Der Knoten fuer das ganze System*/
    public Knoten system;
    
    /**Der knoten fuer die Erdeumlaufbahn*/
    public Knoten bahn;
    
    /**
     * Konstruktor-Methode.<br />
     * Diese erstellt ein neues Sonnensystem. Hierbei werden zuerst alle notwendigen Kreise und Knoten instanziiert und
     * zusammengebracht und anschliessend die Bewegung durch die im Handbuch bereitgestellten Animationsmethoden 
     * ermoeglicht. Diese Methoden sind ganz unten in dieser Datei.
     */
    public Spiel() {
       super(650, 650, "Das Sonnensystem"); //Fenster usw aufbauen.
       
       //Das Sonnensystem erstellen und an der Wurzel anmelden!
       system = new Knoten();
       wurzel.add(system);
       
       //Die Sonne erstellen
       sonne = new Kreis(200, 200, 200);
       sonne.farbeSetzen("Gelb");
       
       //Sonne am Sonnensystem anmelden
       system.add(sonne);
       
       //Die Erdumlaufbahn erstellen und an dem Sonnensystem anmelden!
       bahn = new Knoten();
       system.add(bahn);
       
       //Die Erde erstellen
       erde = new Kreis(500, 300, 50);
       erde.farbeSetzen("Blau");
       //Erde an der Erdumlaufbahn anmelden
       bahn.add(erde);
       
       //Den Mond erstellen
       mond = new Kreis(550, 290, 20);
       mond.farbeSetzen("Grau");
       //Mond an der Erdumlaufbahn anmelden
       bahn.add(mond);
       
       
       
       //Die Sache ins Rollen bringen
       
       //Der Mond dreht sich um die Erde
       dreheUm(erde, mond, 1000);
       
       //Die Erdumlaufbahn dreht sich um die Sonne
       dreheUm(sonne, bahn, 5000);
       
       //Das Sonnensystem bewegt sich gaaaaaaaanz langsam
       dreheUm(new Punkt(370, 370), system, 8000);
    }
    
    
    public void tasteReagieren(int tastenCode) {
        //Wird nicht gebraucht, da dies nicht interaktiv ist
    }
    
    /**
     * Dreht ein Objekt immer wieder um ein bestimmtes anderes.
     * @param   zentrum Das Raum-Objekt, um das sich das andere Objekt drehen soll.
     * @param   drehobjekt  Das Objekt, das sich drehen soll
     * @param   umlaufzeit  Zeit <b>in Millisekunden</b>, die eine Umdrehung dauern soll.
     */
    public void dreheUm(Raum zentrum, Raum drehobjekt, int umlaufzeit) {
        animationsManager.kreisAnimation(drehobjekt, zentrum.zentrum(), umlaufzeit);
    }
    
    /**
     * Dreht ein Objekt immer wieder um einen bestimmten Punkt.
     * @param   zentrum Das zentrum der Drehung
     * @param   drehobjekt  Das Objekt, das sich drehen soll
     * @param   umlaufzeit  Zeit <b>in Millisekunden</b>, die eine Umdrehung dauern soll.
     */
    public void dreheUm(Punkt zentrum, Raum drehobjekt, int umlaufzeit) {
        animationsManager.kreisAnimation(drehobjekt, zentrum, umlaufzeit);
    }
}