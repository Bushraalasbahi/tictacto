import java.util.Scanner;

    public class tictacto {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);


            System.out.println("player 1,what is your name");
            String p1 = in.nextLine();
            System.out.println("playar 2,what is your name");
            String p2 = in.nextLine();


            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0;j < 3;j++) {
                    board[i][j] = '-';
                }
            }
            boolean isplayer1 = true;

            boolean gameslnded = false;

            while (!gameslnded) {
                drowBOARD(board);


                char syebol = ' ';
                if (isplayer1) {
                    syebol = 'x';
                } else {
                    syebol = 'o';
                }

                if (isplayer1) {
                    System.out.println(p1 + "s yurn(x):");
                } else {
                    System.out.println(p2 + "s yurn(o):");


                }
                int row = 0;
                int col = 0;


                while (true) {


                    System.out.print("enter a row(0,1, or 2):");
                    row = in.nextInt();
                    System.out.print("enter a col(0,1, or 2):");
                    col = in.nextInt();
                    if (row < 0 || col < 0 || row > 2 || col > 2) {
                        System.out.println(" your row and col are out of bounds!");
                    } else if (board[row][col] != '-') {
                        System.out.println("smeone has alrealy nade amove ther!");
                    } else {
                        break;
                    }
                }
                board[row][col] = syebol;
                if (haswon(board) == 'x') {
                    System.out.println(p1 + "has wonkiest!");
                    gameslnded = true;
                } else if (haswon(board) == 'o') {
                    System.out.println(p2 + "has wonkiest!");
                    gameslnded = true;
                } else {
                    if (hastieb(board)) {
                        System.out.println("it's atie!");
                        gameslnded = true;
                    } else {
                        isplayer1 = !isplayer1;

                    }
                }
            }

        }

        public static void drowBOARD(char[][] board) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        public static char haswon(char[][] board) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                    return board[i][0];
                }
            }
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                    return board[0][j];
                }
            }
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {

                return board[0][0];
            }
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
                return board[2][0];
            }
            return '-';
        }

        public static boolean hastieb(char[][] board) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }
    }


