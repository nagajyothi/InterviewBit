/*
 * Find shortest unique prefix to represent each word in the list.
 * 
 Example:
 
 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
public class Prefix{
    public static ArrayList<String> prefix(ArrayList<String> a) {
     ArrayList<String> res=new ArrayList<String>();
     HashMap<String, Integer> hm=new HashMap<String, Integer>();
        for(int k=0;k<A.size();k++){
            String s=A.get(k);
            for(int i=0;i<s.length();i++){
                String temp=s.substring(0,i+1);
                if(hm.containsKey(temp)){
                    hm.put(temp,hm.get(temp)+1);
                }
                else{
                    hm.put(temp,1);
                   
                }
            }
        }
        for(int k=0;k<A.size();k++){
            String s=A.get(k);
            for(int j=0;j<s.length();++j){
                String temp=s.substring(0,j+1);
                if(hm.get(temp)==1){
                    res.add(temp);
                    break;
                }
            }
        }
        return res; 
    }
}
