
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <b>Classe principale, elle représente tout le jeu</b>
 * 
 * L'univers est représenté par : 
 * <ul>
 * <li>un modèle</li>
 * <li>une vue</li>
 * <li>un controleur</li>
 * </ul>
 * 
 * @author FERRE Adrien et GALLAIS-JIMENEZ Maxime
 */
public class Univers {

    /**
     * Vue de l'Univers, partie graphique
     */
    Vue vue;
    
    /**
     * Modèle de l'Univers, partie objet
     */
    Model model;
    
    /**
     * Controleur de l'Univers, gère les intéractions en vue et modèle
     */
    Controleur controleur;
    
    /**
     * Constructeur d'Univers
     * 
     * @see Vue#Vue() 
     * @see Controleur#Controleur() 
     * @see Model#Model() 
     * @see JFrame#pack() 
     * @see JFrame#setVisible(boolean) 
     */
    public Univers(){
            
        controleur = new Controleur(); //On initialise un nouveau controleur
        vue = new Vue();    //On initialise une nouvelle vue
        model = new Model();    //On initialise un nouveau modèle
        vue.pack(); //On fait en sorte que le JFrame fasse la taille du JPanel
        vue.setVisible(true);   //On rend visible la vue
    
    }
    
    /**
     * Classe qui gère tous les éléments graphiques
     * 
     * Une Vue est représentée par :
     * <ul>
     * <li>une console</li>
     * <li>un plateau</li>
     * <li>un champ pour récupérer la largeur du plateau</li>
     * <li>un champ pour récupérer la longueur du plateau</li>
     * </ul>
     */
    class Vue extends JFrame {
        
        /**
         * Panneau contenant les instrucions
         */
        JPanel console;
        
        /**
         * Représentation de la prairie
         */
        JPanel plateau;
        
        /**
         * Barre de menu
         */
        JMenuBar barreMenu;
        
        /**
         * Menu qui permet de faire une nouvelle partie 
         */
        JButton nouvellePartie;
        
        /**
         * Largeur de la future prairie, entrée par l'utilisateur
         */
        JFormattedTextField nlargeur;
        
        /**
         * Longueur de la future prairie, entrée par l'utilisateur
         */
        JFormattedTextField nlongueur;
        
        /**
         * Nombre de moutons de la future prairie, entrée par l'utilisateur
         */
        JFormattedTextField nmouton;
        
        /**
         * Nombre de loups de la future prairie, entrée par l'utilisateur
         */
        JFormattedTextField nloup;
        
        /**
         * Informations de base du jeu qui ne changent pas lors du jeu (longueur, largeur, nombre d'animaux au départ)
         */
        JTextArea infos;
        
        /**
         * Bouton de lancement du jeu
         */
        JButton start;
        
        /**
         * Informations du tour
         */
        JTextArea infosTour;
        
        /**
         * Bouton pour lancer le tour suivant
         */
        JButton continuer;
        
        /**
         * Bouton d'avance rapide
         */
        JButton accelere;
        
