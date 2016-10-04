public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //Sort people by height as the first priority decreasingly, order as the second prioridy nondecreasingly
        Arrays.sort(people, new Comparator<int []> (){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return b[0] - a[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        List<int[]> list = new ArrayList();
        for(int[] cur: people) {
            list.add(cur[1], cur);
        }
        return list.toArray(new int[people.length][]);
    }
}