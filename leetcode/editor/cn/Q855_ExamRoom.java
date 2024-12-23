//There is an exam room with n seats in a single row labeled from 0 to n - 1.
//
// When a student enters the room, they must sit in the seat that maximizes the
//distance to the closest person. If there are multiple such seats, they sit in
//the seat with the lowest number. If no one is in the room, then the student sits
//at seat number 0.
//
// Design a class that simulates the mentioned exam room.
//
// Implement the ExamRoom class:
//
//
// ExamRoom(int n) Initializes the object of the exam room with the number of
//the seats n.
// int seat() Returns the label of the seat at which the next student will set.
//
// void leave(int p) Indicates that the student sitting at seat p will leave
//the room. It is guaranteed that there will be a student sitting at seat p.
//
//
//
// Example 1:
//
//
//Input
//["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
//[[10], [], [], [], [], [4], []]
//Output
//[null, 0, 9, 4, 2, null, 5]
//
//Explanation
//ExamRoom examRoom = new ExamRoom(10);
//examRoom.seat(); // return 0, no one is in the room, then the student sits at
//seat number 0.
//examRoom.seat(); // return 9, the student sits at the last seat number 9.
//examRoom.seat(); // return 4, the student sits at the last seat number 4.
//examRoom.seat(); // return 2, the student sits at the last seat number 2.
//examRoom.leave(4);
//examRoom.seat(); // return 5, the student sits at the last seat number 5.
//
//
//
//
// Constraints:
//
//
// 1 <= n <= 10⁹
// It is guaranteed that there is a student sitting at seat p.
// At most 10⁴ calls will be made to seat and leave.
//
//
// Related Topics 设计 有序集合 堆（优先队列） 👍 294 👎 0

import java.util.TreeSet;

//Exam Room
public class Q855_ExamRoom{
    public static void main(String[] args) {
        ExamRoom solution = new Q855_ExamRoom().new ExamRoom(3);
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom {
        private TreeSet<Integer> students;
        private int n;

        public ExamRoom(int n) {
            this.n = n;
            this.students = new TreeSet<>();
        }

        public int seat() {
            int student = 0;
            if (students.size() > 0) {
                int dist = students.first();
                Integer prev = null;
                for (Integer s : students) {
                    if (prev != null) {
                        int d = (s - prev) / 2;
                        if (d > dist) {
                            dist = d;
                            student = prev + d;
                        }
                    }
                    prev = s;
                }
                if (n - 1 - students.last() > dist) {
                    student = n - 1;
                }
            }
            students.add(student);
            return student;
        }

        public void leave(int p) {
            students.remove(p);
        }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
