import model.ClassObject;

public class Main {

    public static void main(String[] args) {

        Executor executor = new Executor();
        executor.execute("-c=Pies -f=private:int:wiek -f=private:String:imie -na -s -g -a -i");
    }
}
