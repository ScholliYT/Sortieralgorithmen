import java.util.*;
public class Sortieren {

  private final int max = 43;
  int[] unsortiert = new int[30];
  int charCount = 0;  

  public static void main(String[] args) {
    new Sortieren();
  }


  public Sortieren() {
    charCount = getCharCount(max);
    rndListe(unsortiert, max);



    System.out.println("========== SelectionSort ==========");
    int[] liste = Arrays.copyOf(unsortiert, unsortiert.length);
    printArray(liste);
    System.out.println();
    selectionSort(liste);
    System.out.println();
    System.out.println();
    

    //System.out.println("========== BubbleSort ==========");
    //liste = Arrays.copyOf(unsortiert, unsortiert.length);
    //for (int i = 0; i < liste.length; i++) {
    //  System.out.print(liste[i] + " ");
    //}
    //System.out.println();
    //bubbleSort(liste);
    //for (int i = 0; i < liste.length; i++) {
    //  System.out.print(liste[i] + " ");
    //}
    //System.out.println();
    //System.out.println();
    
    System.out.println("========== BubbleSortRueckwaerts ==========");
    liste = Arrays.copyOf(unsortiert, unsortiert.length);
    printArray(liste);
    System.out.println();
    bubbleSortRueckwaerts(liste);
    System.out.println();
    System.out.println();

    //System.out.println("========== InsertionSort ==========");
    //liste = Arrays.copyOf(unsortiert, unsortiert.length);
    //for (int i = 0; i < liste.length; i++) {
    //  System.out.print(liste[i] + " ");
    //}
    //System.out.println();
    //insertionSort(liste);
    //for (int i = 0; i < liste.length; i++) {
    //  System.out.print(liste[i] + " ");
    //}
    //System.out.println();
    //System.out.println();

    System.out.println("========== InsertionSortMarcel ==========");
    liste = Arrays.copyOf(unsortiert, unsortiert.length);
    printArray(liste);
    System.out.println();
    insertionSortMarcel(liste);
    System.out.println();
    System.out.println();



  }

  private void rndListe(int[] _liste, int _max) {
    Random r = new Random();
    for(int i = 0; i < _liste.length; i++) {
      _liste[i] = r.nextInt(_max);
    }
  }


  private void selectionSort(int[] _liste) {
    int n = _liste.length;
    int i = 0;
    int minID = 0;

    while (i < (n - 1)) {
      int j = i + 1;
      minID = i;

      while (j < n) {
        if (_liste[j] < _liste[minID]) {
          minID = j;
        }

        j++;
      }
      swap(_liste, i, minID);
      printArray(_liste);
      i++;
    }
  }

  private void bubbleSort(int[] _liste) {
    int n = _liste.length;
    for(int i = 1; i < n; i++) {
      for(int j = 0; j < n - i; j++) {
        if(_liste[j] > _liste[j + 1]) {
          swap(_liste, j, j+1);
        }
      }
    }
  }

  private void bubbleSortRueckwaerts(int[] _liste) {
    int n = _liste.length;
    for(int i = 0; i < n -1; i++) {
      for(int j = n - 1; j > i; j--) {
        if(_liste[j] < _liste[j-1]) {
          swap(_liste, j, j-1);
        }
      }
      printArray(_liste);
    }
  }

  private void insertionSort(int[] _liste) {
    int n = _liste.length;
    for(int i = 1; i < n; i++) {
      int j = i;
      int value = _liste[i];
      while(j > 0 && _liste[j- 1] > value) {
        _liste[j] = _liste[j-1];
        j--;
      }
      _liste[j] = value;
    }
  }


  private void insertionSortMarcel(int[] _liste) {
    int n = _liste.length;
    int i = 1;
    while(i < n) {
      int j = i;
      while(j > 0) {
        if(_liste[j] < _liste[j-1]) {
          //Swap
          int temp = _liste[j];
          _liste[j] = _liste[j-1];
          _liste[j-1] = temp;
          j--;
        }
        else {
          //Break
          j = 0;
        }
      }
      printArray(_liste);
      i++;
    }
  }

  private void swap(int[] _liste, int a, int b) {
    int temp = _liste[a];
    _liste[a] = _liste[b];
    _liste[b] = temp;
  }

  private void printArray(int[] _liste) {
    for (int iPrint = 0; iPrint < _liste.length; iPrint++) {
      int val = _liste[iPrint];
      int valChars = getCharCount(val);
      for(int c = 0; c < (charCount - valChars); c++) {
        System.out.print(" ");
      }
      System.out.print(_liste[iPrint] + " ");
    }
    System.out.println();
  }

  private int getCharCount(int _number) {
    int count = 1;
    int tempMax = _number;
    while(tempMax / 10 != 0) {
      count++;
      tempMax /= 10;
    }
    return count;
  }
}
