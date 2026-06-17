package com.example.designpattern.TicTacToe;

import com.example.designpattern.TicTacToe.Interface.SymbolEnum;

public class Board {

    SymbolEnum[][] matrix;
    int m , n;
    public Board(int m, int n){
        this.m = m;
        this.n = n;
        matrix = new SymbolEnum[m][n];
    }

    public void  printEmptyCellNo(){
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==null){
                    System.out.print(i*n+j+" | ");
                }else{
                    System.out.print(matrix[i][j]+" | ");
                }
            }
            System.out.println("");
        }
    }

    public int isGameCompleted(SymbolEnum targetEnum){
        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++){
            int j;
            for(j=0; j<n; j++){
                if(matrix[i][j]==null || !targetEnum.equals(matrix[i][j]))
                    break;
            }
            if(j==n) return 2;
        }
        
        for(int i=0; i<n; i++){
            int j;
            for(j=0; j<m; j++){
                if(matrix[j][i]==null || !targetEnum.equals(matrix[j][i]))
                    break;
            }
            if(j==m) return 2;
        }
        boolean valid = true;
        for(int i=0; i<m; i++){
           if(matrix[i][i]==null || !targetEnum.equals(matrix[i][i])) {
                valid = false;
                break;
           } 
        }
        if(valid) return 2;
        valid = true;
        for(int i=0; i<m; i++){
            if(matrix[i][n-i-1]==null || !targetEnum.equals(matrix[i][n-i-1])){
                valid = false;
                break;
            }
        }
        if(valid) return 2;
        return 1;
    } 

    public boolean fillPlayerSymbol(int cellNo, TTTPlayer P){
        int n = matrix[0].length;
        int row = cellNo/n, col = cellNo%n;
        if(matrix[row][col]!=null) return false;
        matrix[row][col] = P.getSymbol();
        return true;
    }

    public int getRows(){
        return m;
    }
    public int getCols(){
        return n;
    }
}
