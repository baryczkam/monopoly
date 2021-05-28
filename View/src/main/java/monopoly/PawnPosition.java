package monopoly;

//import Monopoly.Player.Pawn;
import Monopoly.Board.Field;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;

public class PawnPosition {
    private String nameOfPawn;
//    private int numberOfField;
//    private Pawn pawn;
//
//    public Pawn2(String nameOfPawn, int numberOfField) {
//        this.nameOfPawn = nameOfPawn;
//        this.numberOfField = numberOfField;
//    }

//    public Pawn2(String nameOfPawn, Pawn pawn) {
//        this.nameOfPawn = nameOfPawn;
//        this.pawn = pawn;
//    }


    public PawnPosition(String nameOfPawn) {
        this.nameOfPawn = nameOfPawn;
    }

    public void changePawnPosition(ImageView pionek, int field, int iloscPrzesuniec) throws InterruptedException {
        double x;
        double y;
        int przesuniecie;

        if (field == 0) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(721);
        }
        if (field == 1) {
            pionek.setLayoutX(631);
            pionek.setLayoutY(721);
        }
        if (field == 2) {
            pionek.setLayoutX(566);
            pionek.setLayoutY(721);
        }
        if (field == 3) {
            pionek.setLayoutX(501);
            pionek.setLayoutY(721);
        }
        if (field == 4) {
            pionek.setLayoutX(436);
            pionek.setLayoutY(721);
        }
        if (field == 5) {
            pionek.setLayoutX(371);
            pionek.setLayoutY(721);
        }
        if (field == 6) {
            pionek.setLayoutX(306);
            pionek.setLayoutY(721);
        }
        if (field == 7) {
            pionek.setLayoutX(241);
            pionek.setLayoutY(721);
        }
        if (field == 8) {
            pionek.setLayoutX(176);
            pionek.setLayoutY(721);
        }
        if (field == 9) {
            pionek.setLayoutX(111);
            pionek.setLayoutY(721);
        }
        if (field == 10) {
            pionek.setLayoutX(0);
            pionek.setLayoutY(740);
        }
        if (field == 11) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(625);
        }
        if (field == 12) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(560);
        }
        if (field == 13) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(495);
        }
        if (field == 14) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(430);
        }
        if (field == 15) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(365);
        }
        if (field == 16) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(300);
        }
        if (field == 17) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(235);
        }
        if (field == 18) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(170);
        }
        if (field == 19) {
            pionek.setLayoutX(14);
            pionek.setLayoutY(105);
        }
        if (field == 20) {
            pionek.setLayoutX(22);
            pionek.setLayoutY(14);
        }
        if (field == 21) {
            pionek.setLayoutX(107);
            pionek.setLayoutY(14);
        }
        if (field == 22) {
            pionek.setLayoutX(172);
            pionek.setLayoutY(14);
        }
        if (field == 23) {
            pionek.setLayoutX(237);
            pionek.setLayoutY(14);
        }
        if (field == 24) {
            pionek.setLayoutX(302);
            pionek.setLayoutY(14);
        }
        if (field == 25) {
            pionek.setLayoutX(367);
            pionek.setLayoutY(14);
        }
        if (field == 26) {
            pionek.setLayoutX(432);
            pionek.setLayoutY(14);
        }
        if (field == 27) {
            pionek.setLayoutX(497);
            pionek.setLayoutY(14);
        }
        if (field == 28) {
            pionek.setLayoutX(562);
            pionek.setLayoutY(14);
        }
        if (field == 29) {
            pionek.setLayoutX(627);
            pionek.setLayoutY(14);
        }
        if (field == 30) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(14);
        }
        if (field == 31) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(108);
        }
        if (field == 32) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(173);
        }
        if (field == 33) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(238);
        }
        if (field == 34) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(303);
        }
        if (field == 35) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(368);
        }
        if (field == 36) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(433);
        }
        if (field == 37) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(498);
        }
        if (field == 38) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(563);
        }
        if (field == 39) {
            pionek.setLayoutX(721);
            pionek.setLayoutY(628);
        }









