import org.junit.Test;
import static org.junit.Assert.*;

public class EllysThreePrimesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] sums = new int[] {19, 12, 15, 11, 14};
		assertArrayEquals(new int[] {20533, 87119, 44987 }, new EllysThreePrimes().getPrimes(sums));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] sums = new int[] {22, 19, 3, 8, 23};
		assertArrayEquals(new int[] { }, new EllysThreePrimes().getPrimes(sums));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] sums = new int[] {13, 17, 0, 25, 20};
		assertArrayEquals(new int[] {27011, 99083, 99089 }, new EllysThreePrimes().getPrimes(sums));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] sums = new int[] {11, 12, 13, 14, 15};
		assertArrayEquals(new int[] {47221, 23789, 94421 }, new EllysThreePrimes().getPrimes(sums));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] sums = new int[] {14, 27, 6, 12, 15};
		assertArrayEquals(new int[] { }, new EllysThreePrimes().getPrimes(sums));
	}
}