        /**
         * Constructeur de Vue 
         * 
         * @see JFrame#setTitle(java.lang.String) 
         * @see JFrame#setPreferredSize(java.awt.Dimension) 
         * @see JFrame#setResizable(boolean)
         * @see JFrame#setLocationRelativeTo(java.awt.Component) 
         * @see JFrame#setDefaultCloseOperation(int) 
         * 
         * @see JMenuBar#JMenuBar() 
         * @see JMenu#JMenu(java.lang.String) 
         * @see JMenu#addActionListener(java.awt.event.ActionListener) 
         * @see JMenuBar#add(java.awt.Component) 
         * @see JFrame#setMenuBar(java.awt.MenuBar) 
         * 
         * @see JPanel#setLayout(java.awt.LayoutManager) 
         * 
         */
        Vue(){
        
            setTitle("Prairie"); //Définit un titre pour notre fenêtre
            setPreferredSize(new Dimension(800, 600)); //Définit sa taille (largeur et hauteur)
            setResizable(true); //Permet de modifier la taille de fenêtre
            setLocationRelativeTo(null); //Nous demandons maintenant à notre objet de se positionner au centre
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
            
            barreMenu = new JMenuBar();
            nouvellePartie = new JButton("Nouvelle Partie");
            nouvellePartie.addActionListener(controleur);
            nouvellePartie.setEnabled(false);   //Car ça ne fonctionne pas
            accelere = new JButton("Avance rapide");
            accelere.addActionListener(controleur);
            accelere.setEnabled(false); //On ne peut pas accelerer le jeu avant que tout soit en place
            barreMenu.add(nouvellePartie);
            barreMenu.add(accelere);
            setJMenuBar(barreMenu);
            
            getContentPane().setLayout(new GridBagLayout());    //On veut diviser notre JFrame en deux parties
            
            GridBagConstraints cConsole = new GridBagConstraints(); //On crée les contraintes de la console
            cConsole.fill = GridBagConstraints.BOTH;    //Elle prendra toute la place disponible
            cConsole.gridx = 0; //Elle se situera à gauche
            cConsole.gridy = 0; // Et en haut
            cConsole.gridwidth = 1; //Et sa taille sera unitaire
            cConsole.gridheight = 1;
            
            GridBagConstraints cPlateau = new GridBagConstraints(); //On crée les contraintes du plateau
            cPlateau.fill = GridBagConstraints.BOTH;    //Il prendra toue la place disponible
            cPlateau.gridx = 1; //Il sera à droite de la console
            cPlateau.gridy = 0; //Il se situera aussi en haut
            cPlateau.gridwidth = GridBagConstraints.REMAINDER;  //Il occupera toout ce qui se situe après la console
            cPlateau.gridheight = GridBagConstraints.REMAINDER;
            cPlateau.weightx = 3.0; //Sa largeur sera de trois fois celle de la console
            cPlateau.weighty = 1.0; //Sa hauteur sera la même
            
            console = new JPanel();     //On initialise le panneau console
            console.setPreferredSize(new Dimension(200,600));
            console.setMinimumSize(new Dimension(200,600));
            console.setBounds(0, 0, 200, 600);  //Le panneau console sera à gauche et de taille 200x600 
            console.setBackground(Color.black);     //Console aura un fond noir
            plateau = new JPanel(); //On initialise le panneau plateau
            plateau.setPreferredSize(new Dimension(600, 600));
            plateau.setBounds(200, 0, 600, 600);    //il sera à droite de console et de taille 600x600
            plateau.setBackground(Color.darkGray);
            getContentPane().add(console, cConsole);  //On colle les panneaux 
            getContentPane().add(plateau, cPlateau);
            
    
        }
        
        /**
         * Permet d'afficher les requêtes dont on a besoin pour avoir le plateau
         */
        void vueInitialisation(){
            
            JTextArea largeur = new JTextArea("Quelle largeur fait votre prairie ?");   //On crée une case texte pour demander la largeur
            largeur.setBackground(Color.black); //On change le fond de l'area en noir 
            largeur.setForeground(Color.green); //On change la couleur du texte en vert
            largeur.setEditable(false); //On empêche que le texte de l'area soit modifiable
            JTextArea longueur = new JTextArea("Quelle longueur fait votre prairie ?"); 
            longueur.setBackground(Color.black);
            longueur.setForeground(Color.green);
            longueur.setEditable(false);
            
            nlargeur = new JFormattedTextField(NumberFormat.getIntegerInstance()); //On crée un textField qui ne prend que des entiers
            nlargeur.setColumns(3);    //On le fait de taille raisonnable
            nlargeur.addActionListener(controleur); //On ajoute un listener que l'on implémente dans le controleur
            nlongueur = new JFormattedTextField(NumberFormat.getIntegerInstance());
            nlongueur.setColumns(3);
            nlongueur.addActionListener(controleur);
            
            //On colle le tout au panneau console
            console.add(largeur);
            console.add(nlargeur);
            console.add(longueur);
            console.add(nlongueur);
        }
        
        /**
         * Colle tous les JPanels au JPanel plateau , pour représenter les cases
         */
        void creeLaPrairie(){
            infos = new JTextArea("Largeur de la prairie : "+model.largeur+"\n\nLongueur de la prairie : "+model.longueur);   //On crée une case texte pour demander la largeur
            infos.setBackground(Color.black); //On change le fond de l'area en noir 
            infos.setForeground(Color.green); //On change la couleur du texte en vert
            infos.setEditable(false); //On empêche que le texte de l'area soit modifiable
            console.removeAll();    //On supprime ce qui était présent sur la console
            validate(); //On confirme l'effacement avnt de recoller quoi que ce soit
            console.add(infos);    //On ajoute ce que l'on vient d'écrire
            
            plateau.setLayout(new GridLayout(model.longueur, model.largeur));
            for(int j=0; j<model.longueur; j++){
                for(int i=0; i<model.largeur; i++){
                    model.cases[i][j].panel.setBorder(BorderFactory.createLineBorder(Color.black)); //On met une bordure au JPanel
                    plateau.add(model.cases[i][j].panel);
                    validate();
                }
            }
        }
        
