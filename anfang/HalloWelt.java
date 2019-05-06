package anfang;

public class HalloWelt {
	public static void main(String[] args) {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(5);
		stack.pop();
		stack.push(3);
		stack.push(6);
		stack.pop();

		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}

	 int[] unite(int[] a,int[] b){

		int i = 0,j = 0,k = 0;
		int[] result = new int[a.length+b.length];

		do {
			if (a[i]<b[j]){
				result[k] = a[i];
				i++;
				k++;
			}
			else {
				result[k] = b[j];
				k++;
				j++;
			}
		}
		while(i<a.length&&j<b.length);

		if (i<a.length){
			for (int l = k; l < result.length; l++) {
				result[k] = a[i];
				i++;
			}
		}

		if (j<b.length){
			for (int l = k; l < result.length; l++) {
				result[k] = b[j];
				j++;
			}
		}
		return result;
	}
}