//        for (int j = 0; j < iloscPrzesuniec; j++) {
//            x = pionek.getLayoutX();
//            y = pionek.getLayoutY();
//            przesuniecie = 65;
//            if (x == 721 && y == 721) {
//                pionek.setLayoutX(x - przesuniecie - 25);
//                pionek.setLayoutY(y);
//            }
//
//            for (int i = 631; i > 111; i-=65) {
//                if (x == i && y == 721) {
//                    pionek.setLayoutX(x - przesuniecie);
//                    pionek.setLayoutY(y);
//                }
//                x = pionek.getLayoutX();
//                y = pionek.getLayoutY();
//            }
//
//            if (x == 111 && y == 721) {
//                pionek.setLayoutX(0);
//                pionek.setLayoutY(740);
//            }
//
//            if (x == 0 && y == 740) {
//                pionek.setLayoutX(14);
//                pionek.setLayoutY(627);
//            }
//
//            for (int i = 627; i >= 173; i-=65) {
//                if (x == 14 && y == i) {
//                    pionek.setLayoutX(x);
//                    pionek.setLayoutY(y - przesuniecie);
//                }
//                x = pionek.getLayoutX();
//                y = pionek.getLayoutY();
//            }
//
//            if (x == 14 && y == 107) {
//                pionek.setLayoutX(22);
//                pionek.setLayoutY(14);
//            }
//
//            if (x == 22 && y == 14) {
//                pionek.setLayoutX(107);
//                pionek.setLayoutY(14);
//            }
//
//            for (int i = 22; i <= 566; i+=65) {
//                x = pionek.getLayoutX();
//                y = pionek.getLayoutY();
//                if (x == i && y == 14) {
//                    pionek.setLayoutX(x + przesuniecie);
//                    pionek.setLayoutY(y);
//                }
//            }
//
//            if (x == 631 && y == 14) {
//                pionek.setLayoutX(721);
//                pionek.setLayoutY(14);
//            }
//
//            if (x == 721 && y == 14) {
//                pionek.setLayoutX(721);
//                pionek.setLayoutY(108);
//            }
//
//            for (int i = 108; i <= 566; i+=65) {
//                x = pionek.getLayoutX();
//                y = pionek.getLayoutY();
//                if (x == 721 && y == i) {
//                    pionek.setLayoutX(x + przesuniecie);
//                    pionek.setLayoutY(y);
//                }
//            }
//
//            if (x == 721 && y == 627) {
//                pionek.setLayoutX(721);
//                pionek.setLayoutY(741);
//            }
//        }




//        for (int i = 0; i < iloscPrzesuniec; i++) {
//            x = pionek.getLayoutX();
//            y = pionek.getLayoutY();
//            przesuniecie = 65;
//
//            if(x == 721 && y == 721) {
//                przesuniecie += 25;
//            }
//            if (field == 0) {
//                pionek.setLayoutX(721);
//                pionek.setLayoutY(721);
//            }
//
//            if (field == 1) {
//                pionek.setLayoutX(x - przesuniecie - 25);
//                pionek.setLayoutY(y);
//            }
//
//            if (field == 2 ||
//                    field == 3 ||
//                    field == 4 ||
//                    field == 5 ||
//                    field == 6 ||
//                    field == 7 ||
//                    field == 8 ||
//                    field == 9) {
//                pionek.setLayoutX(x - przesuniecie);
//                pionek.setLayoutY(y);
//            }
//            if (field == 10) {
//                pionek.setLayoutX(0);
//                pionek.setLayoutY(740);
//            }
//
//            if (field == 11) {
//                pionek.setLayoutX(14);
//                pionek.setLayoutY(627);
//            }
//
//            if (field == 12 ||
//                    field == 13 ||
//                    field == 14 ||
//                    field == 15 ||
//                    field == 16 ||
//                    field == 17 ||
//                    field == 18 ||
//                    field == 19) {
//                pionek.setLayoutX(x);
//                pionek.setLayoutY(y - przesuniecie);
//            }
//
//            if (field == 20) {
//                pionek.setLayoutX(x);
//                pionek.setLayoutY(y - przesuniecie + 25);
//            }
//
//            if (field == 21 || field == 30) {
//                pionek.setLayoutX(x + przesuniecie + 25);
//                pionek.setLayoutY(y);
//            }
//
//            if (field == 22 ||
//                    field == 23 ||
//                    field == 24 ||
//                    field == 25 ||
//                    field == 26 ||
//                    field == 27 ||
//                    field == 28 ||
//                    field == 29) {
//                pionek.setLayoutX(x);
//                pionek.setLayoutY(y - przesuniecie);
//            }
//
//            if (field == 31) {
//                pionek.setLayoutX(x);
//                pionek.setLayoutY(y + przesuniecie - 25);
//            }
//
//            if (field == 32 ||
//                    field == 33 ||
//                    field == 34 ||
//                    field == 35 ||
//                    field == 36 ||
//                    field == 37 ||
//                    field == 38 ||
//                    field == 39) {
//                pionek.setLayoutX(x);
//                pionek.setLayoutY(y + przesuniecie);
//            }
////            TimeUnit.SECONDS.sleep(1);
////            wait(500);
////            Thread.sleep(500);
//        }
    }
}
