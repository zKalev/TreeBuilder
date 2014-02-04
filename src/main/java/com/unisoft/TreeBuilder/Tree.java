package com.unisoft.TreeBuilder;

import java.util.TreeSet;

public class Tree {

	private TreeNode node;
	private TreeSet<TreeNode> set;

	/**
	 * 
	 */
	public Tree() {
		// empty tree
		node = null;
		set = new TreeSet<>();
	}

	/**
	 * Add new node in the tree
	 * 
	 * @param nodeNum
	 * @param fatherNum
	 * @param info
	 */
	public void addNode(int nodeNum, int fatherNum, int info) {
		if (node == null) {
			node = new TreeNode(nodeNum, fatherNum, info, 1);
		} else {
			TreeNode newNode = new TreeNode(nodeNum, fatherNum, info);
			TreeNode fathrerNode = findNode(fatherNum, node);
			int newNodeHeight = fathrerNode.getHeight() + 1;
			newNode.setHeight(newNodeHeight);
			newNode.setFather(fathrerNode);
			fathrerNode.addChild(newNode);
		}
	}

	/**
	 * 
	 * 
	 * Find node in the tree
	 * 
	 * @param nodeNum
	 * @param node
	 * @return
	 */
	private TreeNode findNode(int nodeNum, TreeNode n) {

		if (n.getNodeNum() == nodeNum)
			return n;

		TreeNode tr = null;
		for (TreeNode i : n.getChildren()) {

			tr = findNode(nodeNum, i);
		}
		return tr;
	}

	/**
	 * Fill set with nodes that Have children but grade children
	 * 
	 * @param n
	 * @return
	 */
	private TreeNode getNodeThatHaveChildrenButGraidChildren(TreeNode n) {
		TreeNode tr = null;

		if (!n.isLeaf() && !n.hasGradeChildren()) {
			if (n != node)
				set.add(n);

		}

		for (TreeNode i : n.getChildren()) {
			tr = getNodeThatHaveChildrenButGraidChildren(i);
		}
		return tr;
	}

	/**
	 * Provide set with nodes that Have children but grade children
	 * 
	 * @return
	 */
	public TreeSet<TreeNode> getSetOfNodeThatHaveChildrenButGraidChildren() {
		getNodeThatHaveChildrenButGraidChildren(node);
		return set;
	}
}