        /**
         * Permet d'afficher les requêtes dont on a besoin pour avoir les moutons
         */
        void vueInitialisationMoutons(){
            if(nmouton == null){    //On verifie s'il y a déjà eu une demande si non on crée le text            
                JTextArea mouton = new JTextArea("Combien de moutons voulez-vous ?\n(max : "+(model.largeur*model.longueur)+")");   //On crée une case texte pour demander la largeur
                mouton.setBackground(Color.black); //On change le fond de l'area en noir 
                mouton.setForeground(Color.green); //On change la couleur du texte en vert
                mouton.setEditable(false); //On empêche que le texte de l'area soit modifiable
                console.add(mouton);
            }
            else{   //Sinon on enlève l'ancien résultat
                console.remove(nmouton);
                validate();
            }
            
            nmouton = new JFormattedTextField(NumberFormat.getIntegerInstance()); //On crée un textField qui ne prend que des entiers
            nmouton.setColumns(3);    //On le fait de taille raisonnable
            nmouton.addActionListener(controleur); //On ajoute un listener que l'on implémente dans le controleur
            
            //On colle le tout au panneau console
            console.add(nmouton);
            validate();
        }
        
        /**
         * Permet d'afficher les requêtes dont on a besoin pour avoir les loups
         */
        void vueInitialisationLoups(){
            console.removeAll();
            infos.setText(infos.getText()+"\n\nNombre de moutons de départ : "+model.moutons);
            console.add(infos);
            validate();
            
            if(nloup == null){    //On verifie s'il y a déjà eu une demande si non on crée le text            
                JTextArea loup = new JTextArea("Combien de loups voulez-vous ?\n(max : "+(model.largeur*model.longueur-model.moutons)+")");   //On crée une case texte pour demander la largeur
                loup.setBackground(Color.black); //On change le fond de l'area en noir 
                loup.setForeground(Color.green); //On change la couleur du texte en vert
                loup.setEditable(false); //On empêche que le texte de l'area soit modifiable
                console.add(loup);
            }
            else{   //Sinon on enlève l'ancien résultat
                console.remove(nloup);
                validate();
            }
            
            nloup = new JFormattedTextField(NumberFormat.getIntegerInstance()); //On crée un textField qui ne prend que des entiers
            nloup.setColumns(3);    //On le fait de taille raisonnable
            nloup.addActionListener(controleur); //On ajoute un listener que l'on implémente dans le controleur
                        
            //On colle le tout au panneau console
            console.add(nloup);
            validate();
        }
        
        /**
         * Fini de mettre à jour infos
         */
        void finiInfos(){
             
            console.removeAll();
            infos.setText(infos.getText()+"\n\nNombre de loups de départ : "+model.loups);
            console.add(infos);
            validate();            
        }
        
        /**
         * Ajoute les animaux au plateau
         * 
         * @param a 
         * Animal à ajouter à la vue
         */
        void ajouteAnimal(Animal a){
            if(a instanceof Mouton){
                model.cases[a.getX()][a.getY()].panel.setBackground(Color.white);
            }
            if(a instanceof Loup){
                model.cases[a.getX()][a.getY()].panel.setBackground(Color.black);
            }
            validate();
        }
        
        /**
         * Permet de créer le bouton qui va lancera le jeu  
         */
        void vueBoutonDemarrer(){
            start = new JButton("Démarrer");
            start.addActionListener(controleur);
            console.add(start);
            validate();
        }
        
