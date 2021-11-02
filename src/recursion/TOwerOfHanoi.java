package recursion;

public class TOwerOfHanoi {
    public static void main(String[] args){
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'B', 'C');
    }

    public static void towerOfHanoi(int n, char source,char aux, char destination){
        if(n==1){
            System.out.println("Moving disk 1 from "+source+" to "+destination);
            return;
        }

        towerOfHanoi(n-1, source, destination,aux);
        System.out.println("Moving disk "+n+" from "+source+" to "+destination);
        towerOfHanoi(n-1, aux, source,destination);
    }
}
