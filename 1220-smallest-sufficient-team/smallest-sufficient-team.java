class Solution {
        int allSkills;
    People[] peoples;
    Team minTeam = new Team(0, 0);
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> peoples_list) {
        Map<String, Integer> skills_map = new HashMap<>();
        for (int index = 0; index < req_skills.length; index++) {
            skills_map.put(req_skills[index], 1 << index);
        }

        // Bit mask for all skills
        this.allSkills = (1 << req_skills.length) - 1;

        // Create peoples, record original index, convert skills to bit mask
        int peoplesCount = peoples_list.size();
        People[] allpeoples = new People[peoplesCount];
        for (int index = 0; index < peoplesCount; index++) {
            int skills = 0;
            for (String sk : peoples_list.get(index)) {
                skills |= skills_map.get(sk);
            }
            // This people has all skills, return
            if (skills == allSkills) {
                return new int[] {index};
            }
            allpeoples[index] = new People(index, skills);
        }

        // Prune peoples, keep minimum set of peoples which have required skills
        this.peoples = prune(allpeoples);

        dfs(0, new Team(0, 0));

        // `minTeam` contains the optimal smallest team
        int[] result = new int[minTeam.count];
        for (People people : peoples) {
            if ((minTeam.peoples & people.mask) != 0) {
                result[--minTeam.count] = people.index;
            }
        }

        return result;
    }

    // If P1's set of skills is superset of P2, then P2 is pruned
    // And obviously, peoples with empty set of skills are pruned
    private People[] prune(People[] allpeoples) {
        int peoplesCount = allpeoples.length;

        People[] prunePeoples = new People[peoplesCount];
        boolean[] prunes = new boolean[peoplesCount];
        int pruneCount = 0;
        for (int i = 0; i < peoplesCount; i++) {
            if (prunes[i]) {
                continue;
            }
            for (int j = i + 1; j < peoplesCount; j++) {
                int intersects = allpeoples[i].skills & allpeoples[j].skills;
                if (intersects == allpeoples[j].skills) {
                    prunes[j] = true;
                } else if (intersects == allpeoples[i].skills) {
                    prunes[i] = true;
                    break;
                }
            }
            if (!prunes[i]) {
                prunePeoples[pruneCount++] = allpeoples[i];
            }
        }

        return Arrays.copyOf(prunePeoples, pruneCount);
    }

    private void dfs(int skillset, Team localTeam) {
        
        if (skillset == this.allSkills) {
            // All skills filled, record optimal minTeam
            if (minTeam.count == 0 || minTeam.count > localTeam.count) {
                minTeam.peoples = localTeam.peoples;
                minTeam.count = localTeam.count;
            }
            return;
        }

        for (People people : peoples) {

             // Not an optimal team
            if ((minTeam.count > 0 && minTeam.count <= localTeam.count + 1)
                // This people has been added to team
                || (localTeam.peoples & people.mask) != 0) {
                continue;
            }

            // The right most missing skill required
            int rightMostSkill = ~skillset & (skillset + 1);
            if ((rightMostSkill & people.skills) != rightMostSkill) {
                continue;
            }

            // Add people and skills to team, solve remaining skills
            localTeam.peoples |= people.mask;
            localTeam.count++;

            dfs(skillset | people.skills, localTeam);

            // Remove people from team to try other possibilities
            localTeam.peoples ^= people.mask;
            localTeam.count--;
        }
    }

    static class Team {
        // Bit mask for peoples in the team.
        // Since there are at most 60 peoples, a 64 bits long is sufficient.
        long peoples;

        // Count of peoples in the team
        int count;

        Team(long peoples, int count) {
            this.peoples = peoples;
            this.count = count;
        }
    }

    static class People {
        // Original index of people
        final int index;
        // Bit mask for skills
        final int skills;
        // Bit mask for index
        final long mask;

        People(int index, int skills) {
            this.index = index;
            this.skills = skills;
            this.mask = 1L << index;
        }  
    }
}