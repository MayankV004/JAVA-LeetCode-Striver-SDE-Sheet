class Solution {
    class DSU {
        private int[] parent, rank;
        int components;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return false; // already in same component

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            components--;
            return true;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DSU dsu = new DSU(n);

        Map<String, Integer> emailToAccountId = new HashMap<>();

        // union accounts sharing the emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailToAccountId.containsKey(email)) {
                    // If Not in map then we add the email with AccountID
                    emailToAccountId.put(email, i);
                } else {
                    // if already in map then we do UNION
                    dsu.union(i, emailToAccountId.get(email));
                }
            }

        }

        // parent -> emails
        Map<Integer, TreeSet<String>> merged = new HashMap<>();

        for (String email : emailToAccountId.keySet()) {
            int accountId = emailToAccountId.get(email);

            int parent = dsu.find(accountId);
            // Get the email set corresponding to this parent.
            // If the parent doesn't exist in the map yet, create a new TreeSet.
            // Finally, add the current email to that set.
            merged.computeIfAbsent(parent, k -> new TreeSet<>()).add(email);

            // other way to write above line
            // if (!merged.containsKey(parent)) {
            //     merged.put(parent, new TreeSet<>());
            // }

            // merged.get(parent).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int parent : merged.keySet()){
            
            List<String> current = new ArrayList<>();

            // add parent
            current.add(accounts.get(parent).get(0));

            // add sorted Emails
            current.addAll(merged.get(parent));

            ans.add(current);
        }

        return ans;

    }
}