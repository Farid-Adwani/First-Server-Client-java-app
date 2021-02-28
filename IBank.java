import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBank extends Remote {
    public String etatCompte(int id,String mdp) throws RemoteException;
    public String getValeur(int id,String mdp) throws RemoteException;
    public String ajouterSurCompte(int id,String mdp ,float valeur ) throws RemoteException;
    public String enleverSurCompte(int id,String mdp ,float valeur) throws RemoteException;
    public String transfertEntreComptes(int idSender,String mdp , int IdReceiver , float montant)  throws RemoteException;
    public int getnum() throws RemoteException;
    public String creerCompte(String mdp,String nom,String prenom) throws RemoteException;
   

}