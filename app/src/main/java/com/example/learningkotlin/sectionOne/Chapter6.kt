package com.example.learningkotlin.sectionOne

object Chapter6 {

    //functions - one thing
    //parameterized functions
    //parameters and arguments
    // fun sum(number1 : Int, number2 : Int) - number1 and number 2 are parameters
    //sum(10,20) - 10 and 20 are arguments
    //function overloading - same function name, different number of parameters, different type of parameters
    //function overloading - if only the return type is different, then that will give error

    val TAG = "${Chapter6::class.java}:"

    data class Node(val data: Int, var left: Node?, var right: Node?)

    fun createBST() {

        val root = Node(10, null, null)
        insertNode(20, root)
        insertNode(5, root)
        insertNode(50, root)
        insertNode(15, root)
        //storing functions as variables
        val inOrderTraversal = ::inOrder
        val preOrderTraversal = ::preOrder
        println("$TAG Printing in-Order traversal")
        printBST(inOrderTraversal, root)
        println("$TAG Printing pre-Order traversal")
        printBST(preOrderTraversal, root)
        println("$TAG Printing post-Order traversal")
        printBST(::postOrder, root)
    }

    private fun printBST(function: (Node?) -> Unit, root: Node) {
        function(root)
    }

    private fun inOrder(root: Node?) {
        if (root == null)
            return

        inOrder(root.left)
        println("$TAG ${root.data}")
        inOrder(root.right)
    }

    private fun preOrder(root: Node?) {
        if (root == null)
            return

        println("$TAG ${root.data}")
        preOrder(root.left)
        preOrder(root.right)
    }

    private fun postOrder(root: Node?) {
        if (root == null)
            return
        postOrder(root.left)
        postOrder(root.right)
        println("$TAG ${root.data}")
    }

    private fun insertNode(data: Int, root: Node) {

        var currentRoot: Node? = root
        var parentOfRoot: Node? = null
        val node = createNode(data)
        while (currentRoot != null) {
            if (data > currentRoot.data) {
                parentOfRoot = currentRoot
                currentRoot = currentRoot?.right
            } else if (data < currentRoot.data) {
                parentOfRoot = currentRoot
                currentRoot = currentRoot?.left
            }
        }

        parentOfRoot?.let {
            if (data > parentOfRoot.data) {
                parentOfRoot.right = node
            } else {
                parentOfRoot.left = node
            }
        }

        if (parentOfRoot == null) {
            if (data > root.data) {
                root.right = node
            } else {
                root.left = node
            }
        }

    }

    private fun createNode(data: Int): Node {
        return Node(data, null, null)
    }

    //This is an overloaded function
    private fun createNode(data: Int, left: Node?, right: Node?): Node {
        return Node(data, left, right)
    }

    //The below method only differs in return type, this will produce error
    /*
    private fun createNode(data: Int, left: Node?, right: Node?): Int {
        val node = Node(data, left, right)
        return 100
    }*/

}