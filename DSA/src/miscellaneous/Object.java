package miscellaneous;

public class Object {
	
	public boolean isPrime(int n) {
		if(n==0 || n==1) return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public void seiveOfEratosthenes(int n) {
		boolean [] primeArray = new boolean [n+1];
		primeArray[0] = true;
		primeArray[1] = true;
		for(int i=2;i*i<=n;i++) {
			if(!primeArray[i]) {
				for(int j=i*i;j<=n;j+=i) {
					primeArray[j] = true;
				}
			}
		}
		for(int i=2;i<=n;i++) {
			if(!primeArray[i]) {
				System.out.print(i+" ");
			}
		}
	}
	
}
