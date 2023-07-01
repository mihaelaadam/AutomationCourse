package course.course03_04;

public class Draw {

    public static void main(String[] args) {
        if (args.length == 1) {
            drawFullShape(Integer.parseInt(args[0]));
        } else if (args.length == 2) {
            drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            System.out.println("Please add 1 or 2 arguments only");
        }
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawShapeOutline(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawShapeCorners(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawFullTriangle(Integer.parseInt(args[1]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawTriangleOutline(Integer.parseInt(args[1]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawTriangleCorners(Integer.parseInt(args[1]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawFullSquare(Integer.parseInt(args[0]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawEmptySquare(Integer.parseInt(args[0]));
        System.out.println();
        System.out.println("--------");
        System.out.println();
        drawSquareCorners(Integer.parseInt(args[0]));
    }
    // method 1 for drawShapeOutline
//    private static void drawShapeOutline(int width, int height) {
//        printShapeName("Empty rectangle");
//        printEntireLine(height);
//        System.out.println();
//        for (int i = 1; i < width - 1; i++) {
//            System.out.print("*");
//            for (int j = 1; j < height - 1; j++) {
//                System.out.print(" ");
//            }
//            System.out.println("*");
//        }
//        printEntireLine(height);
//    }

    //    method 2 for drawShapeOutline
    private static void drawShapeOutline(int width, int height) {
        printShapeName("Empty rectangle:");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == (width - 1) || j == 0 || j == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawFullShape(int squareSide) {
        printShapeName("Square: ");
        drawFullShape(squareSide, squareSide);
        // duplicate code from drawShape with 2 parameters
//        for (int i = 0; i < squareSide; i++) {
//            printEntireLine(squareSide);
//            System.out.println();
//        }
    }

    private static void drawFullShape(int width, int height) {
        printShapeName("Rectangle: ");
        for (int i = 0; i < width; i++) {
            printEntireLine(height);
            System.out.println();
        }
//        printEntireLine();
//        String message = "2 parameters method";
//        printEntireLine(width, message + " with first parameter ar int");
//        printEntireLine(width, message + " with first parameter as String");
    }

    private static void printShapeName(String shapeName) {
        System.out.println();
        System.out.println(shapeName);
        System.out.println();
    }

    private static void printEntireLine(int numarColoane) {
        for (int j = 0; j < numarColoane; j++) {
            System.out.print("*");
        }
    }

    private static void printEntireLine(int numarColoane, String message) {
        for (int j = 0; j < numarColoane; j++) {
            System.out.print("*");
        }
        System.out.println(message);
    }

    private static void printEntireLine(String numarColoane, String message) {
        for (int j = 0; j < Integer.parseInt(numarColoane); j++) {
            System.out.print("*");
        }
        System.out.println(message);
    }

    private static void printEntireLine() {
        System.out.print("**********");
    }
    private static void drawShapeCorners(int width, int height) {
        printShapeName("Corners of the rectangle:");
        for (int i = 0; i < (width - 1); i++) {
            for (int j = 0; j < (height - 1); j++) {
                if ((i == 0 && j == 0) || (i == (width - 2) && j == (height - 2)) || (i == 0 && j == (height - 2)) || (i == (width - 2) && j == 0)) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static void drawFullTriangle(int height) {
        printShapeName("Triangle:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    private static void drawTriangleOutline(int height) {
        printShapeName("Empty triangle:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawTriangleCorners(int height) {
        printShapeName("Corners of the triangle:");
        for (int i = 0; i < (height - 1); i++) {
            for (int j = 0; j <= i; j++) {
                if ((i == 0 && j == 0) || (i == (height - 2) && j == 0) || (i == (height - 2) && j == (height - 2))) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void drawFullSquare(int width) {
        printShapeName("Square: ");
        for (int i = 0; i < width; i++) {
            printEntireLine(width);
            System.out.println();
        }
    }
    private static void drawEmptySquare(int width) {
        printShapeName("Empty square: ");
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == (width - 1)) {
                for (int j = 0; j < width; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int j = 0; j < width - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawSquareCorners(int width) {
        printShapeName("Corners of the square:");
        for (int i = 0; i < (width - 1); i++) {
            for (int j = 0; j < (width - 1); j++) {
                if ((i == 0 && j == 0) || (i == (width - 2) && j == (width - 2)) || (i == 0 && j == (width - 2)) || (i == (width - 2) && j == 0)) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}