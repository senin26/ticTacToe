import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Operation of the computer player

public class ComputerPlayer {


    private Random random = new Random();
    private int finalCombination;
    private int previousCombination;
    private int chosenCell;

    ComputerPlayer(){
        previousCombination = 8; // default combination; there're 8 combinations of win (0-7)
    }

    public int getFinalCombination(boolean[] combinations) {
        int numberCombinations = 0;
        List<Integer> winCombinationsList = new ArrayList<>();
        for (int i = 0; i < combinations.length; i++) {
            if (combinations[i] == true) {
                winCombinationsList.add(i);
                numberCombinations++;
            }
        }

        if (winCombinationsList.contains(previousCombination))
            finalCombination = previousCombination;

        else if (numberCombinations >= 1) {
            finalCombination = winCombinationsList.get(random.nextInt(numberCombinations));
            previousCombination = finalCombination;
        } else finalCombination = 8;

        return finalCombination;
    }

    public int setChosenCell(int finalCombination, char[] clickedCells) {

        int index = random.nextInt(3);
        int clickedIndex = getCombinationCells(finalCombination)[index];

        if ((clickedCells[clickedIndex] == '-')) {
            chosenCell = clickedIndex;
        } else {
            do {
                if (index <= 1) {
                    index++;
                } else
                    index = 0;
            } while ((clickedCells[getCombinationCells(finalCombination)[index]] != '-'));
        }
        chosenCell = getCombinationCells(finalCombination)[index];

        return chosenCell;
    }

    public int getPreviousCombination() {
        return previousCombination;
    }

    public int[] getCombinationCells(int finalCombination) {
        int[] combinationCells = new int[3];
        switch (finalCombination) {
            case 0:
                combinationCells[0] = 0;
                combinationCells[1] = 1;
                combinationCells[2] = 2;
                break;
            case 1:
                combinationCells[0] = 3;
                combinationCells[1] = 4;
                combinationCells[2] = 5;
                break;
            case 2:
                combinationCells[0] = 6;
                combinationCells[1] = 7;
                combinationCells[2] = 8;
                break;
            case 3:
                combinationCells[0] = 0;
                combinationCells[1] = 3;
                combinationCells[2] = 6;
                break;
            case 4:
                combinationCells[0] = 1;
                combinationCells[1] = 4;
                combinationCells[2] = 7;
                break;
            case 5:
                combinationCells[0] = 2;
                combinationCells[1] = 5;
                combinationCells[2] = 8;
                break;
            case 6:
                combinationCells[0] = 0;
                combinationCells[1] = 4;
                combinationCells[2] = 8;
                break;
            case 7:
                combinationCells[0] = 2;
                combinationCells[1] = 4;
                combinationCells[2] = 6;
                break;
        }
        return combinationCells;
    }

    public void setPreviousCombination(int previousCombination) {
        this.previousCombination = previousCombination;
    }
}