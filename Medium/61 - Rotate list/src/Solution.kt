fun main() {
    var x = 1.0000
    var n = -2147483647

//    println(myPow(x,n))
    var l = ListNode(1)
    l.next = ListNode(2)
    println(rotateRight(l, 2)?.`val`)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    var size = 0
    var currentForSize = head
    while (currentForSize != null) {
        ++size
        currentForSize = currentForSize.next
    }

    if(size == 0 || size == 1) {
        return head
    }
    //получили исходный массив

    val currentK = k % size
    if(currentK == 0) {
        return head
    }


    if(size == 2 && currentK == 1) {
        var h = head
        var l = h!!.next
        l!!.next = ListNode(h.`val`)
        return l
    }

    var currentTail = head
    var prevTail = currentTail
    var sizeEnd = size

    while(sizeEnd != currentK) {
        prevTail = currentTail
        currentTail = currentTail!!.next
        --sizeEnd
    }

    var tail = currentTail
    while(tail!!.next != null) {
        tail = tail.next
    }

    prevTail!!.next = null
    tail!!.next = head
    return currentTail


}
