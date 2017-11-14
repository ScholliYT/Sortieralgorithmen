import java.util.*;

//SelectionSort, BubbleSort, InsertionSort
//und Erfassen der benötigten Zeit
public class SortierenMitTimer
{

    private int[] list;
    private int[] liste;
    private String typ;

    public SortierenMitTimer(int n, int type)
    {
        this.listeErzeugen(n, type);
    }

    public String getSortierung()
    {
        return typ;
    }
    
    public void listeErzeugen(int n, int type)
    {
        list = new int[n];
        
        if (type == 1)    //aufsteigend sortierte Liste
        {
            for (int j = 0; j < n; j++)
            {
                list[j] = j;
            }
            typ = "aufsteigend sortiert";
        }
        else if (type == 2)   //absteigend sortierte Liste
        {
            for (int j = 0; j < n; j++)
            {
                list[j] = n-j;
            }
            typ = "absteigend sortiert";
        }   
        else            //zufallssortierte Liste
        {
            Random rd = new Random();
            for (int j = 0; j < n; j++)
            {
                list[j] = rd.nextInt(n*10);
            }
            typ = "zufallssortiert";
        }
    }
                   
    public long selectionSort()
    {
        //Kopie der unsortierten "Ausgangsliste" erstellen
        int[] liste = list.clone();
        
        System.out.println("SELECTION SORT:  n = " + liste.length + ", " + typ);        
       
        int n = liste.length;
        int minID;
        int tausch;

        long start = System.currentTimeMillis();
        
        //Beginn des Sortieralgorithmus SELECTION SORT
        for (int i = 0; i < (n - 1); i++)
        {
            minID = i;
            for (int j = i + 1; j < n; j++)
            {
                if (liste[j] < liste[minID])
                {
                    minID = j;
                }
            }
            //Tauschvorgang
            tausch = liste[i];
            liste[i] = liste[minID];
            liste[minID] = tausch;
        }
        long dauer = System.currentTimeMillis()- start;

        System.out.println("Dauer: " + dauer/1000.0 + " Sekunden");
        System.out.println();
        
        return dauer;
    }
    
    public long bubbleSort()
    {
        //Kopie der unsortierten "Ausgangsliste" erstellen
        int[] liste = list.clone();
        
        //Unsortierte "Ausgangsliste" am Bildschirm ausgeben
        System.out.println("BUBBLE SORT:  n = " + liste.length + ", " + typ);     

        
        int n = liste.length;
        int tausch;

        long start = System.currentTimeMillis();
        //Beginn des Sortieralgorithmus BUBBLE SORT
        for (int i = 0; i < n-1; i++)
        {
           for (int j = n-1; j > i; j--)
           {
              if (liste[j] < liste[j-1])
              {
                 tausch = liste[j];
                 liste[j] = liste[j-1];
                 liste[j-1] = tausch;
              }
           }        
        }
        
        long dauer = System.currentTimeMillis()- start;

        System.out.println("Dauer: " + dauer/1000.0 + " Sekunden");
        System.out.println();
        
        return dauer;
    }
    
    public long insertionSort()
    {
        //Kopie der unsortierten "Ausgangsliste" erstellen
        int[] liste = list.clone();
        
        //Unsortierte "Ausgangsliste" am Bildschirm ausgeben
        System.out.println("INSERTION SORT:  n = " + liste.length + ", " + typ);     
        
        int n = liste.length;
        int tausch;
        int j;

        long start = System.currentTimeMillis();
        
        //Beginn des Sortieralgorithmus INSERTION SORT
        for (int i = 1; i < n; i++)
        {
            if (liste[i] < liste[i-1])
            {
                tausch = liste[i];
                j = i;
                do
                {
                    liste[j] = liste[j-1];
                    j--;
                }
                while (j > 0 && liste[j-1] > tausch);
                liste[j] = tausch;
            }
        }
        
        long dauer = System.currentTimeMillis()- start;

        System.out.println("Dauer: " + dauer/1000.0 + " Sekunden");
        System.out.println();
        
        return dauer;
    }
}
