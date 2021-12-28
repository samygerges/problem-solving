package leetcode;

import java.util.*;

public class PossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supp = new HashSet<>();
        Map<String, Boolean> canMake = new HashMap<>();
        for (String s : supplies) {
            supp.add(s);
            canMake.put(s, true);
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], new HashSet<>());
            for (String s : ingredients.get(i)) {
                map.get(recipes[i]).add(s);
            }
        }

        Set<String> visited = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for (String s : recipes) {
            if (canMakeRecipe(s, map, canMake, visited)) {
                answer.add(s);
            }
        }

        return answer;
    }

    private boolean canMakeRecipe(String recipe, Map<String, Set<String>> map, Map<String, Boolean> canMake, Set<String> visited) {
        if (canMake.containsKey(recipe)) {
            return canMake.get(recipe);
        }

        visited.add(recipe);

        if (map.containsKey(recipe)) {
            for (String ing : map.get(recipe)) {
                if ((!canMake.containsKey(ing) && visited.contains(ing)) || !canMakeRecipe(ing, map, canMake, visited)) {
                    canMake.put(ing, false);
                    return false;
                }
            }
            canMake.put(recipe, true);
            return true;
        }
        canMake.put(recipe, false);
        return false;
    }
}
