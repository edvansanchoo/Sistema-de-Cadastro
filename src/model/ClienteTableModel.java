/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author edvan
 */
public class ClienteTableModel extends AbstractTableModel{
    /* Array do tipo cliente para guardar todos os clientes cadastrados*/
    private List<Cliente> dados = new ArrayList<>();
    /*Criando uma String que vai ter os nomes das colunas da tabela*/
    private String[] coluna = {"Nome", "Nasc", "RG", "CPF", "Endereco", "Celular"};

    /*Metodo que retorna o nome das colunas*/
    @Override
    public String getColumnName(int nomeColuna) {
        return this.coluna[nomeColuna]; //To change body of generated methods, choose Tools | Templates.
    }   
    /*Metodo que retorna a quantidade de linhas*/
    @Override
    public int getRowCount() {
        return dados.size();
    }
    /*Metodo que retorna a quantidade de colunas*/
    @Override
    public int getColumnCount() {
        return coluna.length;
    }
    
    /*Metodo que retorna os itens do obejeto cadastrado na lista*/
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getNascimento();
            case 2:
                return dados.get(linha).getRg();
            case 3:
                return dados.get(linha).getCpf();
            case 4:
                return dados.get(linha).getEndereco();
            case 5:
                return dados.get(linha).getCelular();
        }
        return null;
    }

    /*Metodo que troca os valores dos itens do objeto*/
    @Override
    public void setValueAt(Object campo, int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setNome((String) campo);
                break;
            case 1:
                dados.get(linha).setNascimento((String)campo);
            case 2:
                dados.get(linha).setRg((String)campo);
            case 3:
                dados.get(linha).setCpf((String) campo);
            case 4:
                dados.get(linha).setEndereco((String) campo);
            case 5:
                dados.get(linha).setCelular((String) campo);
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    /* Metodo que adiciona um Cliente na lista*/
    public void addRow(Cliente c){
        dados.add(c);
        this.fireTableDataChanged();
    }
    
    /*Metodo que remove um Cliente da lista*/
    public void removeRow(int linha){
        dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
