class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int j = 0;
        int i = 0;
        int count = 0;
        while (j < s.length()) {
            while (j < s.length() && !(set.contains(s.charAt(j)))) {
                set.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j - i);
            set.remove(s.charAt(i));
            i++;
        }
        return max;
    }
}

//        HashSet<Character> h=new HashSet<>();
//        int j=0;
//        int i=0;
//        int max=0;
//        while(j<s.length()){
//             char ch=s.charAt(j);
//             if(!h.contains(ch)){
//                 h.add(ch);
//                 j++;
//             }
//             else{
//                h.remove(s.charAt(i));
//                  i++;

//             }
//             if(max<j-i)  max=j-i;
//        }
//        return max;
//     }
// }
