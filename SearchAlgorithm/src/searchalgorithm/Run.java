package searchalgorithm;

import java.util.Scanner;

/**
 * this class is used to solve a problem with one of the search algorithms
 *
 * @author Ali ArjomandBigdeli
 * @since 12.27.2018
 */
public class Run {

    public static void main(String[] args) {
        Problem problem = new NavigationProblem();
        Search search;
        System.out.println("Pencarian Algoritma: ");
        System.out.println("1. BFS \n2. DFS\n3. Greedy best first search\n4. A*");
        System.out.print("Pilih algoritma yang diinginkan : ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("Graph(0) atau Tree(1): ");
        int graphChoice = scanner.nextInt();
        boolean isGraph = true;
        if (graphChoice == 1)
            isGraph = false;
        switch (choice) {
            case 1:
                search = new SearchBFS(isGraph);
                break;
            case 2:
                search = new SearchDFS(isGraph);
                break;
            case 3:
                search = new SearchGreedyBFS(isGraph);
                break;
            case 4:
                search = new SearchAStar(isGraph);
                break;
            default:
                search = new SearchAStar(isGraph);
                break;
        }
        search.setProblem(problem);
        search.execute();
        showResultOfSearch(search);
    }

    public static void showResultOfSearch(Search search) {
        System.out.println("Hasil dari pencarian " + search.getClass().getSimpleName() + ";");
        System.out.print("Jalur Terbaik: 0 ");
        for (int i = search.getPath().size() - 2; i >= 0; i--) {
            System.out.print(search.getPath().get(i) + " ");
        }
        System.out.println();
        System.out.println("Hasil Jarak : " + search.answer.pathCost);
        System.out.println("Total kota yang telah dikunjungi: " + search.getNodeSeen());
    }
}
