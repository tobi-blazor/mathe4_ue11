public class Main {
    public static void main(String[] args) {
        //ErweiterterEuklid.calc(12, 8);
        //System.out.println(nextPrimzahl(10,10));
        primfaktorzerlegung(6375 );
        primfaktorzerlegung(2574 );

    }

    public static void primfaktorzerlegung(int zahl) {
        int start = 2;
        while (zahl > 1) {
            int prim = nextPrimzahl(start, zahl);
            while (zahl % prim == 0) {
                System.out.print(prim + " ");
                zahl /= prim;
            }
            start = prim + 1;
        }
        System.out.println();
    }
    private static int nextPrimzahl(int start, int end) {
        int zahl = start;
        boolean primzahlGefunden = false;
        while(zahl <= end && !primzahlGefunden ) {
            primzahlGefunden = true;
            for(int i = 2; i<zahl; i++) {
                if(zahl%i == 0) {
                    primzahlGefunden = false;
                    break;
                }
            }
            if (zahl <= 1) {
                primzahlGefunden = false;
            }
            if(!primzahlGefunden) {
                zahl++;
            }

        }
        return primzahlGefunden ? zahl : -1;
    }
}

