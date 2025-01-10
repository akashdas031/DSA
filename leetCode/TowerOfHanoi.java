package DSA.leetCode;

public class TowerOfHanoi {
    public static void Toh(int n,char source,char helper,char destination){
        if(n==1){
            System.out.println("Moving Disk "+n+" from : "+source+"  to :"+destination);
            return;
        }
        Toh(n-1,source,destination,helper);
        System.out.println("Moving Disk "+n+" from :"+source+" to : "+destination);
        Toh(n-1, helper, source, destination);
    }
    public static void main(String[] args) {
        Toh(3, 'A', 'B', 'C');
    }
}
