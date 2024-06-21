package datahw7;

public class driver {

    public static void main(String[] args) {

        try {

            System.out.println("Showing worst cases");
            worstcases();
            System.out.println("Showing best cases");
            bestcases();
            System.out.println("Showing average cases");
            averagecases();
            System.out.println("Showing element order change after sort");
            ordertrack();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * shows best case times and sortings
     * 
     * @throws Exception
     */

    public static void bestcases() throws Exception {
        mymap mapbest;
        mymap mapbestquick;
        mapbest = new mymap("a bb ccc dddd fffff hhhhhh ttttttt yyyyyyyy");
        mapbestquick = new mymap("a bbb cc dddd fffffff hhhhhh ttttt");

        long startTime, stopTime;
        selection sortdevice = new selection(mapbest);
        insertion sortdevice1 = new insertion(mapbest);
        bubble sortdevice2 = new bubble(mapbest);
        quick sortdevice3 = new quick(mapbestquick);
        mergesort sortdevice4 = new mergesort(mapbest);
        System.out.println("BEST CASES\n--------------------------");

        System.out.println("Original map");
        mapbest.print();

        startTime = System.nanoTime();

        sortdevice.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted best case selection: ");
        sortdevice.sortedmap.print();
        System.out.print("Time selection took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice1.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted best case  insertion: ");
        sortdevice1.sortedmap.print();
        System.out.print("Time insertion took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice2.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted best case  bubble: ");
        sortdevice2.sortedmap.print();
        System.out.print("Time bubble took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice4.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted best case merge: ");
        sortdevice4.sortedmap.print();
        System.out.print("Time merge took is  ");
        System.out.println((stopTime - startTime) + "\n");

        System.out.println("Original map for best case of quick sort");
        mapbestquick.print();
        startTime = System.nanoTime();
        sortdevice3.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted best case quick: ");
        sortdevice3.sortedmap.print();
        System.out.print("Time quick took is ");
        System.out.println((stopTime - startTime) + "\n");
        System.out.println("\n\n\n");

    }

    /**
     * shows worstcase time and sortings
     * 
     * @throws Exception
     */

    public static void worstcases() throws Exception {

        System.out.println("WORST CASES\n--------------------");
        mymap mapworst = new mymap("aaaaaaaa bbbbbbb cccccc ddddd ffff hhh tt y");
        selection sortdevice5 = new selection(mapworst);
        insertion sortdevice6 = new insertion(mapworst);
        bubble sortdevice7 = new bubble(mapworst);
        quick sortdevice8 = new quick(mapworst);
        mergesort sortdevice9 = new mergesort(mapworst);
        System.out.println("Original map");
        mapworst.print();
        long startTime, stopTime;
        startTime = System.nanoTime();
        sortdevice5.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted worst case selection: ");
        sortdevice5.sortedmap.print();
        System.out.print("Time selection took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice6.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted worst case  insertion: ");
        sortdevice6.sortedmap.print();
        System.out.print("Time insertion took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice7.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted worst case  bubble: ");
        sortdevice7.sortedmap.print();
        System.out.print("Time bubble took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice8.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted worst case quick: ");
        sortdevice8.sortedmap.print();
        System.out.print("Time quick took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice9.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted worst case merge: ");
        sortdevice9.sortedmap.print();
        System.out.print("Time merge took is  ");
        System.out.println((stopTime - startTime) + "\n");

        System.out.println("\n\n\n");

    }

    /**
     * shows average time and sortings
     * 
     * @throws Exception
     */

    public static void averagecases() throws Exception {
        long startTime, stopTime;
        System.out.println("AVERAGE CASES\n--------------------");
        mymap mapaverage = new mymap("aaaa bbb cccccccc d fffffff hh ttttt yyyyyy ");

        selection sortdevice10 = new selection(mapaverage);
        insertion sortdevice11 = new insertion(mapaverage);
        bubble sortdevice12 = new bubble(mapaverage);
        quick sortdevice13 = new quick(mapaverage);
        mergesort sortdevice14 = new mergesort(mapaverage);
        System.out.println("Original map");
        mapaverage.print();

        startTime = System.nanoTime();
        sortdevice10.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted average case selection: ");
        sortdevice10.sortedmap.print();
        System.out.print("Time selection took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice11.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted average case  insertion: ");
        sortdevice11.sortedmap.print();
        System.out.print("Time insertion took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice12.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted average case  bubble: ");
        sortdevice12.sortedmap.print();
        System.out.print("Time bubble took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice13.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted average case quick: ");
        sortdevice13.sortedmap.print();
        System.out.print("Time quick took is ");
        System.out.println((stopTime - startTime) + "\n");

        startTime = System.nanoTime();
        sortdevice14.sort();
        stopTime = System.nanoTime();
        System.out.println("Sorted average case merge: ");
        sortdevice14.sortedmap.print();
        System.out.print("Time merge took is  ");
        System.out.println((stopTime - startTime) + "\n");
        System.out.println("\n\n\n");

    }

    /**
     * has a map with multiple input with same count this shows if they are keeping
     * order
     * 
     * @throws Exception
     */

    public static void ordertrack() throws Exception {

        mymap mapsamecounts = new mymap("aaaa bbb cccc ddd ffffff hh ttttt yyyyyy ");

        selection sortdevice15 = new selection(mapsamecounts);
        insertion sortdevice16 = new insertion(mapsamecounts);
        bubble sortdevice17 = new bubble(mapsamecounts);
        quick sortdevice18 = new quick(mapsamecounts);
        mergesort sortdevice19 = new mergesort(mapsamecounts);

        System.out.println("What if some elements have same count\n--------------------");

        System.out.println("Original map");
        mapsamecounts.print();

        sortdevice15.sort();
        System.out.println("Sorted selection: ");
        sortdevice15.sortedmap.print();

        sortdevice16.sort();
        System.out.println("Sorted insertion: ");
        sortdevice16.sortedmap.print();

        sortdevice17.sort();
        System.out.println("Sorted Bubble: ");
        sortdevice17.sortedmap.print();

        sortdevice18.sort();
        System.out.println("Sorted quick: ");
        sortdevice18.sortedmap.print();

        sortdevice19.sort();
        System.out.println("Sorted merge: ");
        sortdevice19.sortedmap.print();

    }
}
