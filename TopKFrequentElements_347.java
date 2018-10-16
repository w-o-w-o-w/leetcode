import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
	 public List<Integer> topKFrequent(int[] nums, int k) {
         List<Integer>  result=new ArrayList<Integer>();
        Map<Integer, Integer> map=new HashMap<Integer,Integer>();
        
        for(int num:nums){
        	if(map.containsKey(num)){
        		map.put(num, map.get(num)+1);
        	}else{
        		map.put(num,	1);
        	}
        }
        
        result=sortByValue(map);
                
        return result.subList(0, k);
    }
	
	public List<Integer> sortByValue(final Map map) {
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });
        
        return list;
    }
}
