//A transformation sequence from word beginWord to word endWord using a
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
//to be in wordList.
// sk == endWord
//
//
// Given two words, beginWord and endWord, and a dictionary wordList, return
//all the shortest transformation sequences from beginWord to endWord, or an empty
//list if no such sequence exists. Each sequence should be returned as a list of
//the words [beginWord, s1, s2, ..., sk].
//
//
// Example 1:
//
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//Explanation: There are 2 shortest transformation sequences:
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
//
//
// Example 2:
//
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: []
//Explanation: The endWord "cog" is not in wordList, therefore there is no
//valid transformation sequence.
//
//
//
// Constraints:
//
//
// 1 <= beginWord.length <= 5
// endWord.length == beginWord.length
// 1 <= wordList.length <= 500
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
// The sum of all shortest transformation sequences does not exceed 10⁵.
//
//
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 734 👎 0

import java.util.*;

//Word Ladder II
public class Q126_WordLadderIi{
    public static void main(String[] args) {
        Solution solution = new Q126_WordLadderIi().new Solution();
        // 测试用例
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.findLadders("hit", "cog", wordList));
        List<String> wordList2 = Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz");
        System.out.println(solution.findLadders("aaaaa", "ggggg", wordList2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

            public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
                List<List<String>> res = new ArrayList<>();
                Set<String> dict = new HashSet<>(wordList);
                if (!dict.contains(endWord)) {
                    return res;
                }
                dict.remove(beginWord);

                Map<String, Integer> steps = new HashMap<>();
                steps.put(beginWord, 0);
                Map<String, Set<String>> from = new HashMap<>();
                boolean found = bfs(beginWord, endWord, dict, steps, from);

                if (found) {
                    Deque<String> path = new ArrayDeque<>();
                    path.add(endWord);
                    dfs(from, path, beginWord, endWord, res);
                }
                return res;
            }


            private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from) {
                int wordLen = beginWord.length();
                int step = 0;
                boolean found = false;

                Queue<String> queue = new LinkedList<>();
                queue.offer(beginWord);
                while (!queue.isEmpty()) {
                    step++;
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        String currWord = queue.poll();
                        char[] charArray = currWord.toCharArray();
                        for (int j = 0; j < wordLen; j++) {
                            char origin = charArray[j];
                            for (char c = 'a'; c <= 'z'; c++) {
                                charArray[j] = c;
                                String nextWord = String.valueOf(charArray);
                                if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                                    from.get(nextWord).add(currWord);
                                }

                                if (!dict.contains(nextWord)) {
                                    continue;
                                }
                                dict.remove(nextWord);
                                queue.offer(nextWord);
                                from.putIfAbsent(nextWord, new HashSet<>());
                                from.get(nextWord).add(currWord);
                                steps.put(nextWord, step);
                                if (nextWord.equals(endWord)) {
                                    found = true;
                                }
                            }
                            charArray[j] = origin;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                return found;
            }

            private void dfs(Map<String, Set<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
                if (cur.equals(beginWord)) {
                    res.add(new ArrayList<>(path));
                    return;
                }
                for (String precursor : from.get(cur)) {
                    path.addFirst(precursor);
                    dfs(from, path, beginWord, precursor, res);
                    path.removeFirst();
                }
            }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
