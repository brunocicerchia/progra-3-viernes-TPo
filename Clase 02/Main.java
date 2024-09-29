// Clase para representar un nodo del árbol
class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

// Clase BinarySearchTree
class BinarySearchTree {
    TreeNode root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Método para calcular la altura del árbol
    public int getHeight() {
        return getHeight(root);
    }

    // Método recursivo auxiliar para calcular la altura del árbol
    private int getHeight(TreeNode node) {
        // Caso base: si el nodo es nulo, la altura es -1 (árbol vacío)
        if (node == null) {
            return -1; 
        }

        // Recursivamente obtener la altura de los subárboles izquierdo y derecho
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // La altura del árbol es el máximo de las alturas de los subárboles más 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Método para insertar un nuevo nodo en el BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Método recursivo auxiliar para insertar un nuevo nodo
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
}

// Clase principal para probar el árbol
public class Main {
    public static void main(String[] args) {
        // Crear una instancia del árbol binario de búsqueda
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insertar nodos en el árbol binario de búsqueda
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        
        // Obtener y mostrar la altura del árbol
        System.out.println("La altura del árbol es: " + bst.getHeight());
    }
}
