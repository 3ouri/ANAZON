/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * @author Abdallah
 */
@Entity
@Table(name = "payment_info")
@NamedQueries({
    @NamedQuery(name = "PaymentInfo.findAll", query = "SELECT p FROM PaymentInfo p"),
    @NamedQuery(name = "PaymentInfo.findById", query = "SELECT p FROM PaymentInfo p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentInfo.findByCreditCardNum", query = "SELECT p FROM PaymentInfo p WHERE p.creditCardNum = :creditCardNum"),
    @NamedQuery(name = "PaymentInfo.findByCvs", query = "SELECT p FROM PaymentInfo p WHERE p.cvs = :cvs"),
    @NamedQuery(name = "PaymentInfo.findByExpirationDate", query = "SELECT p FROM PaymentInfo p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "PaymentInfo.findByPrintedName", query = "SELECT p FROM PaymentInfo p WHERE p.printedName = :printedName")})
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "credit_card_num")
    private Integer creditCardNum;
    @Column(name = "cvs")
    private Integer cvs;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Size(max = 255)
    @Column(name = "printed_name")
    private String printedName;
    @OneToMany(mappedBy = "paymentId")
    private List<Orders> ordersList;

    public PaymentInfo() {
    }

    public PaymentInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(Integer creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public Integer getCvs() {
        return cvs;
    }

    public void setCvs(Integer cvs) {
        this.cvs = cvs;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPrintedName() {
        return printedName;
    }

    public void setPrintedName(String printedName) {
        this.printedName = printedName;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
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
