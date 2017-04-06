import java.util.Arrays;
import java.util.Random;
class FindInSortedArray {
	public static void main(String[] args) {
		Random r=new Random();
		
		int[] li=new int[100];
		for(int i=0;i<100;i++){
			li[i]=r.nextInt(100);
		}
		
		//int target=li[r.nextInt(99)];
		int target=r.nextInt(99);
		
		Arrays.sort(li);
		
		for(int i=0;i<li.length;i++){
			System.out.print(li[i]+"\t");
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		sortHalfDivionFind(li, target);
		sortDifferFind(li,target);
	}
	
	static void sortHalfDivionFind(int[] list, int target){
		int compare=0;
		//定义上下限
		int l_index=0;				//下限
		int h_index=list.length-1;	//上限
		//声明中间索引号
		int index=-1;
		
		while(l_index<=h_index && l_index<=list.length-1 && h_index<=list.length-1){
			index=(l_index+h_index)>>1;
			if(list[index]==target){
				compare++;
				break;
			}else if(list[index]>target){
				compare++;
				h_index=index-1;
			}else{
				compare++;
				l_index=index+1;
			}
			//compare++;
		}
		
		System.out.println(list[index]==target?target+"在第"+(index+1)+"个":"没找到"+target+"...");
		System.out.println("比较了"+compare+"次。");
		System.out.println();
	}
	
	static void sortNormalFind(int[] list, int target){
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
		System.out.println(index!=-1?target+"在第"+(index+1)+"个":"没找到"+target+"...");
		System.out.println("比较了"+compare+"次。");
		System.out.println();
	}
	
	static void sortHyperFind(int[] list, int target){
		int compare=0;
		int result=-1;
		int index=-1;
		int amount=list.length;
		int max=list[amount-1];
		int min=list[0];
		int gap=(max-min)/amount>1?(max-min)/amount:1;
		int diff=target%gap;
		index=(diff>(gap>>1))?(target/gap)+1:(target/gap);
		compare++;
		int _index=-1;
		if(target==list[index]){
			result=index;
			compare++;
		}else{
			boolean isBigger=target<list[index];
			compare+=2;
			for(int i=isBigger?0:index;i<(isBigger?index:amount);i++){
				if(list[i]==target){
					compare++;
					result=i;
					break;
				}
				compare++;
			}
			
		}
		System.out.println(result!=-1?target+"在第"+(result+1)+"个":"没找到"+target+"...");
		System.out.println("比较了"+compare+"次。");
		System.out.println();
	}
	
	static void sortDifferFind(int[] list, int target){
		int compare=0;
		int result=-1;
		int max_index=list.length-1;
		int min_index=0;
		int gap;
		int index;
		
		gap=(list[max_index]-list[min_index])/(max_index-min_index+1);
		gap=gap>1?gap:1;
		compare++;
		index=target/gap;
		
		if(list[index]==target){
			compare++;
			result=index;
		}else{
			boolean isBigger=list[index]>target;
			compare++;
			//boolean keepLoop=;
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
		System.out.println(result!=-1?target+"在第"+(result+1)+"个":"没找到"+target+"...");
		System.out.println("比较了"+compare+"次。");
		System.out.println();
	}
}