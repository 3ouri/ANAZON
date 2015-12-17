/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anazon.service.impl;

import com.anazon.dao.PaymentInfoDAO;
import com.anazon.dao.impl.PaymentInfoDAOImpl;
import com.anazon.model.PaymentInfo;
import com.anazon.service.PaymentInfoService;
import java.util.List;

/**
 *
 * @author Abdallah
 */
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private PaymentInfoDAO paymentInfoDAO;

    public PaymentInfoServiceImpl() {
        paymentInfoDAO = new PaymentInfoDAOImpl();
    }

    @Override
    public List<PaymentInfo> getAll() {
        return paymentInfoDAO.getAll();
    }

    @Override
    public PaymentInfo add(PaymentInfo paymentInfo) {
        return paymentInfoDAO.add(paymentInfo);
    }

    @Override
    public PaymentInfo get(long id) {
        return paymentInfoDAO.get(id);
    }

    @Override
    public PaymentInfo update(PaymentInfo paymentInfo) {
        return paymentInfoDAO.update(paymentInfo);
    }

    @Override
    public PaymentInfo delete(PaymentInfo paymentInfo) {
        return paymentInfoDAO.delete(paymentInfo);
    }

    @Override
    public void deleteAll(List<PaymentInfo> selectedPaymentInfos) {
        paymentInfoDAO.deleteAll(selectedPaymentInfos);
    }

}
