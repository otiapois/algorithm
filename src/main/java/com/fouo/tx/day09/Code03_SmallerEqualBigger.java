package com.fouo.tx.day09;

public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            i++;
        }

        cur = head;
        Node[] nodes = new Node[i];
        for (i = 0; i != nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }

        partition(nodes, pivot);

        for (i = 1; i != nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    private static void partition(Node[] nodes, int pivot) {
        int small = -1;
        int index = 0;
        int big = nodes.length;

        while (index < big) {
            if (nodes[index].value == pivot) {
                index++;
            } else if (nodes[index].value < pivot) {
                swap(nodes, index++, ++small);
            } else {
                swap(nodes, --big, index);
            }
        }
    }
//	public static Node listPartition1(Node head, int pivot) {
//		if (head == null) {
//			return head;
//		}
//		Node cur = head;
//		int i = 0;
//		while (cur != null) {
//			i++;
//			cur = cur.next;
//		}
//		Node[] nodeArr = new Node[i];
//		cur = head;
//		for (i = 0; i != nodeArr.length; i++) {
//			nodeArr[i] = cur;
//			cur = cur.next;
//		}
//
//
//		arrPartition(nodeArr, pivot);
//
//		for (i = 1; i != nodeArr.length; i++) {
//			nodeArr[i - 1].next = nodeArr[i];
//		}
//		nodeArr[i - 1].next = null;
//		return nodeArr[0];
//	}
//
//	public static void arrPartition(Node[] nodeArr, int pivot) {
//		int small = -1;
//		int big = nodeArr.length;
//		int index = 0;
//		while (index != big) {
//			if (nodeArr[index].value < pivot) {
//				swap(nodeArr, ++small, index++);
//			} else if (nodeArr[index].value == pivot) {
//				index++;
//			} else {
//				swap(nodeArr, --big, index);
//			}
//		}
//	}

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node mh = null;
        Node mt = null;

        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (st == null) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.value == pivot) {
                if (et == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (mt == null) {
                    mh = head;
                    mt = head;
                } else {
                    mt.next = head;
                    mt = head;
                }
            }
            head = next;
        }

        if (st != null) {
            st.next = eh;
            et = et != null ? et : st;
        }

        if (et != null) {
            et.next = mh;
        }
        return sh != null ? sh : (eh != null ? eh : mh);
    }
//    public static Node listPartition2(Node head, int pivot) {
//        Node sH = null; // small head
//        Node sT = null; // small tail
//        Node eH = null; // equal head
//        Node eT = null; // equal tail
//        Node mH = null; // big head
//        Node mT = null; // big tail
//        Node next = null; // save next node
//        // every node distributed to three lists
//        while (head != null) {
//            next = head.next;
//            head.next = null;
//            if (head.value < pivot) {
//                if (sH == null) {
//                    sH = head;
//                    sT = head;
//                } else {
//                    sT.next = head;
//                    sT = head;
//                }
//            } else if (head.value == pivot) {
//                if (eH == null) {
//                    eH = head;
//                    eT = head;
//                } else {
//                    eT.next = head;
//                    eT = head;
//                }
//            } else {
//                if (mH == null) {
//                    mH = head;
//                    mT = head;
//                } else {
//                    mT.next = head;
//                    mT = head;
//                }
//            }
//            head = next;
//        }
//        // 小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
//        if (sT != null) { // 如果有小于区域
//            sT.next = eH;
//            eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
//        }
//        // 下一步，一定是需要用eT 去接 大于区域的头
//        // 有等于区域，eT -> 等于区域的尾结点
//        // 无等于区域，eT -> 小于区域的尾结点
//        // eT 尽量不为空的尾巴节点
//        if (eT != null) { // 如果小于区域和等于区域，不是都没有
//            eT.next = mH;
//        }
//        return sH != null ? sH : (eH != null ? eH : mH);
//    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(7);
        printLinkedList(head1);
//        head1 = listPartition1(head1, 7);
        head1 = listPartition2(head1, 7);
        printLinkedList(head1);

    }

}
