package ArrayPass;

public class A {
	private int roll;
	private String name;
	private int[] arr;
	int s;
	public A(int roll, String name, int[] arr) {
		this.roll = roll;
		this.name = name;
		this.arr = arr;
		s = arr.length;
	}
	 
	public void show() {
		System.out.println("Name is: "+name);
		System.out.println("Roll is: "+roll);
		System.out.println("Array value: ");
		for(int i=0; i<s; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
