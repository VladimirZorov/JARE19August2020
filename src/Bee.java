import java.util.Scanner;

public class Bee {

    public static int pollinatedFlowers = 0;
    public static int rowBee = -1;
    public static int collBee = -1;
    public static boolean isInTerritory = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] beeTerritory = new String[n][n];


        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            beeTerritory[i] = line;
            for (int j = 0; j < n; j++) {
                if (line[j].equals("B")) {
                    rowBee = i;
                    collBee = j;
                }
            }
        }

        int p = pollinatedFlowers;
        int r = rowBee;
        int c = collBee;

        String command = scanner.nextLine();
        while (!command.equals("End") && isInTerritory) {
            switch (command) {
                case "up":
                    beeTerritory[rowBee][collBee] = ".";
                    if (checkIsInTerritory (rowBee, collBee, -1 , 0, n)){
                        checkSymbol(beeTerritory,r,c,command,n, p);
                    } else {
                        isInTerritory = false;
                    }
                    break;
                case "down":
                    beeTerritory[rowBee][collBee] = ".";
                    if (checkIsInTerritory (rowBee, collBee, +1 , 0, n)){
                        checkSymbol(beeTerritory,r,c,command,n,p);
                    } else {
                        isInTerritory = false;
                    }
                    break;
                case "left":
                    beeTerritory[rowBee][collBee] = ".";
                    if (checkIsInTerritory (rowBee, collBee, 0 , -1, n)){
                        checkSymbol(beeTerritory,r,c,command,n,p);
                    } else {
                        isInTerritory = false;
                    }
                    break;
                case "right":
                    beeTerritory[rowBee][collBee] = ".";
                    if (checkIsInTerritory (rowBee, collBee, 0 , +1, n)){
                        checkSymbol(beeTerritory,r,c,command,n,p);
                    } else {
                        isInTerritory = false;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

       if (!isInTerritory) {
           System.out.println("The bee got lost!");
       }

       beeTerritory[rowBee][collBee] = "B";
       if (pollinatedFlowers >= 5) {
           System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
       } else {
           System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 -pollinatedFlowers));
       }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(beeTerritory[i][j]);
            }
            System.out.println();
        }
    }

    private static void checkSymbol(String beeTerritory[][], int r, int c, String command, int n, int pollinatedFlowers) {
        if (beeTerritory[r][c].equals("f")) {
            pollinatedFlowers ++;
        } else if (beeTerritory[r][c].equals("O")) {
            beeTerritory[r][c] = ".";
            oneStepMore (command ,r, c, n);
        }
    }

    private static void oneStepMore(String command, int r, int c,int n) {
        if (command.equals("up")) {
            checkIsInTerritory(r, c, -1,0, n);
        } else if (command.equals("down")) {
            checkIsInTerritory(r, c, +1,0, n);
        } else if (command.equals("left")) {
            checkIsInTerritory(r, c, 0,-1, n);
        } else if (command.equals("right")) {
            checkIsInTerritory(r, c, 0,+1, n);

        }
    }

    public static boolean checkIsInTerritory(int r, int c, int moveRow, int moveColl, int n) {
        if (rowBee + moveRow >= 0 && rowBee + moveRow < n
                && collBee + moveColl >= 0 && collBee + moveColl < n) {
            rowBee += moveRow;
            collBee += moveColl;
            return true;
        } else {
            return false;
        }
    }
}
