/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nick
 */
@Entity
@Table(name = "payment_info")
@NamedQueries({
    @NamedQuery(name = "PaymentInfo.findAll", query = "SELECT p FROM PaymentInfo p"),
    @NamedQuery(name = "PaymentInfo.findById", query = "SELECT p FROM PaymentInfo p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentInfo.findByCreditCardNum", query = "SELECT p FROM PaymentInfo p WHERE p.creditCardNum = :creditCardNum"),
    @NamedQuery(name = "PaymentInfo.findByCvs", query = "SELECT p FROM PaymentInfo p WHERE p.cvs = :cvs"),
    @NamedQuery(name = "PaymentInfo.findByPrintedName", query = "SELECT p FROM PaymentInfo p WHERE p.printedName = :printedName"),
    @NamedQuery(name = "PaymentInfo.findByExpirationDate", query = "SELECT p FROM PaymentInfo p WHERE p.expirationDate = :expirationDate")})
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit_card_num")
    private int creditCardNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvs")
    private int cvs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "printed_name")
    private String printedName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @OneToMany(mappedBy = "paymentId")
    private Collection<Orders> ordersCollection;

    public PaymentInfo() {
    }

    public PaymentInfo(Integer id) {
        this.id = id;
    }

    public PaymentInfo(Integer id, int creditCardNum, int cvs, String printedName, Date expirationDate) {
        this.id = id;
        this.creditCardNum = creditCardNum;
        this.cvs = cvs;
        this.printedName = printedName;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public int getCvs() {
        return cvs;
    }

    public void setCvs(int cvs) {
        this.cvs = cvs;
    }

    public String getPrintedName() {
        return printedName;
    }

    public void setPrintedName(String printedName) {
        this.printedName = printedName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentInfo)) {
            return false;
        }
        PaymentInfo other = (PaymentInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anazon.model.PaymentInfo[ id=" + id + " ]";
    }
    
}
