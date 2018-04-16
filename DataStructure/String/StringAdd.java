public class StringAdd{
    public static String stringAdd(String a, String b) {
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int up = 0;
        int remain;
        StringBuilder sb = new StringBuilder();
        while(indexA >= 0 && indexB >= 0) {
            int sum = (a.charAt(indexA) - '0') + (b.charAt(indexB) - '0') + up;
            System.out.println(sum);
            remain = sum % 10;
            up = sum / 10;
            sb.append(remain);
            indexA--;
            indexB--;
            
        }
        while(indexA >= 0) {
            if(up > 0) {
                int sum = up + 
                up = sum / 10;
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("ab\n\\cde\125");
        //String a = "1234";
        //String b = "2368"; 
        //String result = stringAdd(a, b);
        //System.out.println(result);
    }
}