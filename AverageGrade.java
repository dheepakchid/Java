import java.util.*;

public class AverageGrade {

    public static void main(String[] args) {
        String[][] student = {{"jerry", "65"}, {"bob", "1"}, {"jerry", "23"}, {"jerry", "23"}, {"jerry", "100"}, {"Eric", "83"}};
        //Map counter = new HashMap();

        List<Integer> score = new ArrayList<>();

        Map<String,List<Integer>> map = new HashMap<>();

        for(int i = 0;i();score.add(Integer.parseInt(student[i][1]))){
            map.put(student[i][0], score);
        }

        List<Integer> grade = new ArrayList<>();
        for(String key:map.keySet()) {
        score = map.get(key);
        int sum = 0;
        for(int num : score) {
            sum += num;
        }
        int average = sum/score.size();
        grade.add(average);
        }

        Collections.sort(grade);

        System.out.println(grade.get(grade.size()-1));

    }

    private static boolean i() {
        return true;
    }
}