        /**
         * Actualise l'interface graphique à chaque tour
         */
        void miseAJour(Case c){
//            c.image.image = null;//On remet à nul l'image
            if(c.getAnimal() instanceof Mouton){
                c.panel.setBackground(Color.white);
//                try {
//                    c.image.image = ImageIO.read(new File("img/sheep.png"));
//                } 
//                catch (IOException ex) {
//                }
//                c.image.setPreferredSize(new Dimension(c.panel.getWidth(), c.panel.getHeight()));
//                c.image.setBackground(Color.white);
//                c.image.resize(c.image.image, c.panel.getWidth(), c.panel.getHeight());
//                c.image.repaint();
            }
            else if(c.getAnimal() instanceof Loup){
                c.panel.setBackground(new Color(25, 25, 25));
//                try {
//                    c.image.image = ImageIO.read(new File("img/wolf.png"));
//                } 
//                catch (IOException ex) {
//                }
//                c.image.setPreferredSize(new Dimension(c.panel.getWidth(), c.panel.getHeight()));
//                c.image.setBackground(new Color(25, 25, 25));
//                c.image.resize(c.image.image, c.panel.getWidth(), c.panel.getHeight());
//                c.image.repaint();
            }
            else if(c.getHerbe()){
                c.panel.setBackground(new Color(58, 157, 35));
//                try {
//                    c.image.image = ImageIO.read(new File("img/grass.png"));
//                } 
//                catch (IOException ex) {
//                }
//                c.image.setPreferredSize(new Dimension(c.panel.getWidth(), c.panel.getHeight()));
//                c.image.setBackground(new Color(58, 157, 35));
//                c.image.resize(c.image.image, c.panel.getWidth(), c.panel.getHeight());
//                c.image.repaint();
            }
            else if(c.getSels()){
                c.panel.setBackground(Color.gray);
            }
            else{
                c.panel.setBackground(new Color(135, 89, 26));
            }
            validate();
        }
        
        void miseAJourInfos(int tours, int moutons, int loups){
            accelere.setEnabled(true);  //Désormais on peut faire accelerer le programme
            
            if(start != null){
                console.remove(start);
                validate();
            }
            if(infosTour != null){
                console.remove(infosTour);
                validate();
            }
            if(continuer != null){
                console.remove(continuer);
                validate();
            }
            infosTour = new JTextArea("\n-----   Tour : "+tours+"   -----\nMoutons : "+moutons+"\nLoups : "+loups);
            infosTour.setPreferredSize(new Dimension(200,100));
            infosTour.setBackground(Color.black);
            infosTour.setForeground(Color.green);
            infosTour.setEditable(false);
            console.add(infosTour);
            validate();
            
            continuer = new JButton("Continuer");
            continuer.addActionListener(controleur);
            console.add(continuer);
            validate();
        } 
        
        void fin(){
            console.remove(continuer);
            validate();
            JTextArea message =new JTextArea("La partie est terminée.\nVous avez tenu : "+(model.tours-1)+" tours");
            message.setPreferredSize(new Dimension(200,100));
            message.setBackground(Color.black);
            message.setForeground(Color.green);
            message.setEditable(false);
            
            console.add(message);
                    
            validate();
        }
    }
        
        
        
    /**
     * <b>Classe qui définit tous les objets</b>
     * 
     * Un modèle est représenté par : 
     * <ul>
     * <li>la largeur du plateau</li>
     * <li>la longueur du plateau</li>
     * <li>les cases du plateau</li>
     * <li>la liste des animaux présents</li>
     * <li>le nombre de loups</li>
     * <li>le nombre de moutons</li>
     * </ul>
     * 
     */
    class Model {
        
        /**
         * Largeur de la prairie
         */
        int largeur;
        
        /**
         * Longueur de la prairie
         */
        int longueur;
        
        /**
         * Tableau des cases de la prairie
         */
        Case[][] cases;
        
        /**
         * Liste de tous les animaux de la prairie
         */
        ArrayList<Animal> animaux;
       
        /**
         * Liste des animaux qui ont exéuté une action avant leur tour
         */
        ArrayList<Animal> tourFini; 
        
        /**
         * Liste des animaux morts pendant le tour
         */
        ArrayList<Animal> morts;
        
        /**
         * Liste des cases qui ont des sels minéraux ce tour
         */
        ArrayList<Case> sm;
        
        /**
         * Liste des animaux tués par des loups
         */
        ArrayList<Animal> mortsLoups;
        
        /**
         * Nombre de loups
         */
        int loups;
        
        /**
         * Nombre de moutons
         */
        int moutons;
    
        /**
         * Nombre de tours
         */
        int tours;
        
        /**
         * Constructeur de Model
         * 
         * @see Vue#vueInitialisation() 
         */
        Model(){
            largeur = longueur = 0; ////Nous n'avons pas les valeurs donc nous les initialisons à 0
            loups = moutons = -1; //Nous n'avons pas les valeurs donc nous les initialisons à -1 (si on veur tester avec 0 loup ou 0 moutons)
            cases = null;   //N'ayant pas les valeurs au dessus on initialise à null
            animaux = null; //N'ayant pa de valeurs on l'initialise à null
            vue.vueInitialisation();  //On pose les questions de dimensions à l'utilisateur
            tourFini = new ArrayList<Animal>();
            morts = new ArrayList<Animal>();
            sm = new ArrayList<Case>();
            mortsLoups = new ArrayList<Animal>();
            tours = 0; 
        }
        
