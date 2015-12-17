/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.dao.impl;

import com.anazon.dao.PaymentInfoDAO;
import com.anazon.model.PaymentInfo;
import java.util.List;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

/**
 *
 * @author Abdallah
 */
public class PaymentInfoDAOImpl implements PaymentInfoDAO {

    private GeneralDAOImpl generalDAOImpl;

    public PaymentInfoDAOImpl() {
        generalDAOImpl = GeneralDAOImpl.getInstance();
    }

    @Override
    public List<PaymentInfo> getAll() {
        return generalDAOImpl.getAllObjects(PaymentInfo.class);
    }

    @Override
    public PaymentInfo add(PaymentInfo paymentInfo) {
        return generalDAOImpl.addObject(paymentInfo);
    }

    @Override
    public PaymentInfo get(long id) {
        Expression expression = new ExpressionBuilder().get("id").equal(id);
        return generalDAOImpl.getObjectByExpression(PaymentInfo.class, expression);
    }

    @Override
    public PaymentInfo update(PaymentInfo paymentInfo) {
        return generalDAOImpl.updateObject(paymentInfo);
    }

    @Override
    public PaymentInfo delete(PaymentInfo paymentInfo) {
        return generalDAOImpl.deleteObject(paymentInfo);
    }

    @Override
    public void deleteAll(List<PaymentInfo> selectedPaymentInfos) {
        generalDAOImpl.deleteAllObjects(selectedPaymentInfos);
    }

}
