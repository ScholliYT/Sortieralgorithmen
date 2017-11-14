import java.util.Random;

public class Empirisch {

    private final int numberSpace = 1000;
    private final int initArraySize = 10000;
    private final int maxSizeMultiplyer = 1;
    private final int avgs = 3;

    private static ExcelExport ee;

    public static void main(String[] args) {
        ee = new ExcelExport("SortieralgorithmenEmpirischMitQuick");
        new Empirisch();
        ee.saveFile();
    }

    public Empirisch() {

        int[] liste = new int[150];
        rndListe(liste, 100);
        //int[] liste = new int[]{77, 32, 40, 24, 10, 30, 31, 73, 95, 73, 77, 99, 81, 0, 31, 10, 53, 99, 28, 84, 74, 50, 10, 0, 65, 72, 22, 6, 69, 67, 64, 2, 16, 41, 2, 43, 63, 42, 76, 83, 54, 49, 7, 96, 52, 97, 47, 65, 22, 80, 90, 93, 34, 67, 14, 48, 24, 33, 94, 1, 92, 86, 33, 47, 56, 32, 29, 53, 50, 81, 24, 58, 45, 53, 10, 37, 89, 19, 86, 50, 9, 34, 38, 29, 25, 97, 26, 77, 9, 36, 8, 49, 97, 95, 8, 62, 19, 98, 15, 96, 11, 19, 94, 12, 70, 8, 89, 84, 22, 28, 45, 68, 41, 9, 79, 36, 73, 32, 35, 37, 81, 8, 14, 61, 79, 42, 52, 67, 34, 39, 49, 9, 2, 32, 47, 40, 46, 90, 33, 67, 43, 66, 0, 32, 72, 88, 15, 40, 41, 76};
        //int[] liste = new int[]{0,11,31,96,5,0,23,8,17,18,3,21};
        System.out.print("===== Before: ");
        printArray(liste);
        quickSortDebug(liste);
        System.out.print("===== After: ");
        printArray(liste);
        System.out.println("This array " + (isSorted(liste)?"is":"is NOT") + " sorted!");

        
//doBenchmarksAndSaveResults();
    }

    private void doBenchmarksAndSaveResults() {
        //==================================================== Selection ====================================================
        //                         rows  colums              
        int[][] timesSelectionAsc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesSelectionAsc.length; avg++) {
            for(int g = 1; g <= timesSelectionAsc[0].length; g++) {
                int[] listeAsc = new int[initArraySize * g];
                ascListe(listeAsc, Integer.MAX_VALUE);
                timesSelectionAsc[avg][g - 1] = (int)selectionSortRun(listeAsc);    
            }
        }

