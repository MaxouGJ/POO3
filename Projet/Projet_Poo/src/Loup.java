/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <b>Loup est la classe qui représente un loup et hérite d'Animal</b>
 * 
 * Un Loup comme un Animal est caractérisé par :
 * <ul>
 * <li>un nombre de tour à vivre</li>
 * <li>un nombre de tours sans manger</li>
 * <li>un abscisse</li>
 * <li>une ordonnée</li>
 * <li>un sexe</li>
 * </ul>
 * 
 *  
 * @author FERRE Adrien et GALLAIS-JIMENEZ Maxime
 */
public class Loup extends Animal{
    
    /**
     * Constructeur de Loup 
     * 
     * <p>
     * Constructeur qui défini le sexe et la position aléatoirement,
     * et initialise le nombre de tours sans manger à 0, la vie à 60 tours et la limite de tours sans manger à 10.
     * </p>
     */
    Loup(){
        super();
        this.vie = 60;
        this.limiteFaim = 10;
    }
    
    /**
     * Constructeur de Loup
     * 
     * <p>
     * Constructeur qui défini le sexe aléatoirement,
     * initialise le nombre de tours sans manger à 0, la vie à 60 tours et la limite de tours sans manger à 10.
     * Et initialise la position de l'Animal
     * </p>
     */
    Loup(int x, int y){
        super(x, y);
        this.vie = 60;
        this.limiteFaim = 10;
    }
    
    /**
     * Constructeur de Loup 
     * 
     * <p>
     * Constructeur qui défini la position aléatoirement,
     * initialise le nombre de tours sans manger à 0, la vie à 60 tours et la limite de tours sans manger à 10.
     * Et initialise le sexe de l'Animal
     * </p>
     */
    Loup(String sexe){
        super(sexe);
        this.vie = 60;
        this.limiteFaim = 10;
    }
    
    /**
     * Constructeur de Loup 
     * 
     * <p>
     * Constructeur qui initialise le sexe,
     * la position.
     * Et initialise le nombre de tours sans manger à 0, la vie à 60 tours et la limite de tours sans manger à 10.
     * </p>
     */
    Loup(String sexe, int x, int y){
        super(sexe, x, y);
        this.vie = 60;
        this.limiteFaim = 10;
    }

    /**
     * Vérifie si les deux animaux peuvent se reproduire
     * 
     * @param a
     * L'Animal avec lequel on veut que notre Aminal se reproduise
     * 
     * @return Vrai si l'Animal a pu se reproduire, faux sinon
     *
     */
    @Override
    public boolean seReproduit(Animal a) {
        return (a instanceof Loup && !a.getSexe().equals(getSexe()));
    }

    
}
