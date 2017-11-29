package com.example.awesomefat.csc537_homework5_template;

/**
 * Created by awesomefat on 11/28/17.
 */

public class Node
{
    private int payload;
    private Node leftChild;
    private Node rightChild;

    public Node(int payload)
    {
        this.payload = payload;
        this.leftChild = null;
        this.rightChild = null;
    }

    //the rules of a binary tree are such that:
    //everything to the left of this node is <= it
    //everything to the right of this node is > it
    public void add(Node n)
    {
        //if his payload is <= my payload, try to add to leftChild
        if(n.getPayload() <= this.payload)
        {
            //if I don't have a left child, set n to be my leftChild
            if(this.leftChild == null)
            {
                this.leftChild = n;
            }
            else
            {
                //I already have a leftChild, so ask my leftChild to find a home for n
                this.leftChild.add(n);
            }
        }
        //if his payload is > my payload, try to add to rightChild
        else
        {
            //if I don't have a right child, set n to by my rightChild
            if(this.rightChild == null)
            {
                this.rightChild = n;
            }
            else
            {
                //I already have a rightChild, so ask my rightChild to find a home for n
                this.rightChild.add(n);
            }
        }
    }

    public int getPayload() {
        return payload;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
