public class TestCryptoMarche {
    public static void main(String[] args) {

        //Creation de crypto-monnaie
        Cryptomonnaie bitcoin  = new Cryptomonnaie("btc", 50000);
        Cryptomonnaie ethereum = new Cryptomonnaie("eth", 2000);

        //Creation de portefeuilles
        Portefeuille joseeBtc = new Portefeuille(bitcoin,  10, "Kirito");
        Portefeuille joseeEth = new Portefeuille(ethereum, 10, "Kirito");
        Portefeuille jemlehBtc  = new Portefeuille(bitcoin,   5, "Alice"  );

        //Creation du marché
        CryptoMarche marche = CryptoMarche.getInstance();
        marche.ajouter(joseeBtc);
        marche.ajouter(joseeEth);
        marche.ajouter(jemlehBtc);

        //Transfert des monnaies entre portefeuilles
        jemlehBtc.transfertDevise(joseeBtc, 2);
        jemlehBtc.transfertDevise(joseeBtc, 10); 
        jemlehBtc.transfertDevise(joseeEth, 1); 

        //Test Portefeuille
        System.out.print("Test Portefeuille transfertDevise \t ...");
        if (joseeBtc.getMontant() == 12 && jemlehBtc.getMontant() == 3)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");
        
        //Achats des monnaies 
        jemlehBtc.achatDevise(25000);
        joseeBtc.achatDevise(-200000);
        
        System.out.print("Test Portefeuille achatDevise    \t ...");
        if (joseeBtc.getMontant() == 12 && jemlehBtc.getMontant() == 3.5)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

        //Test Marche 
        //Test capitalEnEuros
        double capitalKirito = marche.capitalEnEuros("Kirito");
        double capitalAlice   = marche.capitalEnEuros("Alice");
        
        System.out.print("Test CryptoMarche capitalEnEuros \t ...");
        if (capitalKirito == 620000 && capitalAlice == 175000)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

        //Test capitalMonnaie
        double capitalBtc = marche.capitalMonneaie(bitcoin);
        double capitalEth = marche.capitalMonneaie(ethereum);

        System.out.print("Test CryptoMarche capitalMonneaie \t ...");
        if (capitalBtc == 775000 && capitalEth == 20000)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

    }
}
