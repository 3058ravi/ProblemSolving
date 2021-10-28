package graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args){
        String start= "hot", end="dog";
        List<String> wordList= new ArrayList<String>(Arrays.asList("hot","dog"));
        System.out.println(ladderLength(start,end,wordList));
    }

    public static int ladderLength(String start, String end, List<String> wordList){
        Set<String> set= new HashSet<>();
        boolean isPresent=false;
        for(int i=0; i<wordList.size(); i++){
            if(wordList.get(i).equals(end))
                isPresent=true;
            set.add(wordList.get(i));
        }

        if(!isPresent)
            return 0;

        Queue<String> q= new LinkedList<>();
         q.add(start);

         int count=0;
         while(!q.isEmpty()){

             int qSize=q.size();
             while(qSize>0){
                 String curr= q.peek();
                 q.poll();
                 --qSize;
                 for(int i=0; i<curr.length(); i++){
                     char[] temp=curr.toCharArray();
                     for(char c='a';c<='z';c++){
                         temp[i]=c;
                         String tempString=String.valueOf(temp);
                         if(end.equals(tempString))
                             return count+1;
                         if( !tempString.equals(curr) && set.contains(tempString)){
                             q.add(tempString);
                             set.remove(tempString);
                         }
                         temp=curr.toCharArray();
                     }

                 }

             }
             count++;
         }
         return  0;
    }
}
