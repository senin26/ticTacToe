import java.util.*;

// Finding and getting of the defeat combinations

public class DefeatCombinations {

    /*
     * 0 - cells 0,1,2
     * 1 - cells 3,4,5
     * 2 - cells 6,7,8
     * 3 - cells 0,3,6
     * 4 - cells 1,4,7
     * 5 - cells 2,5,8
     * 6 - cells 0,4,8
     * 7 - cells 2,4,6
     * */
    private boolean[] combinations = new boolean[8];
    private boolean dangerCellsExist;
    private boolean isDanger;
    private Random random;
    private List<Integer> dangerCombs;
    private List<Integer> dangerCells;
    private int dangerCell;
    private int[][] allCombinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };

    DefeatCombinations() {

     /*   countDangerCells = 0;*/

        dangerCombs = new ArrayList<>();
        dangerCells = new ArrayList<>();
        isDanger = false;

        for (int i = 0; i < combinations.length; i++) {
            combinations[i] = true;
        }

        dangerCellsExist = false;
    }

    // once some button is clicked, the relevant combination gets not accessible

    public void findDangerCells(char[] clickedCells) {

        for (int i = 0; i < combinations.length; i++) {

            int countXinCombination = 0;

            int[] indexes = new int[3];

            for (int j = 0; j < indexes.length; j++) {
                indexes[j] = allCombinations[i][j];
            }

            int tempDangerCell = 0;
            isDanger = false;

            // search within the combination
            for (int k = 0; k < indexes.length; k++) {

                if (clickedCells[indexes[k]] == '-') {
                    tempDangerCell = indexes[k];
                    isDanger = true;
                }

                if (clickedCells[indexes[k]] == 'x') {
                    countXinCombination++;
                }


                if ( (isDanger == true) && (countXinCombination == 2) && (k == 2) ) {
                    System.out.print("The current index in the combination is " + k + ". ");
                    System.out.println("Add danger cell for " + i + "-th combination = " + tempDangerCell);
                    dangerCell = tempDangerCell;
                    dangerCellsExist = true;
                    dangerCombs.add(i);
                }
            }
            System.out.println("At the combination " + i + " the countXinCombination is " + countXinCombination);

        }
    }

    public int getDangerCell() {
        /*int dangerCell;
        if (dangerCellsExist) {
            dangerCell = dangerCombs.get(0);
            //dangerCell = dangerCombs.get(random.nextInt(countDangerCells)); // dangerCell = dangerCombs.get(random.nextInt(countDangerCells + 1));
            return dangerCell;
        }
        else return -1;*/
        if (dangerCellsExist) {
            //int dangerCell = dangerCells.get(0);
            return dangerCell;
        }
        else return -1;
    }


}
