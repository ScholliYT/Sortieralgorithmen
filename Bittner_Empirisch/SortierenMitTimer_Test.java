import java.io.*;

public class SortierenMitTimer_Test
{
   private SortierenMitTimer sorter;

   public SortierenMitTimer_Test() throws Exception
   {
      sorter = new SortierenMitTimer(5, 1);
      this.statistikErstellen();
   }
   
   public static void main(String[] args) 
   {
      try
      {
         new SortierenMitTimer_Test();
      }
      catch (Exception e)
      {
      }
   }
   
   public void statistikErstellen() throws Exception
   {
      long[] liste1 = new long[10];
      long[] liste2 = new long[10];
      long[] liste3 = new long[10];
      
      final int STEP = 10000;
      
      //Ein PrintWriter-Objekt schreibt Werte in die angegebene Datei
      File f = new File("zahlen.csv");
      PrintWriter pw = new PrintWriter(f);
      
      for (int type = 1; type <=3; type++)
      {
         for (int i = 1; i <= 10; i++)
         {
            sorter.listeErzeugen(i*STEP, type);
            liste1[i-1] = sorter.selectionSort();
            liste2[i-1] = sorter.bubbleSort();
            liste3[i-1] = sorter.insertionSort();
            System.out.println("\n");
         }
         
         pw.println(sorter.getSortierung());
         pw.print("n;");
         
         for (int i = 0; i <= 10; i++)
         {
            pw.print(i * STEP);
            pw.print(';');
         }
         pw.println();
         
         pw.print("SELECTIONSORT;0;");
         for (int i = 0; i < 10; i++)
         {
            pw.print(liste1[i]);
            pw.print(';');
         }
         pw.println();
         
         pw.print("BUBBLESORT;0;");
         for (int i = 0; i < 10; i++)
         {
            pw.print(liste2[i]);
            pw.print(';');
         }
         pw.println();
         
         pw.print("INSERTIONSORT;0;");
         for (int i = 0; i < 10; i++)
         {
            pw.print(liste3[i]);
            pw.print(';');
         }
         pw.println();
         pw.println();
      }
      System.out.println("Die Daten wurden in folgende Datei geschrieben:");
      System.out.println(f.getAbsolutePath());
      
      pw.flush();
      pw.close();
   }
}
