fun main() {
    val listOne = ListNode(1)
//    listOne.next = ListNode(2)
//    listOne.next!!.next = ListNode(4)


    val listTwo = null
//    listTwo.next = ListNode(3)
//    listTwo.next!!.next = ListNode(4)
    mergeTwoLists(listOne, listTwo)

}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1 = l1
    var list2 = l2

    if (list1 == null && list2 == null) {
        return null
    }
    if (list2 == null) {
        return list1
    }
    if (list1 == null) {
        return list2
    }


    var start: ListNode? = null

    if (list1!!.`val` < list2!!.`val`) {
        start = ListNode(list1.`val`)
        list1 = list1.next
    } else {
        start = ListNode(list2.`val`)
        list2 = list2.next
    }
    var last: ListNode? = start
    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            last!!.next = ListNode(list1.`val`)

            list1 = list1.next
        } else {
            last!!.next = ListNode(list2.`val`)

            list2 = list2.next
        }
        last = last.next
    }

    if (list2 != null) {
        last!!.next = list2
    }
    if (list1 != null) {
        last!!.next = list1
    }
    return start
}

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(
    var left: Node?,
    var right: Node?,
    var value: Int
)



