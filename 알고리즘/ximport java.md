```java
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<Integer>();
        
        
        Num1 ppl1 = new Num1();
        Num2 ppl2 = new Num2();
        Num3 ppl3 = new Num3();

        int maxIndex = 0;
        int sameCount = 0;
        AnswerPattern[] abs = {ppl1,ppl2,ppl3};
        
        int[] count = new int[abs.length];

        for(int i=0; i<count.length;i++){
            count[i] = abs[i].Answer(answers);
        }
        for(int i=0; i<count.length-i;i++){
           int temp;
            if(count[i]>count[i+1]){
                temp=count[i];
                count[i]=count[i+1];
                count[i+1]=temp;
            }
        }

        for(int i=0; i<count.length;i++){
            for(int j=0; j<count.length;j++){
                if(i!=j){
                    if(count[i]<count[j]){
                        maxIndex = j;
                    }else if(count[i]==count[j]){
                        sameCount++;
                        ans.add(i);
                        ans.add(j);
                    }

                }
                
            }
            
        }
        
        switch (sameCount) {
            case 0:
                ans.add(maxIndex);
                answer = ans.toArray(a);
                break;
            
        
            default:

                break;
        }

        return answer;

    }

    public interface AnswerPattern {
        public int Answer(int[] answers);

    }

    public class Num1 implements AnswerPattern {
        int[] sample = { 1, 2, 3, 4, 5 };

        @Override
        public int Answer(int[] answers) {

            int count = 0;
            boolean q = true;
            int index = 0;

            while (q) {

                switch (index % 5) {
                    case 0:
                        if (answers[index++] == sample[0]) {
                            count++;

                        }
                        break;
                    case 1:
                        if (answers[index++] == sample[1]) {
                            count++;
                        }
                        break;
                    case 2:
                        if (answers[index++] == sample[2]) {
                            count++;
                        }

                        break;
                    case 3:
                        if (answers[index++] == sample[3]) {
                            count++;
                        }

                        break;
                    case 4:
                        if (answers[index++] == sample[4]) {
                            count++;
                        }
                        break;

                    default:
                        break;
                }
                if (answers.length == index) {
                    q = false;
                }

            }

            return count;
        }
    }

    public class Num2 implements AnswerPattern {
        int[] sample = { 1, 2, 3, 4, 5 };

        @Override
        public int Answer(int[] answers) {
            int count = 0;
            boolean q = true;
            int index = 0;

            while (q) {

                switch (index % 8) {
                    case 1:
                        if (answers[index++] == sample[0]) {
                            count++;

                        }
                        break;
                    case 3:
                        if (answers[index++] == sample[2]) {
                            count++;
                        }
                        break;
                    case 5:
                        if (answers[index++] == sample[3]) {
                            count++;
                        }

                        break;
                    case 7:
                        if (answers[index++] == sample[4]) {
                            count++;
                        }

                        break;

                    default:
                        if (answers[index++] == 2) {
                            count++;
                        }
                        break;
                }
                if (answers.length == index) {
                    q = false;
                }

            }
            return count;
        }
    }

    public class Num3 implements AnswerPattern {
        int[] sample = { 1, 2, 3, 4, 5 };

        @Override
        public int Answer(int[] answers) {
            int count = 0;
            boolean q = true;
            int index = 0;

            while (q) {

                int indexCase=0;
                if(index%2==1){
                    indexCase = index%10;
                }else{
                    indexCase = (index+1)%10;
                }

                switch (indexCase) {
                    case 1:
                        if (answers[index++] == sample[1]) {
                            count++;

                        }
                        break;
                    case 2:
                        if (answers[index++] == sample[2]) {
                            count++;
                        }
                        break;
                    case 3:
                        if (answers[index++] == sample[3]) {
                            count++;
                        }

                        break;
                    case 4:
                        if (answers[index++] == sample[4]) {
                            count++;
                        }

                        break;
                    case 5:
                        if (answers[index++] == sample[5]) {
                            count++;
                        }
                        break;

                    default:
                        break;
                }
                if (answers.length == index) {
                    q = false;
                }

            }
            return count;
        }
    }

}
```

