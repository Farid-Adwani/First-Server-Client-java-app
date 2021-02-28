import java.rmi.registry.Registry ;
import java.rmi.registry.LocateRegistry ;
import java.rmi.server.UnicastRemoteObject ;
public class ServeurBank {
    public ServeurBank() {

    }

public static void main(String args[]) {
    try {
       
        BankDistant objDistant = new BankDistant();
        IBank stub = (IBank) UnicastRemoteObject.exportObject(objDistant, 0);
        Registry reg = LocateRegistry.getRegistry();
        reg.bind("bankServeurClient", stub);
        System.err.println("Server ready");
    } catch (Exception e) {
        System.err.println("Server exception: " + e.toString());
        e.printStackTrace();
    }
}
}