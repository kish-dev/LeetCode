fun main() {
    val listOne = ListNode(1)
    listOne.next = ListNode(4)
    listOne.next!!.next = ListNode(5)


    val listTwo = ListNode(1)
    listTwo.next = ListNode(3)
    listTwo.next!!.next = ListNode(4)

    val listThree = ListNode(2)
    listThree.next = ListNode(6)

    val arrayList : Array<ListNode?> = arrayOf(listOne, listTwo, listThree)
    mergeKLists(arrayList)
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val binaryTree = BinaryTree(null)
    for(i in lists) {
        var current = i
        while(current != null) {
            binaryTree.add(current!!.value)
            current = current.next
        }
    }
    return binaryTree.walk(binaryTree.root)
}

class ListNode(var value: Int) {
         var next: ListNode? = null
     }

class Node(
    var left: Node?,
    var right: Node?,
    var value: Int
)

class BinaryTree(var root: Node?) {

    var start: ListNode? = null
    var last: ListNode? = start

    fun add(value: Int) {
        if (root === null) {
            root = Node(null, null, value)
        } else {
            var prev: Node = root!!
            var temp: Node = root!!
            while (temp.left != null || temp.right != null) {
                prev = temp

                if (temp.value < value) {
                    if(temp.right === null) {
                        temp.right = Node(null, null, value)
                        return
                    }
                    temp = temp.right!!
                } else {
                    if(temp.left === null) {
                        temp.left = Node(null, null, value)
                        return
                    }
                    temp = temp.left!!
                }


            }
            if (temp.value < value) {
                temp.right = Node(null, null, value)
            } else {
                temp.left = Node(null, null, value)
            }
        }
    }

    fun walk(node: Node?) : ListNode? {
        if (node != null) {
            walk(node.left)
            if (start === null) {
                start = ListNode(node.value)
                last = start
            } else {
                last!!.next = ListNode(node.value)
                last = last!!.next
            }

            walk(node.right)
        }
        return start
    }

}


