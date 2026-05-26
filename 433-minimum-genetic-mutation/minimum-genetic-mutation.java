class Solution {
    private static final char geneChoice[] = {'A','C','G','T'};

    static class Gene{
        String gene;
        int mutation;

        Gene (String gene , int mutation){
            this.gene = gene;
            this.mutation = mutation;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>();
        for(String s : bank){
            geneBank.add(s);
        }

        if(!geneBank.contains(endGene)) return -1;

        Queue<Gene> q = new ArrayDeque<>();
        q.offer(new Gene(startGene , 0));

        while(!q.isEmpty()){
            Gene currGene = q.poll();
            String gene = currGene.gene;
            int mutation = currGene.mutation;

            if(gene.equals(endGene)){
                return mutation;
            }

            for(int i = 0 ; i < 8 ; i++){
                StringBuilder sb = new StringBuilder(gene);
                for(char ch : geneChoice){
                    if(gene.charAt(i) == ch) continue;
                    
                    sb.setCharAt(i , ch);

                    String newGene = sb.toString();

                    if(geneBank.contains(newGene)){
                        q.offer(new Gene(newGene , mutation + 1));
                        geneBank.remove(newGene);
                    }
                }
            }
        }
        return -1;
    }
}