package com.binarytree;

public class ArvoreBinaria {
    public Node AddNode(int value, Node raiz){
        if(raiz == null){
            raiz = new Node(value);
        }
        else if(value > raiz.Value)
        {
            raiz.RightNode = AddNode(value, raiz.RightNode);
        }
        else {
            raiz.LeftNode = AddNode(value, raiz.LeftNode);
        }

        return raiz;
    }

    public void Exibir(SearchType type, Node raiz){
        switch (type){
            case MAIOR:
                System.out.print("Maior Valor:" + BuscaMaior(raiz, raiz).Value);
                break;
            case MENOR:
                System.out.print("Menor Valor:" + BuscaMenor(raiz, raiz).Value);
                break;
            case INORDEM:
                System.out.print("InOrdem: ");
                ExibeInOrdem(raiz);
                break;
            case POSORDEM:
                System.out.print("PosOrdem: ");
                ExibePosOrdem(raiz);
                break;
            case PREORDEM:
                System.out.print("PreOrdem: ");
                ExibePreOrdem(raiz);
                break;
        }
        System.out.println();
    }

    private Node BuscaMaior(Node raiz, Node maiorValor){

        if(maiorValor.Value < raiz.Value)
            maiorValor = raiz;

        if(raiz.LeftNode != null)
            maiorValor = BuscaMaior(raiz.LeftNode, maiorValor);
        if(raiz.RightNode != null)
            maiorValor = BuscaMaior(raiz.RightNode, maiorValor);

        return maiorValor;
    }

    private Node BuscaMenor(Node raiz, Node menorValor){

        if(menorValor.Value > raiz.Value)
            menorValor = raiz;

        if(raiz.LeftNode != null)
            menorValor = BuscaMenor(raiz.LeftNode, menorValor);
        if(raiz.RightNode != null)
            menorValor = BuscaMenor(raiz.RightNode, menorValor);

        return menorValor;
    }

    private void ExibeInOrdem(Node raiz){
        if(raiz == null)
            return;

        ExibeInOrdem(raiz.LeftNode);
        System.out.print(raiz.Value + ", ");
        ExibeInOrdem(raiz.RightNode);
    }
    private void ExibePreOrdem(Node raiz){
        if(raiz == null)
            return;

        System.out.print(raiz.Value + ", ");
        ExibePreOrdem(raiz.LeftNode);
        ExibePreOrdem(raiz.RightNode);
    }
    private void ExibePosOrdem(Node raiz){
        if(raiz == null)
            return;

        ExibePosOrdem(raiz.LeftNode);
        ExibePosOrdem(raiz.RightNode);
        System.out.print(raiz.Value + ", ");
    }

    public void Delete(Node root, int target, Node daddy){
        if(root == null)
            return;

        if(root.Value > target){
            Delete(root.LeftNode, target, root);
        }
        else if(root.Value < target){
            Delete(root.RightNode, target, root);
        }
        else{
            if(daddy == null){
                System.out.println("Imagino que uma arvore deixa de ser uma arvore se não existir nada nela, né?");
                return;
            }
            else if(daddy.LeftNode == root){
                daddy.LeftNode = GetSubstitute(root);
            }
            else {
                daddy.RightNode = GetSubstitute(root);
            }
        }
    }

    private Node GetSubstitute(Node root){
        if (root.LeftNode == null && root.RightNode == null)
        {
            root = null;
        }
        else if(root.LeftNode == null){
            Node temp = root;
            root = root.RightNode;
            temp = null;
        }
        else if(root.RightNode == null){
            Node temp = root;
            root = root.LeftNode;
            temp = null;
        }

        return root;
    }


    public void Print(Node node){


        System.out.println("Current node value " + node.Value);
        if(node.RightNode != null){
            Print(node.RightNode);

        }

        if(node.LeftNode != null){

            Print(node.LeftNode);
        }

    }
}
