import java.util.ArrayList;

public class CryptoMarche
{

    private ArrayList<Portefeuille> portefeuilles;
    private static CryptoMarche marche;

    private CryptoMarche(){ portefeuilles = new ArrayList<Portefeuille>(); }

    public static CryptoMarche getInstance()
    {
        if(marche == null){ marche = new CryptoMarche();}
		return marche;
    }

    public void ajouter(Portefeuille p){ portefeuilles.add(p); }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * du propriétaire et calcule son capital en euros. 
     * @param proprietare
     * @return capital en euros du propriétare.
     */
    public double capitalEnEuros(String proprietaire)
    {
        double result;
        result = 0;

        for (int i = 0; i<portefeuilles.size() ; i++)
        {
            portefeuilles.get(i).getProprietaire();

            if (portefeuilles.get(i).getProprietaire().equals(proprietaire))
            {
                result += portefeuilles.get(i).valeurEnEuros();
            }
        }
        return result;
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * d'un type de devise et calcule le volume total de capital de 
     * cette devise sur le marché 
     * @param monnaie
     * @return capital total en circulation de la cryptomonnaie (en euros).
     */
    public double capitalMonneaie(Cryptomonnaie monnaie)
    {
        double result;
        result = 0;

        for (int i = 0; i<portefeuilles.size() ; i++)
        {
            portefeuilles.get(i).getMonnaie();

            if (portefeuilles.get(i).getMonnaie().equals(monnaie))
            {
                result += portefeuilles.get(i).valeurEnEuros();
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        String ret = "";
        for(Portefeuille p : this.portefeuilles){
            ret += p.toString() + "\n";
        }
        return ret;
    }
}
