package com.unisoft.TreeBuilder;

import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Comparable<TreeNode> {

	/**
	 * hold node's children
	 */
	private List<TreeNode> children;

	/**
	 * node's father
	 */
	private TreeNode father;
	
	private int info;
	private int nodeNum;
	private int fatherNum;
	private int height;

	/**
	 * @param nodeNum
	 * @param fatherNum
	 * @param info
	 * @param height
	 */
	public TreeNode(int nodeNum, int fatherNum, int info, int height) {
		this.info = info;
		this.nodeNum = nodeNum;
		this.fatherNum = fatherNum;
		this.height = height;
		children = new ArrayList<>();
	}

	/**
	 * @param nodeNum
	 * @param fatherNum
	 * @param info
	 */
	public TreeNode(int nodeNum, int fatherNum, int info) {
		this.info = info;
		this.nodeNum = nodeNum;
		this.fatherNum = fatherNum;
		children = new ArrayList<>();
	}

	/**
	 * 
	 */
	public TreeNode() {
		children = new ArrayList<>();
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("nodeNum:");
		sb.append(this.nodeNum);
		sb.append(",fatherNum:");
		sb.append(this.fatherNum);
		sb.append(",info:");
		sb.append(this.info);
		sb.append(",height:");
		sb.append(this.height);
		return sb.toString();
	}

	/**
	 * Check whether this node has grade children
	 * 
	 * @return
	 * 
	 */
	public boolean hasGradeChildren() {
		for (TreeNode n : this.children) {
			if (!n.isLeaf())
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TreeNode o) {

		if (this.getNodeNum() > o.getNodeNum())
			return -1;
		else if (this.getNodeNum() == o.getNodeNum())
			return 0;
		else
			return 1;
	}

	/**
	 * Check whether this node has children
	 * 
	 * @return
	 * 
	 */
	public boolean isLeaf() {
		return this.children.isEmpty();
	}

	// getters and setters

	public int getNodeNum() {
		return nodeNum;
	}

	public void setNodeNum(int nodeNum) {
		this.nodeNum = nodeNum;
	}

	public int getFatherNum() {
		return fatherNum;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setFatherNum(int fatherNum) {
		this.fatherNum = fatherNum;
	}

	public void addChild(TreeNode child) {
		this.children.add(child);
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public TreeNode getFather() {
		return father;
	}

	public void setFather(TreeNode father) {
		this.father = father;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
}
