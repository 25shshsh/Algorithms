import java.util.Arrays;
import java.util.stream.IntStream;

public class ReferenceTypeArray {
    static int [] profits = {1,2,3,5,8}; // 프로젝트 이익
    static int [] capital = {0,1,2,3,4}; // 프로젝트 제한 자본


    static class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

        public static void main(String[] args) {
            Project[] projects = new Project[profits.length];

            for(int i = 0; i < profits.length; i++) {
                projects[i] = new Project(profits[i],capital[i]);
            }
            Arrays.sort(projects);
            printArr(projects);
        }

        static void printArr (Project[] array) {
            IntStream.rangeClosed(0,profits.length-1).forEach(i -> {
                System.out.println(array[i].profit + "," + array[i].capital + " ");
            });
        }
}
