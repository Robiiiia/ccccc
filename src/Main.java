import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> students = new HashMap<>();

        students.put("Aida", 85);
        students.put("Azat", 92);
        students.put("Dana", 77);

        System.out.println("Map: " + students);
        System.out.println("Size: " + students.size());

        //2
        System.out.println("Aida score: " + students.get("Aida"));
        System.out.println("Mira score: " + students.get("Mira"));

        if (students.containsKey("Mira")) {
            System.out.println("Mira found: " + students.get("Mira"));
        } else {
            System.out.println("Mira not found");
        }

        //3
        Integer oldValue = students.put("Dana", 80);
        System.out.println("Old Dana score: " + oldValue);
        System.out.println("Updated map: " + students);

        //4
        Integer removed = students.remove("Azat");

        if (removed != null) {
            System.out.println("Azat removed successfully");
        } else {
            System.out.println("Azat not found");
        }
        Integer removed2 = students.remove("NonExisting");

        if (removed2 != null) {
            System.out.println("NonExisting removed");
        } else {
            System.out.println("NonExisting not found");
        }

        //5
        System.out.println("Is empty before clear: " + students.isEmpty());
        students.clear(); // clear() удаляет все элементы

        System.out.println("Is empty after clear: " + students.isEmpty());
        students.put("Aida", 85);
        students.put("Dana", 80);
        students.put("Mira", 88);

        //6
        int score1 = students.getOrDefault("Mira", -1);
        int score2 = students.getOrDefault("Azat", -1);

        if (score1 == -1) {
            System.out.println("Mira: Not found");
        } else {
            System.out.println("Mira score: " + score1);
        }

        if (score2 == -1) {
            System.out.println("Azat: Not found");
        } else {
            System.out.println("Azat score: " + score2);
        }

        //7
        students.putIfAbsent("Aida", 90);
        students.putIfAbsent("Arman", 91);
        System.out.println("After putIfAbsent: " + students);

        //8
        boolean replaced = students.replace("Aida", 85, 86);
        System.out.println("Conditional replace success: " + replaced);
        students.replace("Aida", 91); //заменв

        Integer replaceMissing = students.replace("NonExisting", 100);

        System.out.println("After replace operations: " + students);

        //9
        System.out.println("All keys:");
        for (String key : students.keySet()) {
            System.out.println(key);
        }

        System.out.println("All values:");
        for (Integer value : students.values()) {
            System.out.println(value);
        }

        System.out.println("All entries:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

//10
        int count = 0;

        for (Integer value : students.values()) {
            if (value >= 80) {
                count++;
            }
        }

        System.out.println("Students with score >= 80: " + count);


        //11

        int maxScore = Integer.MIN_VALUE;
        String topStudent = "";

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        System.out.println("Highest score: " + maxScore);
        System.out.println("Top student: " + topStudent);

// 12
        System.out.println("12. Word Frequency Counter");

        String text = "Java is fun and Java is powerful and fun";
        String[] words = text.toLowerCase().split(" ");

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        System.out.println(wordMap);
        System.out.println();


        //13
        System.out.println("13. Character Frequency");

        String str = "Mississippi";
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(charMap);

        char mostChar = ' ';
        int max = 0;

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostChar = entry.getKey();
            }
        }
        System.out.println("Most frequent: " + mostChar);
        System.out.println();


        //14
        System.out.println("14. Group Words by Length");

        String[] arr = {"hi","book","java","sun","loop","map"};
        HashMap<Integer, ArrayList<String>> lengthMap = new HashMap<>();

        for (String w : arr) {
            lengthMap.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
        System.out.println(lengthMap);
        System.out.println();


        //15
        System.out.println("15. First Non-Repeating Character");
        String input = "swiss";
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        Character firstUnique = null;

        for (char c : input.toCharArray()) {
            if (freq.get(c) == 1) {
                firstUnique = c;
                break;
            }
        }
        System.out.println(firstUnique != null ? firstUnique : "None");
        System.out.println();


        //16
        System.out.println("16. Two-Sum");

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                System.out.println("Indices: " + indexMap.get(complement) + ", " + i);
                break;
            }

            indexMap.put(nums[i], i);
        }
        System.out.println();


        //17
        System.out.println("17. Detect Duplicates");

        String[] fruits = {"apple","banana","apple","orange","banana","kiwi"};
        HashMap<String, Integer> fruitMap = new HashMap<>();

        for (String f : fruits) {
            fruitMap.put(f, fruitMap.getOrDefault(f, 0) + 1);
        }

        System.out.println("Unique:");
        for (Map.Entry<String, Integer> e : fruitMap.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println(e.getKey());
            }
        }
        System.out.println("Duplicates:");
        for (Map.Entry<String, Integer> e : fruitMap.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println(e.getKey() + " = " + e.getValue());
            }
        }

        System.out.println();


        //18
        System.out.println("18. Equals & Order-Insensitivity");

        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("A",1);
        map1.put("B",2);

        HashMap<String,Integer> map2 = new HashMap<>();
        map2.put("B",2);
        map2.put("A",1);

        System.out.println("Equals: " + map1.equals(map2));
        System.out.println("HashCodes: " + map1.hashCode() + " , " + map2.hashCode());
        System.out.println();


        //19
        System.out.println("19. Remove Students < 60");

        HashMap<String,Integer> stud = new HashMap<>();
        stud.put("Aida",85);
        stud.put("Azat",55);
        stud.put("Dana",40);
        stud.put("Mira",90);

        Iterator<Map.Entry<String,Integer>> iterator = stud.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry = iterator.next();
            if (entry.getValue() < 60) {
                iterator.remove();
            }
        }

        System.out.println(stud);
        System.out.println();

        //20
        System.out.println("20. Merge Scores");

        HashMap<String,Integer> scores1 = new HashMap<>();
        scores1.put("Aida",40);
        scores1.put("Azat",35);
        scores1.put("Dana",50);

        HashMap<String,Integer> scores2 = new HashMap<>();
        scores2.put("Azat",10);
        scores2.put("Dana",5);
        scores2.put("Mira",45);

        for (Map.Entry<String,Integer> entry : scores2.entrySet()) {
            scores1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println(scores1);
        System.out.println();

        //21
        System.out.println("21. Invert Map");

        HashMap<String,Integer> studentScores = new HashMap<>();
        studentScores.put("Aida",90);
        studentScores.put("Azat",85);
        studentScores.put("Dana",90);
        studentScores.put("Mira",85);

        HashMap<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String,Integer> entry : studentScores.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }

        System.out.println(inverted);
        System.out.println();


        //22
        System.out.println("22. Top-2 Frequent Words");

        HashMap<String,Integer> frequency = new HashMap<>();

        for (String w : words) {
            frequency.put(w, frequency.getOrDefault(w,0) + 1);
        }
        List<Map.Entry<String,Integer>> list =
                new ArrayList<>(frequency.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        System.out.println("Top 1: " + list.get(0));
        System.out.println("Top 2: " + list.get(1));
    }
}

