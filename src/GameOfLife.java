import java.util.Arrays;

public class GameOfLife {

    /**
     * @param str format 000_111_000
     */
    public static String play(String str){
        System.out.println("Game = " + str);
        String[] mas = str.split("_");

        char[][] charMas = emptyArray(mas.length+2, mas[0].length()+2);

        for (char[] row : charMas) {
            Arrays.fill(row, '0');
        }

        for(int i = 0; i < mas.length; i++){
            for(int j = 0; j < mas[i].length(); j++){
                charMas[i+1][j+1] = mas[i].charAt(j);
            }
        }

        //printArray(charMas);

        char[][] newCharMas = emptyArray(charMas.length, charMas[0].length);

        //printArray(newCharMas);

        for(int i = 1; i <= mas.length; i++){
            for(int j = 1; j <= mas[0].length(); j++){
                //charMas[i+1][j+1]
                int life = 0;
                for(int aroundI = i-1; aroundI <= i+1; aroundI++){
                    for(int aroundJ = j-1; aroundJ <= j+1; aroundJ++){
                        //System.out.println(aroundI + ":" + aroundJ + "=" + charMas[aroundI][aroundJ]);
                        if(!(aroundI == i && aroundJ == j) && charMas[aroundI][aroundJ] == '1'){
                            ++life;
                        }
                    }
                }
                if(charMas[i][j] == '1'){
                    if(life == 2 || life == 3){
                        newCharMas[i][j] = '1';
                    }else{
                        newCharMas[i][j] = '0';
                    }
                }else{
                    if(life == 3){
                        newCharMas[i][j] = '1';
                    }
                }
            }
        }

        //printArray(newCharMas);

        return generateFinalString(newCharMas, mas.length, mas[0].length());
    }

    private static String generateFinalString(char[][] charsMas, int countRow, int countColumn){
        StringBuilder finalString = new StringBuilder();
        for(int i = 1; i <= countRow; i++){
            for(int j = 1; j <= countColumn; j++){
                finalString.append(charsMas[i][j]);
            }
            if(i+1 <= countRow){
                finalString.append("_");
            }
        }
        return finalString.toString();
    }

    private static void printArray(char[][] charsMas){
        for (char[] row : charsMas) {
            for (char simbol : row) {
                System.out.print(simbol);
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }

    private static char[][] emptyArray(int countRow, int countColumn){
        char[][] charsMas = new char[countRow][countColumn];
        for (char[] row : charsMas) {
            Arrays.fill(row, '0');
        }
        return charsMas;
    }
}
