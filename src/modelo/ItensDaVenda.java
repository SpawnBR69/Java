/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author igorm
 */
public class ItensDaVenda {
    private Integer IdIDV;
    private Produto IdProduto;
    private int QtdProd;
    private Venda IdVendas;
    private double SubTotal;

    public Produto getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(Produto IdProduto) {
        this.IdProduto = IdProduto;
    }
    

    public int getQtdProd() {
        return QtdProd;
    }

    public void setQtdProd(int QtdProd) {
        this.QtdProd = QtdProd;
    }

    public Integer getIdIDV() {
        return IdIDV;
    }

    public void setIdIDV(Integer IdIDV) {
        this.IdIDV = IdIDV;
    }

    public Venda getIdVendas() {
        return IdVendas;
    }

    public void setIdVendas(Venda IdVendas) {
        this.IdVendas = IdVendas;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.IdIDV);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensDaVenda other = (ItensDaVenda) obj;
        if (!Objects.equals(this.IdIDV, other.IdIDV)) {
            return false;
        }
        return true;
    }

    

     
}
