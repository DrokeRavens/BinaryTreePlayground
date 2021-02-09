package com.binarytree;

public class Main {

    public static void main(String[] args) {
        int[] values = new int[] { 20, 5, 12, 36, 27, 45, 9, 2, 6, 17, 40, 9999 };
        ArvoreBinaria arvore = new ArvoreBinaria();
        Node root = null;
        for (int value: values) {
            root = arvore.AddNode(value, root);
        }

        arvore.Exibir(SearchType.MAIOR, root);
        arvore.Exibir(SearchType.MENOR, root);
        arvore.Exibir(SearchType.INORDEM, root);
        arvore.Exibir(SearchType.POSORDEM, root);
        arvore.Exibir(SearchType.PREORDEM, root);
    }
}
