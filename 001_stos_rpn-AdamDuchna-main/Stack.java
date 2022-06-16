public class Stack {
    String[] arr;
    int top;
    int size;

    Stack(){
        arr = new String[1];
        top = -1;
        size = 1;
    }
    public void push(String text){
        String[] copied = new String[++size];
        System.arraycopy(arr,0,copied,0,size-1);
        arr = copied;
        arr[++top]= text;
    }

    public String pop(){
        if(top != -1) {
            String popped = peek();
            String[] copied = new String[--size];
            System.arraycopy(arr, 0, copied, 0, size - 1);
            top--;
            arr = copied;
            return popped;
        }
        else{
            return "isEmpty";
        }
    }
    public int size(){
        return size;
    }

    public String peek(){
        if(top != -1){
            return arr[top];
        }
        else{
           return "isEmpty";
        }
    }

}