        /**
         * Modifie la largeur du plateau et crée le tableau de cases si la longueur est déjà initialisée
         * @param l
         * Nouvelle largeur
         * @return 
         * Vrai si le tableau de cases est initialisé, faux sinon
         */
        boolean setLargeur(int l){
            largeur  = l;
            if(longueur > 0){
                cases = new Case[largeur][longueur]; //On initialise la prairie
                for(int i=0; i<largeur; i++){
                    for(int j=0; j<longueur; j++)
                        cases[i][j] = new Case(i, j);
                }
                return true;    //Retourne vrai si les cases sont initialisées
            }
            return false;
        }
        
        /**
         * Modifie la longueur du plateau et crée le tableau de cases si la largeur est déjà initialisée
         * @param l
         * Nouvelle longueur
         * @return 
         * Vrai si le tableau de cases est initialisé, faux sinon
         */
        boolean setLongueur(int l){
            longueur  = l;
            if(largeur > 0){
                cases = new Case[largeur][longueur]; //On initialise la prairie
                for(int i=0; i<largeur; i++){
                    for(int j=0; j<longueur; j++)
                        cases[i][j] = new Case(i, j);
                }
                return true;    //Retourne vrai si les cases sont initialisées
            }
            return false;
        }
        
        /**
         * Revoie la case à la position (x, y)
         * @param x
         * Abscisse de la case à renvoyer
         * @param y
         * Ordonnée de la case à renvoyer
         * @return 
         * La case à la position(x, y)
         */
        Case getCase(int x, int y){
            return cases[x][y];
        }
        
        /**
         * Crée le tableau de cases
         * 
         * @see Case#Case(int, int) 
         */
        void creeCases(){
            cases = new Case[largeur][longueur];
            for(int i=0; i<largeur; i++){
                for(int j=0; j<longueur; j++){
                    cases[i][j] = new Case(i, j);
                }
            }
        }
        
        /**
         * Crée la liste des Animaux et les place dans les cases
         * 
         * @see ArrayList#ArrayList()   
         * @see ArrayList#add(java.lang.Object)  
         * @see Case#setAnimal(Animal) 
         * @see Case#getAnimal() 
         * @see Vue#ajouteAnimal(Animal) 
         */
        void creeAnimaux(){
            animaux = new ArrayList<Animal>();
            vue.finiInfos();
            for(int i=0; i<moutons; i++){
                boolean b = false;
                while(!b){
                    int x = (int) (Math.random()*cases.length);
                    int y = (int) (Math.random()*cases[0].length);
                    if(cases[x][y].getAnimal() == null){
                        cases[x][y].setAnimal(new Mouton(x, y));
                        animaux.add(cases[x][y].getAnimal());
                        //vue.ajouteAnimal(cases[x][y].getAnimal());
                        b = true;
                    }
                }
            }
            for(int i=0; i<loups; i++){
                boolean b = false;
                while(!b){
                    int x = (int) (Math.random()*cases.length);
                    int y = (int) (Math.random()*cases[0].length);
                    if(cases[x][y].getAnimal() == null){
                        cases[x][y].setAnimal(new Loup(x, y));
                        animaux.add(cases[x][y].getAnimal());
                        //vue.ajouteAnimal(cases[x][y].getAnimal());
                        b = true;
                    }
                }
            }
            for(int j=0; j<model.cases[0].length; j++){
                for(int i=0; i<model.cases.length; i++){
                    vue.miseAJour(model.cases[i][j]); //Met à jour l'interface graphique       
                }
            }
        }
        /**
         * Nourrit l'animal et modifie tout ce qu'il se passe lors de cette étape
         * @param a
         * Animal à nourrir
         * @return 
         * Vrai si l'Animal a mabgé faux sinon
         */
        boolean nourrit(Animal a){
            if(a instanceof Mouton){
                if(cases[a.getX()][a.getY()].getHerbe()){
                    a.seNourrit();
                    cases[a.getX()][a.getY()].setHerbe(false);
                    return true;
                }
                else{
                    return false;
                }
            }
            if(a instanceof Loup){
                Case[] ac = controleur.aCote(a);
                    for(int j=0; j<ac.length; j++){
                        if (ac[j].getAnimal() instanceof Mouton && model.morts.indexOf(ac[j].getAnimal()) == -1){
                            a.seNourrit();
                            model.morts.add(ac[j].getAnimal());
                            model.mortsLoups.add(ac[j].getAnimal());
                            model.tourFini.add(ac[j].getAnimal());
                            return true;
                        }
                    }
                    return false;
            }
            return false;
        }
        
