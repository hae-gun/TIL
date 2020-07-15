public class Main_LinkedList{

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        
        numbers.addFirst(40);
        numbers.addLast(15);
        numbers.addLast(20);
        numbers.addLast(30);

        LinkedList.ListIterator li = numbers.listIterator();
        
        while(li.hasNext()){
            if((int)li.next()==15)
                li.remove();
        }
        
        System.out.println(numbers);
    }
}

