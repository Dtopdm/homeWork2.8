package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String[]> dictionary = new HashMap<>();
        HashMap<String, String[]> largeDictionary = new HashMap<>();

        dictionary.put("человек", new String[]{"личность", "персона", "индивидум"});
        dictionary.put("страна", new String[]{"родина", "республика", "государство"});
        dictionary.put("большой", new String[]{"крупный", "огромный", "массивный"});
        dictionary.put("красивый", new String[]{"симпатичный", "привлекательный", "великолепный"});

        for (Map.Entry<String, String[]> item : dictionary.entrySet()) {
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));
            Set<Map.Entry<String, String[]>> entries = dictionary.entrySet();
            Iterator iterator = entries.iterator();
            while (iterator.hasNext()) {
                for (Map.Entry<String, String[]> entry : entries) {
                    String key = iterator.next().toString();
                    String[] value = entry.getValue();
                    for (int i = 0; i < value.length; i++) {
                        String newKey = value[i];
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.addAll(Arrays.asList(value));
                        arrayList.remove(newKey);
                        arrayList.add(key);
                        String[] value2 = new String[arrayList.size()];
                        value2 = arrayList.toArray(value2);
                        System.out.println(newKey + " " + Arrays.toString(entry.getValue()));
                        largeDictionary.put(newKey, value2);
                    }
                }
            }

            while (true) {
                System.out.println("\n Введите слово из словаря: ");
                String word = scanner.nextLine();
                String[] words = word.split(" ");
                for (String a : words) {
                    if (largeDictionary.get(a) != null) {
                        String[] synonyms = largeDictionary.get(a);
                        Random r = new Random();
                        int x = r.nextInt(synonyms.length);
                        System.out.printf(synonyms[x] + " ");
                    } else {
                        System.out.println("Такого слова нет в словаре! ");
                    }
                }

            }
        }

    }
}

