package binarytree

import java.util.Scanner


val scanner: Scanner = Scanner(System.`in`)
fun main() {
    val binaryTree = BinaryTreeCreationAndTraversal();
    val rootNode = binaryTree.createBinaryTree()
    println(rootNode)
    binaryTree.inOrder(rootNode)
    println()
    binaryTree.preOrder(rootNode)
    println()
    binaryTree.postOrder(rootNode)
}


class BinaryTreeCreationAndTraversal {
    fun createBinaryTree(): Node? {
        var root: Node? = null
        println("Enter data:")
        val data = scanner.nextInt()
        if (data == -1) return null
        root = Node(data)
        println("Enter Left for $data")
        root.left = createBinaryTree()
        println("Enter right for $data")
        root.roght = createBinaryTree()
        return root
    }


    fun inOrder(root: Node?) {
        if (root == null) return
        inOrder(root.left)
        print("${root.data} ")
        inOrder(root.roght)
    }

    fun preOrder(root:Node?){
        if (root==null) return
        print("${root.data} ")
        preOrder(root.left)
        preOrder(root.roght)
    }

    fun postOrder(root:Node?){
        if (root==null) return
        postOrder(root.left)
        postOrder(root.roght)
        print("${root.data} ")
    }

    class Node {
        var left: Node? = null
        var roght: Node? = null
        var data: Int = -1

        constructor(data: Int) {
            this.data = data
        }

    }


}

