public class AVLTree {
    
    private Node node;

    public AVLTree() {
        this.node = null;
    }

    private int height(Node node) {
        if(node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public int getBalance(Node node) {
        if(node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void insert(int value) {
        System.out.println("Nodo insertar");
        node = insertRec(node, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("\tNodo insertado: " + newNode.getValue() +
             " | Balacen al insertar = " + getBalance(newNode));
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }
        System.out.println("Node actual: " + node.getValue());
        //Actualizar altura
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("\tAltura = " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("\tBalance = " + balance);

        //Caso Izquierda -Izquierda
        if(balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotación derecha");
        }

        //Caso derecha - derecha
        if(balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotación izquierda");
        }

        //Caso izquierda - dercha
        if(balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Cambio ");
            System.out.println("Rotación derecha");
        }

        //Caso derecha - izquierda
        if(balance < 1 && value < node.getRight().getValue()) {
            System.out.println("Cambio ");
            System.out.println("Rotación izquierda");
        }

        return node;
    }
}