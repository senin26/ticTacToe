// Finding and getting of the win combinations

public class WinCombinations {

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
   private boolean isDefeated;

    WinCombinations() {

        for (int i = 0; i < combinations.length; i++) {
            combinations[i] = true;
        }

        isDefeated = false;
    }

    // once some button is clicked, the relevant combination gets not accessible

    public void findWinCombinations(int clickedBtn) {
        switch (clickedBtn) {
            case 0:
                combinations[0] = false;
                combinations[3] = false;
                combinations[6] = false;
                break;
            case 1:
                combinations[0] = false;
                combinations[4] = false;
                break;
            case 2:
                combinations[0] = false;
                combinations[5] = false;
                combinations[7] = false;
                break;
            case 3:
                combinations[1] = false;
                combinations[3] = false;
                break;
            case 4:
                combinations[1] = false;
                combinations[4] = false;
                combinations[6] = false;
                combinations[7] = false;
                break;
            case 5:
                combinations[1] = false;
                combinations[5] = false;
                break;
            case 6:
                combinations[2] = false;
                combinations[3] = false;
                combinations[7] = false;
                break;
            case 7:
                combinations[2] = false;
                combinations[4] = false;
                break;
            case 8:
                combinations[2] = false;
                combinations[5] = false;
                combinations[6] = false;
                break;
        }
    }

    public boolean[] getCombinations() {
        return combinations;
    }

}
