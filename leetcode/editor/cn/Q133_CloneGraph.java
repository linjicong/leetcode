//Given a reference of a node in a connected undirected graph.
//
// Return a deep copy (clone) of the graph.
//
// Each node in the graph contains a value (int) and a list (List[Node]) of its
//neighbors.
//
//
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
//
//
//
//
// Test case format:
//
// For simplicity, each node's value is the same as the node's index (1-indexed)
//. For example, the first node with val == 1, the second node with val == 2, and
//so on. The graph is represented in the test case using an adjacency list.
//
// An adjacency list is a collection of unordered lists used to represent a
//finite graph. Each list describes the set of neighbors of a node in the graph.
//
// The given node will always be the first node with val = 1. You must return
//the copy of the given node as a reference to the cloned graph.
//
//
// Example 1:
//
//
//Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//Output: [[2,4],[1,3],[2,4],[1,3]]
//Explanation: There are 4 nodes in the graph.
//1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//
//
// Example 2:
//
//
//Input: adjList = [[]]
//Output: [[]]
//Explanation: Note that the input contains one empty list. The graph consists
//of only one node with val = 1 and it does not have any neighbors.
//
//
// Example 3:
//
//
//Input: adjList = []
//Output: []
//Explanation: This an empty graph, it does not have any nodes.
//
//
//
// Constraints:
//
//
// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given
//node.
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 753 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Clone Graph
public class Q133_CloneGraph{
    public static void main(String[] args) {
        Solution solution = new Q133_CloneGraph().new Solution();
        // 测试用例

    }
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆当前节点
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 将克隆节点存入哈希表
        visited.put(node, cloneNode);

        // 递归克隆邻居节点
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
