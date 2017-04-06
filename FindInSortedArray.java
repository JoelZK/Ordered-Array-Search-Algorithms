import java.util.Arrays;
import java.util.Random;
class FindInSortedArray {
	public static void main(String[] args) {
		Random r=new Random();
		//Create a int array with 100 random integer elements for testing
		int[] li=new int[100];
		for(int i=0;i<100;i++){
			li[i]=r.nextInt(100);
		}
		//Gathering an random integer within 0-99 as the searching target
		int target=r.nextInt(99);
		
		Arrays.sort(li);
		
		for(int i=0;i<li.length;i++){
			System.out.print(li[i]+"\t");
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		
		//Using different algorithem methods to do the same search job.
		nornalSearch(li, target);
		binarySearch(li, target);
		valueDifferSearch(li, target);
	}
	
	//Using binary search algorithm
	static void binarySearch(int[] list, int target){
		int compare=0;
		//Define lower-bound and upper-bound
		int l_index=0;				//lower-bound
		int h_index=list.length-1;	//upper-bound
		int index=-1;
		
		while(l_index<=h_index && l_index<=list.length-1 && h_index<=list.length-1){
			index=(l_index+h_index)>>1;
			if(list[index]==target){
				compare++;
				break;
			}else if(list[index]>target){
				compare+=2;
				h_index=index-1;
			}else{
				compare+=2;
				l_index=index+1;
			}
		}
		
		System.out.println(list[index]==target?"The index of target number:"+target+"is"+index+".":"Can't find target number:"+target+"...");
		System.out.println("It has compared "+compare+" times in total.");
		System.out.println();
	}
	
	//Using iterate search algorithm
	static void normalSearch(int[] list, int target){
		int compare=0;
		int index=-1;
		for(int i=0;i<list.length;i++){
			if(list[i]==target){
				index=i;
				compare++;
				break;
			}
			compare++;
		}
		System.out.println(list[index]==target?"The index of target number:"+target+"is"+index+".":"Can't find target number:"+target+"...");
		System.out.println("It has compared "+compare+" times in total.");
		System.out.println();
	}
	
	//Using value different locating search algorithm
	static void valueDifferSearch(int[] list, int target){
		int compare=0;
		int result=-1;
		int max_index=list.length-1;
		int min_index=0;
		int gap;
		int index;
		
		//Calcuate the average different of the value of elements
		gap=(list[list.length-1]-list[0])/list.length;
		//Set the different as 1 if it less than 1 to avoid it becames to 0 because of the fonce covert from double to integer)
		gap=gap>1?gap:1;
		compare++;
		//Locate the position according to the amount of differents that the target integer has contented. 
		index=target/gap;
		
		if(list[index]==target){
			compare++;
			result=index;
		}else{
			//Determining wither the current location value is lager than the target or not.
			boolean isBigger=list[index]>target;
			compare++;
			//According to the result of the determining to decide iterating forward or backward from current index.
			for(;isBigger?index>=0:index<list.length;){
				index=isBigger?index-1:index+1;
				if(list[index]==target || (isBigger?list[index]<target:list[index]>target)){
					compare++;
					result=list[index]==target?index:-1;
					break;
				}
				compare++;
			}
		}
		System.out.println(list[index]==target?"The index of target number:"+target+"is"+index+".":"Can't find target number:"+target+"...");
		System.out.println("It has compared "+compare+" times in total.");
		System.out.println();
	}
}
