package com.binarytree;

public class Main {

    public static void main(String[] args) {
        int[] values = new int[] { 20, 5, 12, 36, 27, 45, 9, 2, 6, 17, 40 };
        ArvoreBinaria arvore = new ArvoreBinaria();
        Node root = null;

        for(int i = 0; i < values.length; i++){
            if( i == 0)
                root = arvore.AddNode(values[0], root);
            else
                arvore.AddNode(values[i], root);
        }

        arvore.Exibir(SearchType.MAIOR, root);
        arvore.Exibir(SearchType.MENOR, root);
        arvore.Exibir(SearchType.INORDEM, root);
        arvore.Exibir(SearchType.POSORDEM, root);
        arvore.Exibir(SearchType.PREORDEM, root);
    }
}
