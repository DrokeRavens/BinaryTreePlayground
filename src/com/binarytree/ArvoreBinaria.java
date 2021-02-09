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
                System.out.print("Maior Valor:" + BuscaMaior(raiz, raiz.Value));
                break;
            case MENOR:
                System.out.print("Menor Valor:" + BuscaMenor(raiz, raiz.Value));
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

    private int BuscaMaior(Node raiz, int maiorValor){

        if(maiorValor < raiz.Value)
            maiorValor = raiz.Value;

        if(raiz.LeftNode != null)
            maiorValor = BuscaMaior(raiz.LeftNode, maiorValor);
        if(raiz.RightNode != null)
            maiorValor = BuscaMaior(raiz.RightNode, maiorValor);

        return maiorValor;
    }

    private int BuscaMenor(Node raiz, int menorValor){

        if(menorValor > raiz.Value)
            menorValor = raiz.Value;

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
