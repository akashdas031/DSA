package DSA.leetCode;



public class MinimizeMaxDistanceBetweenGasStation {
   
    //Bruteforce approach time complexity O(k*n)+O(n)
    public static double minimizeMaxDistance(int[] arr,int k){

        int n=arr.length;
        int[] howMany=new int[n-1];
        for(int gasStation=1;gasStation<=k;gasStation++){
            double maxSection=-1;
            int maxIndex=-1;
            for(int i=0;i<n-1;i++){
                double diff=arr[i+1]-arr[i];
                double section=diff/(double)(howMany[i]+1);
                if(section>maxSection){
                    maxSection=section;
                    maxIndex=i;
                }
            }
            howMany[maxIndex]++;
        }
        double maxAns=-1;
            for(int i=0;i<n-1;i++){
                double diff=arr[i+1]-arr[i];
                double section=diff/(double)(howMany[i]+1);
                maxAns=Math.max(maxAns,section);
            }
            return maxAns;
    }
    //optimal approach using binary search
    public static int numberOfGasStationRequired(int[] arr,double distance){

         int n=arr.length;
        int totalGasStationRequired=0;
        for (int i = 1; i < n; i++) {
            int requiredGasStations=(int)((arr[i]-arr[i-1])/distance);
            if((arr[i]-arr[i-1])==(distance*requiredGasStations)){
                requiredGasStations--;
            }
            totalGasStationRequired+=requiredGasStations;
        }
        return totalGasStationRequired;
    }
    public static double placeGasStations(int[] arr,int k){
        int n=arr.length;
        double low=0;
        double high=0;
        for (int i = 0; i < n-1; i++) {
            high=Math.max(high,(double)arr[i+1]-arr[i]);
        }
        double range=1e-6;
        while(high-low>range){
            double mid=(low+high)/(2.0);
            int count=numberOfGasStationRequired(arr, mid);
            if(count>k){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }
        public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=4;
        System.out.println(placeGasStations(arr, k));
    }
}

