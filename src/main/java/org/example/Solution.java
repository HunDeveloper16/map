package org.example;
import java.util.*;

class Solution {

    public static void main(String[] args) {

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> id_map = new HashMap<>();

        for(String id : id_list){
            id_map.put(id,0);
        }

        for(String repo : report){
            String[] split = repo.split(" ");
            String reporter = split[0];
            String reported = split[1];

            List<String> list = new ArrayList<>();

            if(!map.containsKey(reported)){
                map.put(reported, list);
            }

            if(!map.get(reported).contains(reporter)){
                List<String> tempList = map.get(reported);
                tempList.add(reporter);
                map.replace(reported, tempList);
            }
        }

        for(String key : map.keySet()){
            if(map.get(key).size() >= k){
                for(String a : map.get(key)){
                    int value = id_map.get(a)+1;
                    id_map.replace(a,value);
                }
            }
        }

        System.out.println(id_map);

        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++){
            int value = id_map.get(id_list[i]);
            answer[i]=value;
        }

        for(Integer a : answer){
            System.out.println(a);
        }

    }

}