        /**
         * Fait se reproduire deux animaux
         * @param a
         * Animal qui compte se reproduire
         * @param ac
         * Cases autour de l'Animal
         * @return 
         * Vrai si l'animl s'est reproduit faux sinon
         */
        boolean reproduit(Animal a, Case[] ac){
            boolean com = false, vid = false;
            Case vide = null, companion = null;
            Animal bebe = null;
            for(int j=0; j<ac.length; j++){
                if(a.seReproduit(ac[j].getAnimal()) && tourFini.indexOf(ac[j].getAnimal()) == -1){ //On vérifie si l'animal est compatible et qu'il eut jouer
                    companion = ac[j];
                    com = true;
                }
                else if(ac[j].getAnimal() == null){
                    vide = ac[j];
                    vid = true;
                }
                if(com && vid){
                    if(a instanceof Mouton){
                        bebe = new Mouton(vide.getX(), vide.getY());
                        model.animaux.add(model.moutons, bebe); //On ajoute le nouveau mouton derrière le dernier mouton
                        model.cases[vide.getX()][vide.getY()].setAnimal(bebe); //Puis on l'ajoute dans le tableau de cases
                        moutons++;
                    }
                    else if(a instanceof Loup){
                        bebe = new Loup(vide.getX(), vide.getY());
                        model.animaux.add(bebe);
                        model.cases[vide.getX()][vide.getY()].setAnimal(bebe);
                        loups++;
                    }
                    tourFini.add(bebe);
                    tourFini.add(companion.getAnimal());
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * Classe qui gère les intéractions entre le modèle et la vue
     */
    class Controleur implements ActionListener{

        /**
         * Gère les actions des listeners d'initialisation
         * 
         * @see ActionEvent#getSource() 
         * @see Model#setLargeur(int) 
         * @see Model#creeCases() 
         * @see Vue#creeLaPrairie() 
         * @see Vue#vueInitialisationAnimaux() 
         * @see Vue#ajouteLesAnimaux() 
         * 
         * @param e 
         * Evénement écouté
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == vue.nlargeur){
                if(model.setLargeur(Integer.parseInt(vue.nlargeur.getText()))){ //Forcement un nombre récupéré car JFormattedTextField
                    model.creeCases();
                    vue.creeLaPrairie();
                    vue.vueInitialisationMoutons();
                }
            }
            else if(e.getSource() == vue.nlongueur){
                if(model.setLongueur(Integer.parseInt(vue.nlongueur.getText()))){ //Forcement un nombre récupéré car JFormattedTextField
                    model.creeCases();
                    vue.creeLaPrairie();
                    vue.vueInitialisationMoutons();
                }
            }
            else if(e.getSource() == vue.nmouton){
                if(Integer.parseInt(vue.nmouton.getText()) <= (model.largeur*model.longueur)){
                    model.moutons = Integer.parseInt(vue.nmouton.getText());
                    vue.vueInitialisationLoups();
                }
                else{
                    vue.vueInitialisationMoutons();
                }
              
            }
            else if(e.getSource() == vue.nloup){
                if(Integer.parseInt(vue.nloup.getText()) <= (model.largeur*model.longueur)-model.moutons){
                    model.loups = Integer.parseInt(vue.nloup.getText());
                    model.creeAnimaux();
                    vue.vueBoutonDemarrer();
                }
                else {
                    vue.vueInitialisationLoups();
                }
            }
            else if(e.getSource() == vue.start){
                vue.miseAJourInfos(model.tours, model.moutons, model.loups);
            }
            else if(e.getSource() == vue.continuer){
                model.tours++;
                if(tour())
                    vue.miseAJourInfos(model.tours, model.moutons, model.loups);
                else 
                    vue.fin();
            }
            else if(e.getSource() == vue.nouvellePartie){
                vue = null;
                vue = new Vue();
                vue.validate();
                model = new Model();
            }
            else if(e.getSource() == vue.accelere){
                while(tour()){
                    model.tours++;
                }
                vue.fin();
            }
        }
        
        /**
         * Vérifie s'il y a une case vide à côté de l'Animal
         * @param a
         * Animal où l'on regarde s'il y a de la pace à côté de lui
         * @return 
         * La liste des animaux présents dans les cases voisines de a
         */
        Case[] aCote(Animal a){
            if(a.getX() < 1){
                if(a.getY() < 1){
                    Case[] tab = new Case[3];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()+1];
                    tab[2] = model.cases[a.getX()+1][a.getY()+1];
                    return tab;
                }
                else if(a.getY() == model.cases[0].length-1){
                    Case[] tab = new Case[3];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()-1];
                    tab[2] = model.cases[a.getX()+1][a.getY()-1];
                    return tab;
                }
                else{
                    Case[] tab = new Case[5];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()+1];
                    tab[2] = model.cases[a.getX()][a.getY()-1];
                    tab[3] = model.cases[a.getX()+1][a.getY()+1];
                    tab[4] = model.cases[a.getX()+1][a.getY()-1];
                    return tab;
                }
            }
            else if(a.getX() == model.cases.length-1){
                if(a.getY() < 1){
                    Case[] tab = new Case[3];
                    tab[0] = model.cases[a.getX()-1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()+1];
                    tab[2] = model.cases[a.getX()-1][a.getY()+1];
                    return tab;
                }
                else if(a.getY() == model.cases[0].length-1){
                    Case[] tab = new Case[3];
                    tab[0] = model.cases[a.getX()-1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()-1];
                    tab[2] = model.cases[a.getX()-1][a.getY()-1];
                    return tab;
                }
                else{
                    Case[] tab = new Case[5];
                    tab[0] = model.cases[a.getX()-1][a.getY()];
                    tab[1] = model.cases[a.getX()][a.getY()+1];
                    tab[2] = model.cases[a.getX()][a.getY()-1];
                    tab[3] = model.cases[a.getX()-1][a.getY()+1];
                    tab[4] = model.cases[a.getX()-1][a.getY()-1];
                    return tab;
                }
            }
            else if(a.getX() > 0 && a.getX() < model.cases.length-1){
                if(a.getY() < 1){
                    Case[] tab = new Case[5];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()-1][a.getY()];
                    tab[2] = model.cases[a.getX()][a.getY()+1];
                    tab[3] = model.cases[a.getX()+1][a.getY()+1];
                    tab[4] = model.cases[a.getX()-1][a.getY()+1];
                    return tab;
                }
                else if(a.getY() == model.cases[0].length-1){
                    Case[] tab = new Case[5];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()-1][a.getY()];
                    tab[2] = model.cases[a.getX()][a.getY()-1];
                    tab[3] = model.cases[a.getX()+1][a.getY()-1];
                    tab[4] = model.cases[a.getX()-1][a.getY()-1];
                    return tab;
                }
                else{
                    Case[] tab = new Case[8];
                    tab[0] = model.cases[a.getX()+1][a.getY()];
                    tab[1] = model.cases[a.getX()-1][a.getY()];
                    tab[2] = model.cases[a.getX()][a.getY()+1];
                    tab[3] = model.cases[a.getX()][a.getY()-1];
                    tab[4] = model.cases[a.getX()+1][a.getY()+1];
                    tab[5] = model.cases[a.getX()+1][a.getY()-1];
                    tab[6] = model.cases[a.getX()-1][a.getY()+1];
                    tab[7] = model.cases[a.getX()-1][a.getY()-1];
                    return tab;
                }
            }
            return null; //impossible d'arriver ici
        }
        
