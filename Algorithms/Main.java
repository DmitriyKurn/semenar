import java.util.Date;
import java.util.jar.Attributes.Name;

class BinaryTree{
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        public boolean color;
    }
// красный ==> true, черный ==> false
  boolean color;
private int value;

  void Node(int value) {
    this.value = value;
    Object left = null;
    Object right = null;

// Новый узел, который создается, является всегда красного цвета.
    color = true;
  }

 public boolean find(int value){
        Node node = root;
        while(node != null){
            if(node.value == value){
                return true;
            }
            if(node.value < value){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return false;
    }

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else {
            insert(root, value);
            
            root = rebalance(root);
        }
    }
 
        private boolean insert(Node node, int value){
        if(node.value == value){
            return false;
        }
        if(node.value < value){
            if(node.right == null){
                node.right = new Node();
                node.right.value = value;
                return true;
            }else{
                boolean ok = insert(node.right, value);
                node.right = rebalance(node.right);
                return ok;
            }
        }else{
            if(node.left == null){
                node.left = new Node();
                node.left.value = value;
                return true;
            }else{
                boolean ok = insert(node.left, value);
                node.left = rebalance(node.left);
                return ok;
            }
                
        }

        private operations.Algorithms.BinaryTree.Node rebalance(operations.Algorithms.BinaryTree.Node left) {
            return null;
        }
        
        // Функция для поворота узла против часовой стрелки.
         Node rotateLeft(Node Node) {
         System.out.printf("поворот влево!!\n");
         Node child = Node.right;
         Node childLeft = child.left;

         child.left = Node;
         Node.right = childLeft;

         return child;
        }

         // Функция для поворота узла по часовой стрелке.
         Node rotateRight(Node Node) {
         System.out.printf("вращение вправо\n");
         Node child = Node.left;
         Node childRight = child.right;

         child.right = Node;
         Node.left = childRight;

         return child;
         }

         // Функция для проверки того, является ли узел красного цвета или нет.
         boolean isRed(Node Node) {
            if (Node == null) {
            return false;
          }
         return (Node.color == true);
         }

         // Функция для изменения цвета двух узлов.
         void swapColors(Node node1, Node node2) {
         boolean temp = node1.color;
         node1.color = node2.color;
         node2.color = temp;
        }
        
        // случай 1.
        // когда правый дочерний элемент красный, а левый дочерний элемент черный или не существует.
        if (void isRed(Node.right) && isRed(Node.left)) {
        // Повернуть узел  влево
        Node = rotateLeft(Node);

        // Поменять местами цвета дочернего узла всегда должен быть красным
        swapColors(Node, Node.left);
        }

        // случай 2
       // когда левый ребенок выделен красным цветом
       if (isRed(Node.left)) {
       // Повернуть узел в право
       Node = rotateRight(Node);
       swapColors(Node, Node.right);
      }

       // случай 3
      // когда и левый, и правый дочерние элементы окрашены в красный цвет.
      if (isRed(Node.left) && isRed(Node.right)) {
      // Инвертировать цвет узла это левый и правый дети.
      Node.color = !Node.color;

      // Изменить цвет на черный.
      Node.left.color = false;
      Node.right.color = false;
    }

    return Node;
  }

      
public class Main{
    public void main(String args[]){


        BinaryTree tree = new BinaryTree();


        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);


        int sgve=0;

    }
}



