
public class ReverseVowels {

	public String reverseVowels(String s) {
        if(s==null) return null;
        String vowels = "aeouiAEOUI";
        char[] arr = s.toCharArray();
        int left=0; int right=arr.length-1;
        while(left<right){
            while(vowels.indexOf(arr[left])==-1 && left<right)left++;
            while(vowels.indexOf(arr[right])==-1 && left<right)right--;
            
            if(left<arr.length && right>=0){
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
	
	public static void main(String[] args) {
		ReverseVowels a = new ReverseVowels();
		System.out.println(a.reverseVowels("ai"));
	}
}
