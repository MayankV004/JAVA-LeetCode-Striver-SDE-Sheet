class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
       
        Map<String , List<String>> graph = new HashMap<>();
        Map<String , Integer> indegree = new HashMap<>();

        for(String recipe : recipes){
            indegree.put(recipe , 0); // initializing indegree to 0 for all recipes
        }

        // graph building
        for(int i = 0 ; i < recipes.length ; i++){
            String recipe = recipes[i];

            List<String> recipeIngredients = ingredients.get(i);
            // The in-degree of this recipe is the total number of ingredients it requires
            indegree.put(recipe , recipeIngredients.size());

            for(String ingredient : recipeIngredients){
                graph.putIfAbsent(ingredient , new ArrayList<>());
                graph.get(ingredient).add(recipe);
            }

        }

        Queue<String>q = new ArrayDeque<>();

        // Add all initial supplies to the queue
        for(String supply : supplies){
            q.offer(supply);
        }

        List<String> cookedRecipes = new ArrayList<>();

        // Put recipes in a set for O(1) lookups to see if our processed node is a recipe
        Set<String> recipeSet = new HashSet<>(Arrays.asList(recipes));

        // toposort
        while(!q.isEmpty()){
            String current = q.poll();
            // If the current item is a recipe, it means it has been successfully created
            if(recipeSet.contains(current)){
                cookedRecipes.add(current);
            }
            // If other recipes depend on this item, reduce their in-degree
            if(graph.containsKey(current)){
                for(String nextRecipe : graph.get(current)){
                    indegree.put(nextRecipe , indegree.get(nextRecipe)-1);

                    // If all ingredients are available, we can now make this recipe
                    if(indegree.get(nextRecipe) == 0){
                        q.offer(nextRecipe);
                    }
                }
            }
        }

        return cookedRecipes;

    }
}