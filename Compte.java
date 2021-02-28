public class Compte{
    private int id ;
    private float valeur ;
    public String mdp;
    public String nom;
    public String prenom;
    public static int numCompte = 0 ;
    public Compte(String mdp,String nom ,String prenom){
        numCompte ++ ;
        this.id = numCompte ;
        this.valeur = 0 ;
        this.mdp=mdp;
        this.nom=nom;
        this.prenom=prenom;
    }
    public float getValeurCompte(){
        return this.valeur ;
    }
    public void setValeurCompte(float valeur){
        this.valeur = valeur ;
    }
    public int getId(){
        return this.id ;
    }
}