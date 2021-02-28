import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class BankDistant implements IBank   {
    public Compte[] t ;
    public int taille;

   public PrintStream o = new PrintStream(new File("Historique.txt")); 
  
       
    

    public BankDistant() throws IOException {
        t = new Compte[100] ;
        taille=0;
         // Store current System.out before assigning a new value 
         PrintStream console = System.out; 
  
         // Assign o to output stream 
         System.setOut(o); 
         System.out.println("Voici l'Historique de la derniere session ");
   
  
        }
    
public int getnum(){return this.taille;}

    public String etatCompte(int id,String mdp){
        if((t[id-1].mdp).equals(mdp)){
            System.out.println(t[id-1].nom+" "+t[id-1].prenom+" a acceder a l'etat de son compte.");
            if(t[id-1].getValeurCompte() >= 0){
                return (t[id-1].nom+" "+t[id-1].prenom+" votre compte est debiteur") ;
            }else{
                return (t[id-1].nom+" "+t[id-1].prenom+" votre compte est crediteur") ;
            }
            
        }else return "Donnees invalides, Veuillez ressayer..."  ;    
        
    }
    public String ajouterSurCompte(int id,String mdp ,float valeur ){
        if((t[id-1].mdp).equals(mdp)){
            t[id-1].setValeurCompte(t[id-1].getValeurCompte() + valeur );
            System.out.println(t[id-1].nom+" "+t[id-1].prenom+" a ajoute "+valeur+"  a  son compte.");
            return (t[id-1].nom+" "+t[id-1].prenom+" "+valeur +" dt sont ajoutees a votre compte") ;  
            

        }else return "Donnees invalides, Veuillez ressayer...";

    }
    public String enleverSurCompte(int id,String mdp ,float valeur){
        if((t[id-1].mdp).equals(mdp)){
            t[id-1].setValeurCompte(t[id-1].getValeurCompte() - valeur );
            System.out.println(t[id-1].nom+" "+t[id-1].prenom+" a enleve "+valeur+"  de  son compte.");
            return (t[id-1].nom+" "+t[id-1].prenom+ " "+valeur + " dt sont retranchees de votre compte") ;  
        }else return "Donnees invalides, Veuillez ressayer...";
     
    }
    public String transfertEntreComptes(int idSender,String mdp , int IdReceiver , float montant){
        if((t[idSender-1].mdp).equals(mdp)){
            System.out.println(t[idSender-1].nom+" "+t[idSender-1].prenom+" a transfere "+montant+"  au compte de "+t[IdReceiver-1].nom+" "+t[IdReceiver-1].prenom);
            t[IdReceiver-1].setValeurCompte(t[IdReceiver-1].getValeurCompte() + montant );
            t[idSender-1].setValeurCompte(t[idSender-1].getValeurCompte() - montant );
            return (t[idSender-1].nom+" "+t[idSender-1].prenom+" "+ montant + " dt ont ete ajoutees au compte " + IdReceiver+" de"+t[IdReceiver-1].nom+" "+t[IdReceiver-1].prenom ) ;
        }else return "Donnees invalides, Veuillez ressayer...";
      
    }
    
    public String creerCompte(String mdp,String nom, String prenom){
        
        Compte a = new Compte(mdp,nom,prenom) ;
        taille=Compte.numCompte;
        System.out.println(nom+" "+prenom+" a cree son nouveau compte sous l' ID : "+Compte.numCompte);
        t[(Compte.numCompte) -1] = a ;
       
        return (t[taille-1].nom+" "+t[taille-1].prenom+" votre id est "+ a.getId()+" et Votre Mot de passe est : "+mdp) ;
    }

    public String getValeur(int id,String mdp){
        if((t[id-1].mdp).equals(mdp)){
            System.out.println(t[id-1].nom+" "+t[id-1].prenom+" a accede au valeur de son compte.");
            return (t[id-1].nom+" "+t[id-1].prenom+" Votre Solde est: "+t[id-1].getValeurCompte()+" dt");
        }else return "Donnees invalides, Veuillez ressayer...";
        
    }
}