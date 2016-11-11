/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <b>Animal est la classe dont hérite chaque animal</b>
 * 
 * Un animal est caractérisé par :
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
abstract class Animal {

    /**
    * Nombre de tour que peut vivre l'Animal
    */
    protected int vie;
    
    /**
    * Nombre de tour que l'Animal peut vivre sans manger
    */
    protected int limiteFaim;
    
    /**
     * Nombre de tours que l'Animal a passé sans manger
     * 
     * @see Animal#setFaim(int) 
     */
    private int faim;
    
    /**
     * Abscisse de l'Animal
     * 
     * @see Animal#Animal(int, int)
     * @see Animal#Animal(String, int, int)
     * @see Animal#getX() 
     * @see Animal#setX(int)  
     */
    private int x;
    
    /**
     * Ordonnée de l'Animal
     * 
     * @see Animal#Animal(int, int)
     * @see Animal#Animal(String, int, int)
     * @see Animal#getY() 
     * @see Animal#setY(int)  
     */
    private int y;
    
    /**
     * Sexe de l'Animal
     * 
     * @see Animal#Animal(String)
     * @see Animal#Animal(String, int, int)
     * @see Animal#getSexe()    
     */
    private String sexe;
    
    
    /**
     * Constructeur d'Animal 
     * 
     * <p>
     * Constructeur qui défini le sexe et la position aléatoirement,
     * et initialise le nombre de tours sans manger à 0.
     * </p>
     */
    protected Animal(){
        faim = 0;   
        if(Math.random()<0.5)
            sexe = "Femelle";
        else 
            sexe = "Male";
        //position à définir
    }
    
    /**
     * Constructeur d'Animal 
     * 
     * <p>
     * Constructeur qui défini le sexe aléatoirement,
     * initialise le nombre de tours sans manger à 0.
     * Et initialise la position de l'Animal
     * </p>
     */
    protected Animal(int x, int y){
        faim = 0;
        this.x = x;
        this.y = y;
        if(Math.random()<0.5)
            sexe = "Femelle";
        else 
            sexe = "Male";
    }
    
    /**
     * Constructeur d'Animal 
     * 
     * <p>
     * Constructeur qui défini la position aléatoirement,
     * initialise le nombre de tours sans manger à 0.
     * Et initialise le sexe de l'Animal
     * </p>
     */
    protected Animal(String sexe){
        faim = 0;
        this.sexe = sexe;
        //position à définir
    }
    
    /**
     * Constructeur d'Animal 
     * 
     * <p>
     * Constructeur qui initialise le sexe,
     * la position.
     * Et initialise le nombre de tours sans manger à 0.
     * </p>
     */
    protected Animal(String sexe, int x, int y){
        faim = 0;
        this.sexe = sexe;
        this.x = x;
    }

    /**
     * Retourne le sexe de l'Animal
     * 
     * @return Le sexe de l'Animal 
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * Retourne le x de l'Animal
     * 
     * @return L'abscisse de l'Animal 
     */
    public int getX() {
        return x;
    }

    /**
     * Retourne le y de l'Animal
     * 
     * @return L'ordonnée de l'Animal 
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne la faim de l'Animal
     * 
     * @return Le nombre de tours de l'Animal sans manger 
     */
    public int getFaim() {
        return faim;
    }
    
    /**
     * Retourne limiteFaim de l'Animal
     * 
     * @return Le nombre de tours que l'Animal peut passer sans manger 
     */
    public int getLimiteFaim() {
        return limiteFaim;
    }

    /**
     * Modifie l'abscisse de l'Animal
     * @param x 
     * Nouvel abscisse
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modifie l'ordonnée de l'Animal
     * @param y 
     * Nouvelle ordonnée
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Modifie le nombre de tours de l'Animal sans manger
     * 
     * @param faim 
     * Nouveau nombre de tours sans manger 
     */
    public void setFaim(int faim) {
        this.faim = faim;
    }
        
    /**
     * Modifie aléatoirement la position de l'Animal
     * 
     * @param casesDispo 
     * Cases autour de l'animal
     */
    public void seDeplace(Case[] casesDispo){
        while(true){
            int d = (int) Math.round(Math.random()*casesDispo.length); //Selectionne une case au hasard
            if(d == casesDispo.length)
                return; //L'animal ne bouge pas
            else if (casesDispo[d].getAnimal() == null){
                x = casesDispo[d].getX();
                y = casesDispo[d].getY();
                return ;
            }
            
        }
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
    public abstract boolean seReproduit(Animal a);
    
    /**
     * Nourrit l'Animal
     * 
     */
    public void seNourrit(){
        setFaim(-1); //-1 car il va vieillir et sa faim augmenter juste après 
    }
    
    /**
     * Vérifie s'il l'Animal meurt
     * 
     * @return Vrai si l'Animal meurt, faux s'il doit encore vivre 
     */
    public boolean meurt(){            
        return (faim == limiteFaim || vie == 0);
    }
    
    /**
     * Fait vieillir d'un tour l'Animal
     * Et augmente sa faim
     */
    public void vieillit(){
        vie--;
        faim++;
    }

    @Override
    public String toString() {
        return "Animal{" + "vie=" + vie + ", limiteFaim=" + limiteFaim + ", faim=" + faim + ", x=" + x + ", y=" + y + ", sexe=" + sexe + '}';
    }    
}
