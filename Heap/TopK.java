class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i: nums)
            map.put(i,map.getOrDefault(i,0)+1);

        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for(int i:map.keySet())
            heap.add(i);
        int arr[]=new int[k];

        for(int i=1;i<=k;i++)
            arr[i-1]=heap.poll();
        return arr;
    }
}