        //                         rows  colums              
        int[][] timesSelectionDesc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesSelectionDesc.length; avg++) {
            for(int g = 1; g <= timesSelectionDesc[0].length; g++) {
                int[] listeDesc = new int[initArraySize * g];
                descListe(listeDesc, Integer.MAX_VALUE);
                timesSelectionDesc[avg][g - 1] = (int)selectionSortRun(listeDesc);  
            }
        }

        //                         rows  colums              
        int[][] timesSelectionRnd = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesSelectionRnd.length; avg++) {
            for(int g = 1; g <= timesSelectionRnd[0].length; g++) {
                int[] lisetRnd = new int[initArraySize * g];
                rndListe(lisetRnd, Integer.MAX_VALUE);
                timesSelectionRnd[avg][g - 1] = (int)selectionSortRun(lisetRnd);    
            }
        }

        //==================================================== Bubble ====================================================
        //                         rows  colums              
        int[][] timesBubbleAsc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesBubbleAsc.length; avg++) {
            for(int g = 1; g <= timesBubbleAsc[0].length; g++) {
                int[] listeAsc = new int[initArraySize * g];
                ascListe(listeAsc, Integer.MAX_VALUE);
                timesBubbleAsc[avg][g - 1] = (int)bubbleSortRun(listeAsc);  
            }
        }

        //                         rows  colums              
        int[][] timesBubbleDesc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesBubbleDesc.length; avg++) {
            for(int g = 1; g <= timesBubbleDesc[0].length; g++) {
                int[] listeDesc = new int[initArraySize * g];
                descListe(listeDesc, Integer.MAX_VALUE);
                timesBubbleDesc[avg][g - 1] = (int)bubbleSortRun(listeDesc);    
            }
        }

        //                         rows  colums              
        int[][] timesBubbleRnd = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesBubbleRnd.length; avg++) {
            for(int g = 1; g <= timesBubbleRnd[0].length; g++) {
                int[] lisetRnd = new int[initArraySize * g];
                rndListe(lisetRnd, Integer.MAX_VALUE);
                timesBubbleRnd[avg][g - 1] = (int)bubbleSortRun(lisetRnd);  
            }
        }

        //==================================================== Insertion ====================================================
        //                         rows  colums              
        int[][] timesInsertionAsc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesInsertionAsc.length; avg++) {
            for(int g = 1; g <= timesInsertionAsc[0].length; g++) {
                int[] listeAsc = new int[initArraySize * g];
                ascListe(listeAsc, Integer.MAX_VALUE);
                timesInsertionAsc[avg][g - 1] = (int)insertionSortRun(listeAsc);    
            }
        }

        //                         rows  colums              
        int[][] timesInsertionDesc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesInsertionDesc.length; avg++) {
            for(int g = 1; g <= timesInsertionDesc[0].length; g++) {
                int[] listeDesc = new int[initArraySize * g];
                descListe(listeDesc, Integer.MAX_VALUE);
                timesInsertionDesc[avg][g - 1] = (int)insertionSortRun(listeDesc);  
            }
        }

        //                         rows  colums              
        int[][] timesInsertionRnd = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesInsertionRnd.length; avg++) {
            for(int g = 1; g <= timesInsertionRnd[0].length; g++) {
                int[] lisetRnd = new int[initArraySize * g];
                rndListe(lisetRnd, Integer.MAX_VALUE);
                timesInsertionRnd[avg][g - 1] = (int)insertionSortRun(lisetRnd);    
            }
        }

        //==================================================== Quick ====================================================

        int[][] timesQuickAsc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesQuickAsc.length; avg++) {
            for(int g = 1; g <= timesQuickAsc[0].length; g++) {
                int[] listeAsc = new int[initArraySize * g];
                ascListe(listeAsc, Integer.MAX_VALUE);
                timesQuickAsc[avg][g - 1] = (int)quickSortRun(listeAsc);    
            }
        }

        //                         rows  colums              
        int[][] timesQuickDesc = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesQuickDesc.length; avg++) {
            for(int g = 1; g <= timesQuickDesc[0].length; g++) {
                int[] listeDesc = new int[initArraySize * g];
                descListe(listeDesc, Integer.MAX_VALUE);
                timesQuickDesc[avg][g - 1] = (int)quickSortRun(listeDesc);  
            }
        }

        //                         rows  colums              
        int[][] timesQuickRnd = new int[avgs][maxSizeMultiplyer];
        for(int avg = 0; avg < timesQuickRnd.length; avg++) {
            for(int g = 1; g <= timesQuickRnd[0].length; g++) {
                int[] lisetRnd = new int[initArraySize * g];
                rndListe(lisetRnd, Integer.MAX_VALUE);
                timesQuickRnd[avg][g - 1] = (int)quickSortRun(lisetRnd);    
            }
        }
        

        int offset = 0;
        //==================================================== Arrays Sizes in Row 0 ====================================================
        int[] sizes = new int[maxSizeMultiplyer];
        for(int i = 0; i < sizes.length; i++) {
            sizes[i] = initArraySize * (i + 1);
        }
        ee.wirteStringToFile(0,0, "Array Groesse");
        ee.wirteArrayToFile(0,1, sizes);
        offset++;
        //==================================================== Export Measurements SelectionSort ====================================================
        offset += 2;
        ee.wirteStringToFile(offset, 0, "SelectionSort");
        offset++;
        ee.wirteStringToFile(offset, 0, "Aufsteigend");
        offset++;
        for(int r = 0; r < timesSelectionAsc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesSelectionAsc[r]);
        }
        offset += timesSelectionAsc.length +1;

        ee.wirteStringToFile(offset, 0, "Absteigend");
        offset++;
        for(int r = 0; r < timesSelectionDesc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesSelectionDesc[r]);
        }
        offset += timesSelectionDesc.length +1;

        ee.wirteStringToFile(offset, 0, "Zufaellig");
        offset++;
        for(int r = 0; r < timesSelectionRnd.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesSelectionRnd[r]);
        }
        offset += timesSelectionRnd.length +1;

        //==================================================== Export Measurements BubbleSort ====================================================
        offset += 2;
        ee.wirteStringToFile(offset, 0, "BubbleSort");
        offset++;
        ee.wirteStringToFile(offset, 0, "Aufsteigend");
        offset++;
        for(int r = 0; r < timesBubbleAsc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesBubbleAsc[r]);
        }
        offset += timesBubbleAsc.length +1;

        ee.wirteStringToFile(offset, 0, "Absteigend");
        offset++;
        for(int r = 0; r < timesBubbleDesc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesBubbleDesc[r]);
        }
        offset += timesBubbleDesc.length +1;

        ee.wirteStringToFile(offset, 0, "Zufaellig");
        offset++;
        for(int r = 0; r < timesBubbleRnd.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesBubbleRnd[r]);
        }
        offset += timesBubbleRnd.length +1;

        //==================================================== Export Measurements InsertionSort ====================================================
        offset += 2;
        ee.wirteStringToFile(offset, 0, "InsertionSort");
        offset++;
        ee.wirteStringToFile(offset, 0, "Aufsteigend");
        offset++;
        for(int r = 0; r < timesInsertionAsc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesInsertionAsc[r]);
        }
        offset += timesInsertionAsc.length +1;

        ee.wirteStringToFile(offset, 0, "Absteigend");
        offset++;
        for(int r = 0; r < timesInsertionDesc.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesInsertionDesc[r]);
        }
        offset += timesInsertionDesc.length +1;

        ee.wirteStringToFile(offset, 0, "Zufaellig");
        offset++;
        for(int r = 0; r < timesInsertionRnd.length; r++) {
            ee.wirteStringToFile(r + offset, 0, "Durchlauf: " + (r + 1));
            ee.wirteArrayToFile(r + offset, 1, timesInsertionRnd[r]);
        }
        offset += timesInsertionRnd.length +1;
    }


    private void ascListe(int[] _liste, int _max) {
        System.out.println("===== Ascending Generation =====");
        System.out.println("Elements: " + _liste.length);
        Random r = new Random();
        _liste[0] = r.nextInt(_max);
        for(int i = 1; i < _liste.length; i++) {
            _liste[i] = r.nextInt(numberSpace) + _liste[i - 1];
        }
        System.out.println("===== Ascending End =====");
        System.out.println();
    }

    private void descListe(int[] _liste, int _max) {
        System.out.println("===== Descending Generation =====");
        System.out.println("Elements: " + _liste.length);
        Random r = new Random();
        _liste[0] = r.nextInt(_max);
        for(int i = 1; i < _liste.length; i++) {
            _liste[i] = _liste[i - 1] - r.nextInt(numberSpace);
        }
        System.out.println("===== Descending End =====");
        System.out.println();
    }

    private void rndListe(int[] _liste, int _max) {
        System.out.println("===== Random Generation =====");
        System.out.println("Elements: " + _liste.length);
        Random r = new Random();
        for(int i = 0; i < _liste.length; i++) {
            _liste[i] = r.nextInt(_max);
        }
        System.out.println("===== Random End =====");
        System.out.println();
    }

    private boolean isSorted(int[] _liste) {
        for(int i = 1; i < _liste.length; i++) {
            if(_liste[i] < _liste[i-1]) {
                System.out.println("Array is not sortet at: " + i + "[" + _liste[i] + "]");
                return false;
            }
        }
        return true;
    }

    private void printArray(int[] _liste) {
        for (int iPrint = 0; iPrint < _liste.length; iPrint++) {
            System.out.print(_liste[iPrint] + " ");
        }
        System.out.println();
    }

    private void printArray(int[] _liste, int _lower, int _upper) {
        for (int iPrint = 0; iPrint < _liste.length; iPrint++) {
            if((iPrint == _lower && iPrint == _upper) || (iPrint == _lower && iPrint == _upper + 1)) {
                System.out.print("|" + _liste[iPrint] + "| ");
            } else if(iPrint == _lower) {
                System.out.print("|" + _liste[iPrint] + " ");
            } else if(iPrint == _upper) {
                System.out.print(_liste[iPrint] + "| ");
            } else {
                System.out.print(_liste[iPrint] + " ");
            }
        }
        System.out.println();
    }

    private void swap(int[] _liste, int a, int b) {
        int temp = _liste[a];
        _liste[a] = _liste[b];
        _liste[b] = temp;
    }


    private long selectionSortRun(int[] _liste) {
        System.out.println("===== Selection Sorting Start =====");
        long time = selectionSortBenchmark(_liste);
        System.out.println("Time Spend: " + time);
        System.out.println("===== Selection Sorting End =====");
        System.out.println();
        System.out.println();
        return time;
    }

    private long bubbleSortRun(int[] _liste) {
        System.out.println("===== Bubble Sorting Start =====");
        long time = bubbleSortBenchmark(_liste);
        System.out.println("Time Spend: " + time);
        System.out.println("===== Bubble Sorting End =====");
        System.out.println();
        System.out.println();
        return time;
    }

    private long insertionSortRun(int[] _liste) {
        System.out.println("===== Insertion Sorting Start =====");
        long time = insertionSortBenchmark(_liste);
        System.out.println("Time Spend: " + time);
        System.out.println("===== Insertion Sorting End =====");
        System.out.println();
        System.out.println();
        return time;
    }

    private long quickSortRun(int[] _liste) {
        System.out.println("===== Quick Sorting Start =====");
        long time = quickSortBenchmark(_liste);
        System.out.println("Time Spend: " + time);
        System.out.println("===== Quick Sorting End =====");
        System.out.println();
        System.out.println();
        return time;
    }

    private long selectionSortBenchmark(int[] _liste) {
        long startTime = System.currentTimeMillis();
        selectionSort(_liste);
        return System.currentTimeMillis() - startTime;
    }

    private long bubbleSortBenchmark(int[] _liste) {
        long startTime = System.currentTimeMillis();
        bubbleSort(_liste);
        return System.currentTimeMillis() - startTime;
    }

    private long insertionSortBenchmark(int[] _liste) {
        long startTime = System.currentTimeMillis();
        insertionSort(_liste);
        return System.currentTimeMillis() - startTime;
    }

    private long quickSortBenchmark(int[] _liste) {
        long startTime = System.currentTimeMillis();
        quickSort(_liste);
        return System.currentTimeMillis() - startTime;
    }

    //==================================================== Algorithms ==================================================== 
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
            i++;
        }
    }

    private void bubbleSort(int[] _liste) {
        int n = _liste.length;
        for(int i = 0; i < n -1; i++) {
            for(int j = n - 1; j > i; j--) {
                if(_liste[j] < _liste[j-1]) {
                    swap(_liste, j, j-1);
                }
            }
        }
    }

    private void insertionSort(int[] _liste) {
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
            i++;
        }
    }
    
    public void quickSort(int[] _liste) {
        quickSort(_liste, 0, _liste.length - 1);
    }

    private void quickSort(int[] _liste, int lower, int upper) {
        int i = lower + 1, j = upper;
        if(i>j) { //Sicherstellen, dass sich elemente in der Teilliste befinden
            return;
        }
        if(_liste[lower] > _liste[upper]) { //Sicherstellen, dass das erste Element nicht das größte ist
            swap(_liste, lower, upper);
        }
        while(i<=j) {
            while(_liste[i] < _liste[lower]) {
                i++;
            }
            while(_liste[j] > _liste[lower]) {
                j--;
            }
            if(i <= j) {
                swap(_liste, i, j);
                i++; //Läuft in manchen fällen out of index
                j--;
            }
        }
        swap(_liste, lower, j);
        quickSort(_liste, lower, j-1);
        quickSort(_liste, j+1, upper);
    }

    public void quickSortDebug(int[] _liste) {
        quickSortDebug(_liste, 0, _liste.length - 1);
    }

    private void quickSortDebug(int[] _liste, int lower, int upper) {
        int i = lower + 1, j = upper;
        if(i>j) {
            System.out.print("Return becasue subarray is empty or negative (" + i + ">" + j + "): ");
            printArray(_liste, lower, upper);
            return;
        }

        //if(upper - lower <= 1) { //Wenn die Teilliste nur ein/kein Element hat.
        //   System.out.print("Return becasue subarray's size is: " + upper + "-" + lower + "=" + (upper-lower) + " < 1: ");
        //    printArray(_liste, lower, upper);
        //    return;
        //} else if(upper - lower == 1) {
        //    /*
        //    if(_liste[lower] < _liste[upper]) {
        //        return;
        //    } else {
        //        swap(_liste, lower, upper);
        //        return;
        //    }
        //    */
        //}

        if(_liste[lower] > _liste[upper]) { //Sicherstellen, dass das erste Element nicht das größte ist
            printArray(_liste, lower, upper);
            System.out.println("Swapping first element in list " + "[" + _liste[lower] + "] with last " + "[" + _liste[upper] + "]");
            swap(_liste, lower, upper);
            printArray(_liste, lower, upper);
        }
        while(i<=j) {
            while(_liste[i] < _liste[lower]) {
                i++;
            }
            while(_liste[j] > _liste[lower]) {
                j--;
            }
            if(i <= j) {
                printArray(_liste, lower, upper);
                System.out.println("Swap i: " + i + "[" + _liste[i] + "] with j: " + j + "[" + _liste[j] + "]");
                swap(_liste, i, j);
                printArray(_liste, lower, upper);

                //i++; //Läuft in manchen fällen out of index
                j--;
            }
        }

        printArray(_liste, lower, upper);
        System.out.println("New subarrays i: " + i + "[" + _liste[i] + "], j: " + j + "[" + _liste[j] + "]");
        swap(_liste, lower, j);
        printArray(_liste, lower, upper);

        //if(lower == j) {
        if(false) {
            System.out.print("SubArrayL: " + lower + "->" + (j) + ": ");
            printArray(_liste, lower, j);
            System.out.print("SubArrayR: " + (j+1) + "->" + upper + ": ");
            printArray(_liste, j+1, upper);


            quickSortDebug(_liste, lower, j);
            quickSortDebug(_liste, j+1, upper);
        } else {
            System.out.print("SubArrayL: " + lower + "->" + (j-1) + ": ");
            printArray(_liste, lower, j-1);
            System.out.print("SubArrayR: " + (j+1) + "->" + upper + ": ");
            printArray(_liste, j+1, upper);


            quickSortDebug(_liste, lower, j-1);
            quickSortDebug(_liste, j+1, upper);
        }
        
    }

    /*
    private void quicksort(int[] _liste, int lower, int upper) {
        printArray(_liste);
        if (_liste[lower] > _liste[upper]) {
            swap(_liste, lower, upper);
            System.out.print("Swap: ");
            printArray(_liste);
        }

        int pivot = _liste[lower];
        int i = lower, j = upper;

        while (i <= j) {

            while (_liste[i] < pivot) {
                i++;
            }
            while (_liste[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(_liste, i, j);
                i++;
                j--;
            }
        }
        if (lower < j)
            quicksort(_liste, lower, j);
        if (i < upper)
            quicksort(_liste, i, upper);  
    }
    */
}