        /**
         * Réalise un tour
         * 
         * @see ArrayList#isEmpty() 
         * @see Case#seReproduit(Animal) 
         * @see Animal#seNourrit()  
         * @see Animal#seDeplace() 
         * @see Animal#vieillit() 
         * @see Vue#miseAJour() 
         * 
         * @return 
         * True s'il y aura un prochain tour, false s'il n'y a plus d'Animaux
         */
        boolean tour(){
            if(model.animaux.isEmpty()) //S'il n'y a plus d'animaux
                return false;
            else{
                for(int i=0; i<model.animaux.size(); i++){  //On passe tous les animaux en revu
                    if(model.animaux.get(i).meurt()){   //Si l'animal meurt
                        model.morts.add(model.animaux.get(i));  //On l'ajoute à la liste de morts
                    }
                    else if(model.tourFini.indexOf(model.animaux.get(i)) != -1){
                        //S'il a déjà fait quelque chose lors de ce tour alors il ne fait rien 
                    }
                    else if(model.animaux.get(i).getLimiteFaim() - model.animaux.get(i).getFaim()<3){   //S'il l'animal commence à avoir faim
                        if(model.nourrit(model.animaux.get(i))){    //Il essaye de se nourrir
                            }
                        else{   //Sinon il se déplace
                            model.cases[model.animaux.get(i).getX()][model.animaux.get(i).getY()].setAnimal(null); //On enlève l'animal de son ancienne case
                            model.animaux.get(i).seDeplace(aCote(model.animaux.get(i)));    //L'animal se déplace
                            model.cases[model.animaux.get(i).getX()][model.animaux.get(i).getY()].setAnimal(model.animaux.get(i)); //On met l'animal sur sa nouvelle case
                            }
                    }
                    else{
                        Case[] ac = aCote(model.animaux.get(i));
                        if(model.reproduit(model.animaux.get(i), ac)){  //Si l'animal peut se reproduire il le fait
                        }
                        else if(model.nourrit(model.animaux.get(i))){   //Sinon il se nourrit
                        }
                        else{   //Sinon il se déplace
                            model.cases[model.animaux.get(i).getX()][model.animaux.get(i).getY()].setAnimal(null); //On enlève l'animal de son ancienne case
                            model.animaux.get(i).seDeplace(aCote(model.animaux.get(i)));    //L'animal se déplace
                            model.cases[model.animaux.get(i).getX()][model.animaux.get(i).getY()].setAnimal(model.animaux.get(i)); //On met l'animal sur sa nouvelle case
                        }
                    }
                    model.tourFini.add(model.animaux.get(i)); //On ajoute l'animal à la liste des moutons ayant fini leur tour
                    model.animaux.get(i).vieillit(); //L'animal viellit et pas conséquent perd un tour de vie et sa fim augmente de 1
                }
                
                model.tourFini.removeAll(model.tourFini); //On remet tout à zéro pour pouvoir recommencer un nouveau tour
                
                for(int i=0; i<model.sm.size(); i++){//On fait pousser l'herbe
                    model.cases[model.sm.get(i).getX()][model.sm.get(i).getY()].setSels(false);//On enlève les sels minéraux
                    model.cases[model.sm.get(i).getX()][model.sm.get(i).getY()].setHerbe(true);//On met de l'herbe
                }
                model.sm.removeAll(model.sm);//On remet à zéro la liste des cases qui ont besoin de sels minéreaux
                
                for(int i=model.morts.size()-1; i>=0; i--){    //On supprime les animaux morts
                    if(model.morts.get(i) instanceof Mouton)
                        model.moutons--;    //On actualise le nombre de moutons                    }
                    else if(model.morts.get(i) instanceof Loup){
                        model.loups--;  //On actualise le nombre de loups
                    }   
                    if(!model.cases[model.morts.get(i).getX()][model.morts.get(i).getY()].getHerbe() && model.mortsLoups.indexOf(model.morts.get(i)) == -1){
                          model.cases[model.morts.get(i).getX()][model.morts.get(i).getY()].setSels(true);//On met des sels minéraux s'il n'y a pas d'herbe et que l'animal n'est pas un mouton mangé
                          model.sm.add(model.cases[model.morts.get(i).getX()][model.morts.get(i).getY()]);//On ajoute la case dans la liste des cases aec des sels minéraux
                    }
                    model.cases[model.morts.get(i).getX()][model.morts.get(i).getY()].setAnimal(null); //On supprime l'animal du plateau
                    model.animaux.remove(model.morts.get(i)); //On supprime l'animal de la liste des animaux
                }
                model.morts.removeAll(model.morts); //On vide tous ceux qui sont morts avant de commencer un nouveau tour
                model.mortsLoups.removeAll(model.mortsLoups); //On vide tous ceux qui sont morts à cause des loups avant de commencer un nouveau tour
                
                for(int j=0; j<model.cases[0].length; j++){
                    for(int i=0; i<model.cases.length; i++){
                        vue.miseAJour(model.cases[i][j]); //Met à jour l'interface graphique
                    }
                }
                return true;
            }
        }
        
    }
    
    public static void main(String[] args){
        new Univers();
    }
}
