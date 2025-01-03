package edu.ensign.cs335.assignment12.structure.tree;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Cannot add null to the tree");
        }
        root = addRecursive(root, t);
    }

    private BinaryTreeNode<T> addRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return new BinaryTreeNode<>(value);
        }

        int compareResult = value.compareTo(current.getData());
        if (compareResult < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    @Override
    public T getRoot() {
        return (root != null) ? root.getData() : null;
    }

    @Override
    public boolean delete(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Cannot delete null from the tree");
        }

        boolean[] deleted = {false};
        root = deleteRecursive(root, t, deleted);
        return deleted[0];
    }

    private BinaryTreeNode<T> deleteRecursive(BinaryTreeNode<T> current, T value, boolean[] deleted) {
        if (current == null) {
            return null;
        }

        int compareResult = value.compareTo(current.getData());
        if (compareResult < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), value, deleted));
        } else if (compareResult > 0) {
            current.setRight(deleteRecursive(current.getRight(), value, deleted));
        } else {
            deleted[0] = true;
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            T smallestValue = findMin(current.getRight());
            current.setData(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue, new boolean[]{false}));
        }
        return current;
    }

    private T findMin(BinaryTreeNode<T> node) {
        return node.getLeft() == null ? node.getData() : findMin(node.getLeft());
    }

    @Override
    public T find(T t) {
        if (t == null) {
            return null;
        }
        return findRecursive(root, t);
    }

    private T findRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return null;
        }

        int compareResult = value.compareTo(current.getData());
        if (compareResult == 0) {
            return current.getData();
        }
        return compareResult < 0
                ? findRecursive(current.getLeft(), value)
                : findRecursive(current.getRight(), value);
    }

    @Override
    public String preOrder() {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        preOrderTraversal(root, result);
        return result.toString();
    }

    private void preOrderTraversal(BinaryTreeNode<T> node, StringBuilder result) {
        if (node != null) {
            result.append(node.getData()).append(" ");
            preOrderTraversal(node.getLeft(), result);
            preOrderTraversal(node.getRight(), result);
        }
    }

    @Override
    public String inOrder() {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        inOrderTraversal(root, result);
        return result.toString();
    }

    private void inOrderTraversal(BinaryTreeNode<T> node, StringBuilder result) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), result);
            result.append(node.getData()).append(" ");
            inOrderTraversal(node.getRight(), result);
        }
    }

    @Override
    public String postOrder() {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        postOrderTraversal(root, result);
        if (result.length() > 0) { // Ensure substring is safe
            result.setLength(result.length() - 1); // Remove trailing space
        }
        return result.toString();
    }

    private void postOrderTraversal(BinaryTreeNode<T> node, StringBuilder result) {
        if (node != null) {
            postOrderTraversal(node.getLeft(), result);
            postOrderTraversal(node.getRight(), result);
            result.append(node.getData()).append(" ");
        }
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }

        // Define the maximum depth and width
        int depth = 11; // Max depth of the tree
        int width = 160; // Max width of the tree layout
        String[][] buffer = new String[depth][width];

        // Fill the buffer with spaces
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                buffer[i][j] = " ";
            }
        }

        // Build the tree into the buffer
        buildTreeString(root, 0, width / 2, buffer, width);

        // Combine the buffer into a single string
        StringBuilder result = new StringBuilder();
        for (String[] row : buffer) {
            result.append(String.join("", row)).append("\n");
        }

        return result.toString();
    }


    private void buildTreeString(BinaryTreeNode<T> node, int depth, int position, String[][] buffer, int width) {
        if (node == null) {
            return;
        }

        // Place the current node in the buffer
        buffer[depth][position] = String.valueOf(node.getData());

        // Calculate child positions
        int offset = width / (int) Math.pow(2, depth + 2);

        // Add connections and recursively build left and right subtrees
        if (node.getLeft() != null) {
            buffer[depth + 1][position - offset / 2] = "┌";
            buffer[depth + 2][position - offset] = "┴";
            buildTreeString(node.getLeft(), depth + 2, position - offset, buffer, width);
        }
        if (node.getRight() != null) {
            buffer[depth + 1][position + offset / 2] = "┐";
            buffer[depth + 2][position + offset] = "┴";
            buildTreeString(node.getRight(), depth + 2, position + offset, buffer, width);
        }
    }

}
